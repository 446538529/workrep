package com.mideadc.component.llwallet.accp;

import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.RSAUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llwallet.accp.bean.*;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AccpApi {
    private static final Logger LOG = LoggerFactory.getLogger(AccpApi.class);
    // 私钥
    public static String PRI_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKZGXpmfgya2gGh6UdFPqPqi6e2z/HX4aIlMH394FOXTVwErnSGY5S0YFw5WskJrQLU2RHwFiA5P9Yt8VPxwgLDpdIm1/a7NlyjvWNvBd8V7wyITH8teJA1Ae5yWmRRrWFcVRSjpBq3xfwv76lVl+Nq/jR08p/ugVYJgtYEIM53JAgMBAAECgYA17SarPj+j45a7y8gTUXmlaAbkb/ZWMG1+8fBZQBHPA/74wzNf/R1+xYxcuyNvRSekXehSLN0WfzpMtdM+WCJ0ODqHRFsbAxmi784hzBZHOAxoJV49P8PVy6HIPthXxiSNUcacSt/HKJrUI6zACpymJLiVxMb9GqQAyx3BJl7rjQJBANG+RDszZYl3J1z1AtD0WggycrH2YOB7v5o3qKOz2AQ6CHWApSN6cuvqFwaUtHK9gMpDhvWR6zbYVRP+f4AxoQ8CQQDK8fTkpHNrHc011E8jjk3Uq5PWTJ0jAvcqk4rqZa4eV9953YSJYtJ2Fk2JnL3Ba7AU+qStnyD6MvSIpwIPSaOnAkEAptbFaZ4Jn55jdmMC2Xn1f925NGx6RTbKg37Qq18sbrhG8Ejjk2QctCIiLL7vBvJM1xd97CslQhw1GNFxVGSl6wJAQzwFtfoFgudMpRjBXzY18s8lG0omhQLmf+SBkUY+eS8Diowo7Jsgvp6E8aJL+1iB7XFcPWkKs9lNyjgKJqZu4QJAM22ULfWKrNIqaBJaYDmQSupUkHR/WL5rQJtAuVo8Zg3+rBrtMTXfIHJpR0MNpMgRSsPK6pZ3n4i+VvC5WxKUzA==";
    public static String YT_PUB_KEY = "xxx";
    // 用户所属商户号
    public static String OID_PARTNER = "201408071000001539";
    //交易流水结果查询
    public static String QUERY_TXN="htttps://accpapi.lianlianpay.com/v1/acctmgr/query-txn";
    //支付统一创单
    public static String TRADE_CREATE="https://accpapi.lianlianpay.com/v1/txn/tradecreate";
    //银行卡快捷支付
    public static String BANKCARD_PAY="https://accpapi.lianlianpay.com/v1/txn/payment-bankcard";
    //余额支付
    public static String BALANCE_PAY="https://accpapi.lianlianpay.com/v1/txn/payment-balance";
    //交易二次短信验证
    public static String SECOND_SMS_VALID="https://accpapi.lianlianpay.com/v1/txn/validation-sms";
    //提现申请
    public static String WITHDRAW_CASH="https://accpapi.lianlianpay.com/v1/txn/withdrawal";
    //提现结果查询
    public static String WITHDRAW_CASH_QUERY="https://accpapi.lianlianpay.com/v1/txn/query-withdrawal";
    //退款
    public static String REFUND="https://accpapi.lianlianpay.com/v1/txn/refund";
    //担保交易确认
    public static String SECURED_CONFIRM="https://accpapi.lianlianpay.com/v1/txn/secured-confirm";
    //代发申请
    public static String TRANSFER="https://accpapi.lianlianpay.com/v1/txn/transfer";
    private static <T> T postData(BaseParamsReq req, String url, T respObj) {
        try {
            req.setOid_partner(req.getOid_partner() != null ? req.getOid_partner() : OID_PARTNER);
            req.setSign_type("RSA");
            String sign = SignUtil.signByRSA(req, PRI_KEY);
            req.setSign(sign);
            String jsonData = JsonUtil.toJson1(req);
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json;charset=UTF-8 ");
            String resp = HttpUtil.post(url, null, headers, jsonData);
            if (LOG.isDebugEnabled()) {
                LOG.debug("请求ACCP  API返回结果：{}", resp);
            }
            Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
            resultMap = removeEmptyValue(resultMap);
            String ret_code = resultMap.get("ret_code");
            String returnSign = resultMap.get("sign");
            resultMap.remove("sign");
            if ("0000".equals(ret_code)) {
                if (RSAUtil.checkSign(YT_PUB_KEY, SignUtil.createLinkString(resultMap), returnSign)) {
                    return (T) JsonUtil.fromJson(resp, respObj.getClass());
                } else {
                    LOG.warn("请求ACCP  API返回结果验签失败：{}", resp);
                    return null;
                }
            } else {
                if (LOG.isWarnEnabled()) {
                    LOG.warn("请求ACCP  API未成功：{}", resp);
                }
                return (T) JsonUtil.fromJson(resp, respObj.getClass());
            }
        } catch (Exception e) {
            LOG.error("请求ACCP  API时出错", e);
        }
        return null;
    }
    private static Map<String, String> removeEmptyValue(Map<String, String> map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String key = iterator.next().toString();
            String value = map.get(key);
            if (value.isEmpty()) {
                iterator.remove();
            }
        }
        return map;
    }

    /**
     * 支付统一创单
     * @param req 支付创单所有参数的封装
     * @return TradeCreateResp类型，创单结果
     */
    public static TradeCreateResp createTrade(TradeCreateReq req){
        return postData(req,TRADE_CREATE,new TradeCreateResp());
    }

    /**
     * 银行卡快捷支付
     * @param req 银行卡快捷支付请求参数封装
     * @return BankcardPayResp类型 支付响应
     */
    public static BankcardPayResp bankcardPay(BankcardPayReq req){
        return postData(req,BANKCARD_PAY,new BankcardPayResp());
    }

    /**
     * 商户系统用户余额支付
     * @param req 余额支付请求参数封装
     * @return BalancePayResp 支付响应
     */
    public static BalancePayResp balancePay(BalancePayReq req){
        return postData(req,BALANCE_PAY,new BalancePayResp());
    }

    /**
     * 充值、消费、提现、代发类交易需要二次进行付款方短信验证
     * @param req 验证请求参数封装
     * @return TradeSecondValidSmsResp 二次短信验证响应
     */
    public static TradeSecondSmsValidResp tradeSecondSmsValid(TradeSecondSmsValidReq req){
        return postData(req,SECOND_SMS_VALID,new TradeSecondSmsValidResp());
    }

    /**
     * 用户/平台商户将账户可用余额提现至开户绑定的银行账户
     * @param req 提现申请参数封装
     * @return WithdrawCashResp 提现响应封装
     */
    public static WithdrawCashResp withdrawCash(WithdrawCashReq req){
        return postData(req,WITHDRAW_CASH,new WithdrawCashResp());
    }

    /**
     * 提现结果查询
     * @param req 提现查询的参数封装
     * @return WithdrawCashQueryResp 提现查询的响应
     */
    public static WithdrawCashQueryResp withdrawCashQuery(WithdrawCashQueryReq req){
        return postData(req,WITHDRAW_CASH_QUERY,new WithdrawCashQueryResp());
    }

    /**
     * 退款
     * @param req 退款请求参数
     * @return RefundResp 退款响应封装
     */
    public static RefundResp refund(RefundReq req){
        return postData(req,REFUND,new RefundResp());
    }

    /**
     * 担保交易确认
     * @param req 担保交易确认请求参数
     * @return SecuredConfirmResp 担保交易确认响应
     */
    public static SecuredConfirmResp securedConfirm(SecuredConfirmReq req){
        return postData(req,SECURED_CONFIRM,new SecuredConfirmResp());
    }

    /**
     * 代发申请
     * @param req 代发申请请求参数
     * @return TransferResp 代发申请响应
     */
    public static TransferResp transfer(TransferReq req){
        return postData(req,TRANSFER,new TransferResp());
    }
}
