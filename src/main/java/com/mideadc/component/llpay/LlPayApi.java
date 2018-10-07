package com.mideadc.component.llpay;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.RequestUtils;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llpay.bean.AgreenOauthApply;
import com.mideadc.component.llpay.bean.BankCardRepayment;
import com.mideadc.component.llpay.bean.BankCardUnbind;
import com.mideadc.component.llpay.bean.LlPayBeanHelper;
import com.mideadc.component.llpay.bean.SignApply;
import com.mideadc.component.llpay.bean.SignApplyResult;
import com.mideadc.component.llpay.bean.UserParams;
import com.mideadc.component.llpay.config.LlPayConfig;

public class LlPayApi {
  private static final Logger LOG = LoggerFactory.getLogger(LlPayApi.class);

  /**
   * 4.2. WAP签约授权接口
   * 
   * @param bankCardNo 银行卡号
   * @param userParams 用户相关参数
   * @return
   */
  public static String buildH5Request(String bankCardNo, UserParams userParams) {
    SignApply signApply = LlPayBeanHelper.createSignApply(bankCardNo, userParams);
    String json = JsonUtil.toJson(signApply);
    StringBuffer sbHtml = new StringBuffer();
    sbHtml.append("<form id=\"llpaysubmit\" name=\"llpaysubmit\" action=\"" + LlPayConfig.SIGN_APPLY_H5_URL
        + "\" method=\"POST\">");
    sbHtml.append("<input type=\"hidden\" name=\"req_data\" value=\'" + json + "\'/>");

    // submit按钮控件请不要含有name属性
    sbHtml.append("</form>");
    sbHtml.append("<script>document.forms['llpaysubmit'].submit();</script>");
    if (LOG.isDebugEnabled()) {
      LOG.debug("H5-生成签约表单html：{}", sbHtml.toString());
    }
    return sbHtml.toString();
  }

  /**
   * 4.3. 授权申请API接口
   * 
   * @param userDepositCardId 用户储值卡Id
   * @param repaymentPlan 还款计划json格式
   * @param agreeNo
   * @return
   */
  public static boolean agreenOauthApply(String userDepositCardId, String repaymentPlan, String agreeNo) {
    AgreenOauthApply agreenOauthApply =
        LlPayBeanHelper.createAgreenOauthApply(userDepositCardId, repaymentPlan, agreeNo);
    String json = JsonUtil.toJson(agreenOauthApply);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8 ");
    String resp = HttpUtil.post(LlPayConfig.AGREEN_OAUTH_APPLY_URL, null, headers, json);
    if (LOG.isDebugEnabled()) {
      LOG.debug("调用4.3授权申请API接口返回值：{}", resp);
    }
    Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
    String ret_code = resultMap.get("ret_code");
    if ("0000".equals(ret_code)) {
      return true;
    } else {
      if (LOG.isWarnEnabled()) {
        LOG.warn("调用4.3授权申请API接口未成功：{}", resp);
      }
      return false;
    }
  }

  /**
   * 4.5. 银行卡还款扣款接口
   * 
   * @param orderNo 订单号
   * @param amount 金额
   * @param scheduleRepaymentDate 还款日期
   * @param agreeNo 签约协议号
   * @param userParams 用户相关参数
   * @return
   */
  public static boolean bankCardRepayment(String orderNo, String amount, String scheduleRepaymentDate, String agreeNo,
      UserParams userParams) {
    BankCardRepayment bankCardRepayment =
        LlPayBeanHelper.createBankCardRepayment(orderNo, amount, scheduleRepaymentDate, agreeNo, userParams);
    String json = JsonUtil.toJson(bankCardRepayment);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8 ");
    String resp = HttpUtil.post(LlPayConfig.BANK_CARD_REPAYMENT_URL, null, headers, json);
    if (LOG.isDebugEnabled()) {
      LOG.debug("调用4.5. 银行卡还款扣款接口返回值：{}", resp);
    }
    if (StringUtils.isNotBlank(resp)) {
      Map<String, String> params = JsonUtil.fromJson(resp, HashMap.class);
      if ("0000".equals(params.get("ret_code"))) {
        return true;
      }
    }

    if (LOG.isWarnEnabled()) {
      LOG.warn("调用4.3授权申请API接口未成功：{}", resp);
    }
    return false;
  }

  /**
   * 4.10. 银行卡解约API接口
   * 
   * @param userDepositCardId 用户储值卡Id
   * @param agreeNo 签约协议号
   * @return
   */
  public static boolean bankCardUnbind(String userDepositCardId, String agreeNo) {
    BankCardUnbind bankCardUnbind = LlPayBeanHelper.createBankCardUnbind(userDepositCardId, agreeNo);
    String json = JsonUtil.toJson(bankCardUnbind);
    String resp = HttpUtil.post(LlPayConfig.BANK_CARD_UNBIND_URL, null, null, json);
    if (LOG.isDebugEnabled()) {
      LOG.debug("4.10. 银行卡解约API接口返回值：{}", resp);
    }
    if (StringUtils.isNotBlank(resp)) {
      Map<String, String> params = JsonUtil.fromJson(resp, HashMap.class);
      if ("0000".equals(params.get("ret_code"))) {
        return true;
      }
    }
    return false;
  }

  /**
   * 获取签约协议号
   * 
   * @param request
   * @return
   */
  @SuppressWarnings("unchecked")
  public static SignApplyResult getAgreeNo(HttpServletRequest request) {
    String status = RequestUtils.getStringValue(request, "status");
    if (status != null && status.equals("0000")) {
      String result = RequestUtils.getStringValue(request, "result");
      if (result != null) {
        Map<String, String> params = JsonUtil.fromJson(result, HashMap.class);
        String llSign = params.get("sign");
        params.remove("sign");
        String sign = SignUtil.sign(params, "&key=" + LlPayConfig.MD5_KEY);
        if (sign.equals(llSign)) {
          return new SignApplyResult(params.get("user_id"), params.get("agreeno"));
        } else {
          LOG.warn("验签失败：{}", result);
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    LlPayConfig.OID_PARTNER = "201703131001558472";
    LlPayConfig.MD5_KEY = "c223c0d2e1a4970caa23034affa74004";
    LlPayConfig.SIGN_TYPE = "MD5";
    LlPayConfig.URL_RETURN = "http://api.52wxr.com/llpay/url_return";
    LlPayConfig.NOTIFY_URL = "http://api.52wxr.com/llpay/bankcardrepayment";
  }

}
