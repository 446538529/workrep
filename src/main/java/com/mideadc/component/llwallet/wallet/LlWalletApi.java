package com.mideadc.component.llwallet.wallet;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.RSAUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llwallet.wallet.bean.AuthUserReq;
import com.mideadc.component.llwallet.wallet.bean.AuthUserResp;
import com.mideadc.component.llwallet.wallet.bean.BalancePwdpayReq;
import com.mideadc.component.llwallet.wallet.bean.BalancePwdpayResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardAuthverfyResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardOpenauthReq;
import com.mideadc.component.llwallet.wallet.bean.BankcardOpenauthResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardPayReq;
import com.mideadc.component.llwallet.wallet.bean.BankcardPayResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardPrepayReq;
import com.mideadc.component.llwallet.wallet.bean.BankcardPrepayResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardUnbindReq;
import com.mideadc.component.llwallet.wallet.bean.BankpayPwdsetReq;
import com.mideadc.component.llwallet.wallet.bean.BankpayPwdsetResp;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;
import com.mideadc.component.llwallet.wallet.bean.CashoutcombineApplyReq;
import com.mideadc.component.llwallet.wallet.bean.CashoutcombineApplyResp;
import com.mideadc.component.llwallet.wallet.bean.ModifyUnituserAcctReq;
import com.mideadc.component.llwallet.wallet.bean.ModifyUsermobReq;
import com.mideadc.component.llwallet.wallet.bean.ModifyUsermobResp;
import com.mideadc.component.llwallet.wallet.bean.OpenSmsUnitUserReq;
import com.mideadc.component.llwallet.wallet.bean.OpenSmsUnitUserResp;
import com.mideadc.component.llwallet.wallet.bean.OpenUserReq;
import com.mideadc.component.llwallet.wallet.bean.OpenUserResp;
import com.mideadc.component.llwallet.wallet.bean.PayPwdmodifyReq;
import com.mideadc.component.llwallet.wallet.bean.PayPwdsetReq;
import com.mideadc.component.llwallet.wallet.bean.PwdAuthReq;
import com.mideadc.component.llwallet.wallet.bean.SingleuserQueryReq;
import com.mideadc.component.llwallet.wallet.bean.SingleuserQueryResp;
import com.mideadc.component.llwallet.wallet.bean.SmsCheckReq;
import com.mideadc.component.llwallet.wallet.bean.SmsCheckResp;
import com.mideadc.component.llwallet.wallet.bean.SmsSendReq;
import com.mideadc.component.llwallet.wallet.bean.SmsSendResp;
import com.mideadc.component.llwallet.wallet.bean.TraderAcctQueryReq;
import com.mideadc.component.llwallet.wallet.bean.TraderAcctQueryResp;
import com.mideadc.component.llwallet.wallet.bean.TraderUserPaymentReq;
import com.mideadc.component.llwallet.wallet.bean.TraderUserPaymentResp;
import com.mideadc.component.llwallet.wallet.bean.UserauthQueryReq;
import com.mideadc.component.llwallet.wallet.bean.UserauthQueryResp;
import com.mideadc.component.llwallet.wallet.bean.UserbankcardReq;
import com.mideadc.component.llwallet.wallet.bean.UserbankcardResp;

public class LlWalletApi {
  private static final Logger LOG = LoggerFactory.getLogger(LlWalletApi.class);
  private static final String TRADER_USER_PAYMENT_URL =
      "https://wallet.lianlianpay.com/llwalletapi/traderuserpayment.htm";
  private static final String SMS_SEND_URL = "https://wallet.lianlianpay.com/llwalletapi/smssend.htm";
  private static final String SMS_CHECK_URL = "https://wallet.lianlianpay.com/llwalletapi/smscheck.htm";
  private static final String OPEN_USER_URL = "https://wallet.lianlianpay.com/llwalletapi/openuser.htm";
  private static final String OPEN_SMS_UNIT_USER_URL = "https://wallet.lianlianpay.com/llwalletapi/opensmsunituser.htm";
  private static final String UPLOAD_UNIT_PHOTO_URL = "https://wallet.lianlianpay.com/llwalletapi/uploadunitphoto.htm";
  private static final String UPLOAD_CARD_PHOTO_URL = "https://wallet.lianlianpay.com/llwalletapi/uploadcardphoto.htm";
  private static final String AUTH_USER_URL = "https://wallet.lianlianpay.com/llwalletapi/authuser.htm";
  private static final String BANKCARD_OPEN_AUTH_URL =
      "https://wallet.lianlianpay.com/llwalletapi/bankcardopenauth.htm";
  private static final String BANKCARD_AUTH_VERFY_URL =
      "https://wallet.lianlianpay.com/llwalletapi/bankcardauthverfy.htm";
  private static final String BANKCARD_UNBIND_URL = "https://wallet.lianlianpay.com/llwalletapi/bankcardunbind.htm";
  private static final String BANKCARD_PRE_PAY_URL = "https://wallet.lianlianpay.com/llwalletapi/bankcardprepay.htm";
  private static final String BANK_PAY_PWD_SET_URL = "https://wallet.lianlianpay.com/llwalletapi/bankpaypwdset.htm";
  private static final String CASHOUTCOMBINE_APPLY_URL =
      "https://wallet.lianlianpay.com/llwalletapi/cashoutcombineapply.htm";
  private static final String SINGLE_USER_QUERY_URL = "https://wallet.lianlianpay.com/llwalletapi/singleuserquery.htm";
  private static final String PAY_PWD_SET_URL = "https://wallet.lianlianpay.com/llwalletapi/paypwdset.htm";
  private static final String PAY_PWD_MODIFY_URL = "https://wallet.lianlianpay.com/llwalletapi/paypwdmodify.htm";
  private static final String TRADER_ACCT_QUERY_URL = "https://traderapi.lianlianpay.com/traderAcctQuery.htm";
  private static final String BALANCE_PWD_PAY_URL = "https://wallet.lianlianpay.com/llwalletapi/balancepwdpay.htm";
  private static final String BANKCARD_PAY_VERIFY_URL = "https://wallet.lianlianpay.com/llwalletapi/bankcardpay.htm";
  private static final String MODIFY_USER_MOB_URL = "https://wallet.lianlianpay.com/llwalletapi/modifyusermob.htm";
  private static final String USER_BANKCARD_URL = "https://wallet.lianlianpay.com/llwalletapi/userbankcard.htm";
  private static final String USER_AUTH_QUERY_URL = "https://wallet.lianlianpay.com/llwalletapi/userauthquery.htm";
  private static final String PWD_AUTH_URL = "https://wallet.lianlianpay.com/llwalletapi/pwdauth.htm";
  private static final String PAY_PWD_VERIFY_URL = "https://wallet.lianlianpay.com/llwalletapi/paypwdverify.htm";
  private static final String MODI_UNIT_USER_ACCT_URL =
      "https://wallet.lianlianpay.com/llwalletapi/modiyunituseracct.htm";
  private static final String MODI_UNIT_USER_URL = "https://wallet.lianlianpay.com/llwalletapi/modifyunituser.htm";
  // 私钥
  public static String PRI_KEY = "xxx";
  public static String YT_PUB_KEY = "xxx";
  // 用户所属商户号
  public static String OID_PARTNER = "xxx";

  /**
   * 3.1 钱包下发短信接口
   * 
   * @param userId 用户Id
   * @param mobile 接收短信手机号
   * @param flag
   */
  public static SmsSendResp smsSend(String userId, String mobile, String flag){
    SmsSendReq req = new SmsSendReq();
    req.setUser_id(userId);
    req.setMob_bind(mobile);
    req.setFlag_send(flag);
    SmsSendResp resp = new SmsSendResp();
    resp = postData(req, SMS_SEND_URL, resp);
    return resp;
  }

  /**
   * 3.2 钱包短信验证接口
   * 
   * @param userId 用户Id
   * @param token 授权码
   * @param verifyCode 短信验证码
   * @return
   */
  public static SmsCheckResp smsCheck(String userId, String token, String verifyCode) {
    SmsCheckReq req = new SmsCheckReq();
    req.setUser_id(userId);
    req.setToken(token);
    req.setVerify_code(verifyCode);
    SmsCheckResp resp = new SmsCheckResp();
    resp = postData(req, SMS_CHECK_URL, resp);
    return resp;
  }

  /**
   * 3.3 钱包开户接口(通过短信验证) 3.1->3.2->3.3 进行开户流程
   * 
   * @param userId 用户Id
   * @param name 姓名
   * @param idCardNo 身份证号码
   * @param expiryDate 身份证有效期
   * @param payPwd 支付密码，不支持连续数字，重复数字，长度暂定为6位数字
   * @param province 省份
   * @param city 城市
   * @param district 区
   * @param address 详细联系地址
   * @param token 授权码
   * @return
   */
  public static OpenUserResp openUser(String userId, String name, String idCardNo, String expiryDate, String payPwd,
      String province, String city, String district, String address, String token) {
    OpenUserReq req = new OpenUserReq();
    req.setUser_id(userId);
    req.setName_user(name);
    req.setNo_idcard(idCardNo);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(payPwd, YT_PUB_KEY));
    req.setAddr_conn(address);
    req.setExp_idcard(expiryDate);
    req.setToken(token);
    req.setAddr_pro(province);
    req.setAddr_city(city);
    req.setAddr_dist(district);
    req.setFlag_auth("1");
    req.setRisk_item(createRiskItem());
    OpenUserResp resp = new OpenUserResp();
    resp = postData(req, OPEN_USER_URL, resp);
    return resp;
  }

  /**
   * 3.3 企业用户短信开户接口 3.1->3.2->3.3 进行开户流程
   *
   * @param req OpenSmsUnitUserReq对象 参见LlWalletApiTest.testOpenSmsUnitUser
   *
   * @return
   */
  public static OpenSmsUnitUserResp openSmsUnitUser(OpenSmsUnitUserReq req) {
    req.setPwd_pay(RSAUtil.encryptByPublicKey(req.getPwd_pay(), YT_PUB_KEY));
    req.setRisk_item(createRiskItem());
    OpenSmsUnitUserResp resp = new OpenSmsUnitUserResp();
    resp = postData(req, OPEN_SMS_UNIT_USER_URL, resp);
    return resp;
  }

  /**
   * 3.4 企业用户上传照片接口 回调地址：https://api.52wxr.com/llpay/uploadPhoto
   *
   * @param req UploadUnitPhotoReq对象 参见LlWalletApiTest.testUploadUnitPhoto
   *
   * @return
   */
  // public static UploadUnitPhotoResp uploadUnitPhoto(UploadUnitPhotoReq req) {
  // UploadUnitPhotoResp resp = new UploadUnitPhotoResp();
  // resp = postFormData(req, UPLOAD_UNIT_PHOTO_URL, resp);
  // return resp;
  // }

  /**
   * 3.4 钱包上传身份证接口 回调地址：https://api.52wxr.com/llpay/uploadPhoto
   *
   * @param req UploadCardPhotoReq对象 参见LlWalletApiTest.testUploadCardPhoto
   *
   * @return
   */
  // public static UploadUnitPhotoResp uploadCardPhoto(UploadCardPhotoReq req) {
  // UploadUnitPhotoResp resp = new UploadUnitPhotoResp();
  // resp = postFormData(req, UPLOAD_CARD_PHOTO_URL, resp);
  // return resp;
  // }

  /**
   * 3.5 个体工商户绑卡认证接口
   * 
   * @param userId 收款用户Id
   * @param payType 支付方式
   * @param cardNo 银行卡号
   * @param mobile 绑定手机号
   * @param valiDate 信用卡有效期
   * @param cvv2 信用卡CVV2
   * @param flagAuth 实名认证标示
   */
  public static BankcardOpenauthResp bankcardOpenauth(String userId, String payType, String cardNo, String mobile,
      String valiDate, String cvv2, String flagAuth) {
    BankcardOpenauthReq req = new BankcardOpenauthReq();
    req.setUser_id(userId);
    req.setPay_type(payType);
    req.setApi_version("1.0");
    req.setCard_no(cardNo);
    req.setBind_mob(mobile);
    req.setVali_date(valiDate);
    req.setCvv2(cvv2);
    req.setFlag_auth(flagAuth); // "2"
    req.setRisk_item(createRiskItem());
    BankcardOpenauthResp resp = new BankcardOpenauthResp();
    resp = postData(req, BANKCARD_OPEN_AUTH_URL, resp);
    return resp;
  }

  /**
   * 3.6 个体工商户银行卡绑卡验证接口
   *
   * @param userId 收款用户Id
   * @param token 授权码
   * @param verifyCode 短信验证码
   */
  public static BankcardAuthverfyResp bankcardAuthverfy(String userId, String token, String verifyCode) {
    SmsCheckReq req = new SmsCheckReq();
    req.setUser_id(userId);
    req.setToken(token);
    req.setVerify_code(verifyCode);
    BankcardAuthverfyResp resp = new BankcardAuthverfyResp();
    resp = postData(req, BANKCARD_AUTH_VERFY_URL, resp);
    return resp;
  }

  /**
   * 2.1 商户付款 B2C(所属+收款商户号)
   *
   * @param userId 收款用户Id
   * @param amount 收款金额
   * @param pay_oidpartner 付款方商户号
   * @param orderId 订单Id
   */
  public static TraderUserPaymentResp traderUserPayment(String userId, String amount, String pay_oidpartner,
      String orderId) {
    TraderUserPaymentReq req = new TraderUserPaymentReq();
    req.setPay_oidpartner(pay_oidpartner);
    req.setCol_userid(userId);
    req.setDt_order(DateUtil.format(new Date(), DateUtil.dtLong));
    req.setNo_order(orderId);
    req.setMoney_order(amount);
    req.setRisk_item(createRiskItem());
    TraderUserPaymentResp resp = new TraderUserPaymentResp();
    resp = postData(req, TRADER_USER_PAYMENT_URL, resp);
    return resp;
  }

  /**
   * 6.7 钱包实名认证接口
   * 
   * @param userId
   * @param checkAuth 1:I类账户认证 2:II类账户认证 3:III类账户认证
   * @return
   */
  public static AuthUserResp authUser(String userId, String checkAuth) {
    AuthUserReq req = new AuthUserReq();
    req.setUser_id(userId);
    req.setRisk_item(createRiskItem());
    req.setCheck_auth(checkAuth);
    AuthUserResp resp = new AuthUserResp();
    resp = postData(req, AUTH_USER_URL, resp);
    return resp;
  }

  /**
   * 5.1 企业用户提现申请 该接口适用于企业、事业单位和社会团体用户提现，不适用于个体工商户提现，个体工商户提现走个人现接口。
   * 回调地址：https://api.52wxr.com/llpay/cashoutCombineNotify
   *
   * @param userId
   * @param orderId 商户唯一订单号
   * @param amount 交易金额
   * @param pwdPay 支付密码
   * @param feeData 商户收取用户手续费数据
   * @param notifyUrl 提现结果服务器异步通知地址
   * @param paytimeType 提现到账方式 （1、实时提现 2、普通提现 3、T+1 提现 默认2普通提现）
   *
   * @return
   */
  public static CashoutcombineApplyResp cashoutcombineApplyUnit(String userId, String orderId, String amount,
      String pwdPay, String feeData, String notifyUrl, String paytimeType) {
    CashoutcombineApplyReq req = new CashoutcombineApplyReq();
    req.setUser_id(userId);
    req.setNo_order(orderId);
    req.setDt_order(DateUtil.format(new Date(), DateUtil.dtLong));
    req.setMoney_order(amount);
    req.setApi_version("1.2");
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setFee_data(feeData);
    req.setRisk_item(createRiskItem());
    req.setNotify_url(notifyUrl);
    req.setPaytime_type(paytimeType);
    CashoutcombineApplyResp resp = new CashoutcombineApplyResp();
    resp = postData(req, CASHOUTCOMBINE_APPLY_URL, resp);
    return resp;
  }

  /**
   * 5.1 用户银行卡提现申请 5.2 个体工商户提现申请 该接口适用于个体工商户、个人用户提现。
   * 回调地址：https://api.52wxr.com/llpay/cashoutCombineNotify
   *
   * @param userId
   * @param orderId 商户唯一订单号
   * @param amount 交易金额
   * @param cardNo 银行账号
   * @param noAgree 银通协议编号
   * @param pwdPay 支付密码
   * @param feeData 商户收取用户手续费数据
   * @param notifyUrl 提现结果服务器异步通知地址
   * @param paytimeType 提现到账方式 （1、实时提现 2、普通提现 3、T+1 提现 默认2普通提现）
   *
   * @return
   */
  public static CashoutcombineApplyResp cashoutcombineApply(String userId, String orderId, String amount, String cardNo,
      String noAgree, String pwdPay, String feeData, String notifyUrl, String paytimeType) {
    CashoutcombineApplyReq req = new CashoutcombineApplyReq();
    req.setUser_id(userId);
    req.setNo_order(orderId);
    req.setDt_order(DateUtil.format(new Date(), DateUtil.dtLong));
    req.setMoney_order(amount);
    req.setCard_no(cardNo);
    req.setNo_agree(noAgree);
    req.setApi_version("1.2");
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setInfo_order("无");
    req.setFee_data(feeData);
    req.setRisk_item(createRiskItem());
    req.setNotify_url(notifyUrl);
    req.setPaytime_type(paytimeType);
    CashoutcombineApplyResp resp = new CashoutcombineApplyResp();
    resp = postData(req, CASHOUTCOMBINE_APPLY_URL, resp);
    return resp;
  }

  /**
   * 6.1 钱包用户查询接口
   *
   * @param userId 用户唯一编号
   *
   *
   * @return
   */
  public static SingleuserQueryResp singleuserQuery(String userId) {
    SingleuserQueryReq req = new SingleuserQueryReq();
    req.setUser_id(userId);
    SingleuserQueryResp resp = new SingleuserQueryResp();
    resp = postData(req, SINGLE_USER_QUERY_URL, resp);
    return resp;
  }

  /**
   * 7.4 签约查询接口
   *
   * @param userId 用户唯一编号
   *
   *
   * @return
   */
  public static UserbankcardResp userBankcard(String userId) {
    UserbankcardReq req = new UserbankcardReq();
    req.setUser_id(userId);
    UserbankcardResp resp = new UserbankcardResp();
    resp = postData(req, USER_BANKCARD_URL, resp);
    return resp;
  }

  /**
   * 7.5 用户认证查询接口
   *
   * @param userId 用户唯一编号
   *
   *
   * @return
   */
  public static UserauthQueryResp userAuthQuery(String userId) {
    UserauthQueryReq req = new UserauthQueryReq();
    req.setUser_id(userId);
    UserauthQueryResp resp = new UserauthQueryResp();
    resp = postData(req, USER_AUTH_QUERY_URL, resp);
    return resp;
  }

  /**
   * 6.1 钱包支付密码找回
   *
   * @param userId 用户唯一编号
   * @param pwdPayNew 新支付密码
   * @param token 授权码
   *
   * @return
   */
  public static BaseParamsResp payPwdset(String userId, String pwdPayNew, String token) {
    PayPwdsetReq req = new PayPwdsetReq();
    req.setUser_id(userId);
    req.setPwd_pay_new(RSAUtil.encryptByPublicKey(pwdPayNew, YT_PUB_KEY));
    req.setToken(token);
    req.setRisk_item(createRiskItem());
    BaseParamsResp resp = new BaseParamsResp();
    resp = postData(req, PAY_PWD_SET_URL, resp);
    return resp;
  }

  /**
   * 6.2 钱包支付密码修改
   *
   * @param userId 用户唯一编号
   * @param pwdPayNew 新支付密码
   * @param pwdPay 原支付密码
   *
   * @return
   */
  public static BaseParamsResp payPwdmodify(String userId, String pwdPay, String pwdPayNew) {
    PayPwdmodifyReq req = new PayPwdmodifyReq();
    req.setUser_id(userId);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setPwd_pay_new(RSAUtil.encryptByPublicKey(pwdPayNew, YT_PUB_KEY));
    req.setRisk_item(createRiskItem());
    BaseParamsResp resp = new BaseParamsResp();
    resp = postData(req, PAY_PWD_MODIFY_URL, resp);
    return resp;
  }

  /**
   * 6.3 银行卡解绑接口
   *
   * @param userId 用户唯一编号
   * @param noAgree 银通协议编号
   * @param payType 支付方式
   * @param pwdPay 原支付密码
   * @param typeUser 用户类型
   *
   * @return
   */
  public static BaseParamsResp bankcardUnbind(String userId, String noAgree, String payType, String pwdPay,
      String typeUser) {
    BankcardUnbindReq req = new BankcardUnbindReq();
    req.setUser_id(userId);
    req.setNo_agree(noAgree);
    req.setPay_type(payType);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setType_user(typeUser);
    BaseParamsResp resp = new BaseParamsResp();
    resp = postData(req, BANKCARD_UNBIND_URL, resp);
    return resp;
  }

  /**
   * 个人钱包 6.4 钱包支付密码验证授权接口
   *
   * @param userId 用户唯一编号
   * @param pwdPay 原支付密码
   * @param idcardNo 证件号
   * @param mobile 绑定手机号码
   *
   * @return
   */
  public static SmsCheckResp pwdAuth(String userId, String pwdPay, String idcardNo, String mobile) {
    PwdAuthReq req = new PwdAuthReq();
    req.setUser_id(userId);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setNo_idcard(idcardNo);
    req.setFlag_check("1");
    req.setMob_bind(mobile);
    req.setRisk_item(createRiskItem());
    SmsCheckResp resp = new SmsCheckResp();
    resp = postData(req, PWD_AUTH_URL, resp);
    return resp;
  }

  /**
   * 企业钱包 7.3 钱包支付密码验证授权接口
   *
   * @param userId 用户唯一编号
   * @param pwdPay 原支付密码
   * @param license 绑定手机号码
   *
   * @return
   */
  public static SmsCheckResp pwdAuthUnit(String userId, String pwdPay, String license) {
    PwdAuthReq req = new PwdAuthReq();
    req.setUser_id(userId);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setNum_license(license);
    req.setFlag_check("0");
    req.setRisk_item(createRiskItem());
    SmsCheckResp resp = new SmsCheckResp();
    resp = postData(req, PWD_AUTH_URL, resp);
    return resp;
  }

  /**
   * 6.5 绑定银行卡授权申请接口（个人/个体户）
   *
   * @param userId 用户唯一编号
   * @param cardNo 银行卡号
   * @param mobile 绑定手机号
   * @param name 姓名
   * @param idNo 证件号
   * @param valiDate 信用卡有效期
   * @param cvv2 信用卡CVV2
   * @param payType 支付方式
   * @param pwdPay 支付密码
   *
   * @return
   */
  public static BankpayPwdsetResp bankpayPwdset(String userId, String cardNo, String mobile, String name, String idNo,
      String valiDate, String cvv2, String payType, String pwdPay) {
    BankpayPwdsetReq req = new BankpayPwdsetReq();
    req.setUser_id(userId);
    req.setCard_no(cardNo);
    req.setBind_mob(mobile);
    req.setAcct_name(name);
    req.setId_no(idNo);
    req.setVali_date(valiDate);
    req.setCvv2(cvv2);
    req.setPay_type(payType);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setRisk_item(createRiskItem());
    BankpayPwdsetResp resp = new BankpayPwdsetResp();
    resp = postData(req, BANK_PAY_PWD_SET_URL, resp);
    return resp;
  }

  /**
   * 6.6 绑定银行卡授权验证接口
   *
   * @param userId 用户Id
   * @param token 授权码
   * @param verifyCode 短信验证码
   * @return
   */
  public static SmsCheckResp payPwdVerify(String userId, String token, String verifyCode) {
    SmsCheckReq req = new SmsCheckReq();
    req.setUser_id(userId);
    req.setToken(token);
    req.setVerify_code(verifyCode);
    SmsCheckResp resp = new SmsCheckResp();
    resp = postData(req, PAY_PWD_VERIFY_URL, resp);
    return resp;
  }

  /**
   * 商户账户余额查询接口
   *
   * @param oid_partner 商户编号
   *
   * @return
   */
  public static TraderAcctQueryResp traderAcctQuery(String oid_partner) {
    TraderAcctQueryReq req = new TraderAcctQueryReq();
    req.setApi_version("1.0");
    req.setOid_partner(oid_partner);
    TraderAcctQueryResp resp = new TraderAcctQueryResp();
    resp = postData(req, TRADER_ACCT_QUERY_URL, resp);
    return resp;
  }

  /**
   * 6.9/7.7 用户绑定手机修改接口 通过 支付密码 + 原绑定手机号码 进行修改， 调用顺序 个人：6.4-》3.2-》6.9 企业、个体工商户：7.3-》3.2-》7.7
   *
   * @param userId 用户唯一编号
   * @param token 授权码
   * @param mobBind 绑定手机号码
   *
   * @return
   */
  public static ModifyUsermobResp modifyUserMob(String userId, String token, String mobBind) {
    ModifyUsermobReq req = new ModifyUsermobReq();
    req.setUser_id(userId);
    req.setToken(token);
    req.setMob_bind(mobBind);
    req.setRisk_item(createRiskItem());
    ModifyUsermobResp resp = new ModifyUsermobResp();
    resp = postData(req, MODIFY_USER_MOB_URL, resp);
    return resp;
  }

  /**
   * 7.2 企业用户对公账户修改接口(企业) 通过 支付密码 + 证件号码 进行修改， 调用顺序 个人、个体工商户：6.5-》6.6 企业：7.3-》7.2
   *
   * @param req
   *
   *
   * @return
   */
  public static OpenSmsUnitUserResp modifyUnituserAcct(ModifyUnituserAcctReq req) {
    req.setRisk_item(createRiskItem());
    OpenSmsUnitUserResp resp = new OpenSmsUnitUserResp();
    resp = postData(req, MODI_UNIT_USER_ACCT_URL, resp);
    return resp;
  }

  /**
   * 4.1 钱包签约支付预处理接口
   *
   * @param userId 用户唯一编号
   * @param orderId 商户唯一订单号
   * @param oid_partner 商户编号
   * @param amount 交易金额
   * @param notifyUrl 服务器异步通知地址
   * @param payType 支付方式
   * @param cardNo 银行卡号
   * @param bindMob 绑定手机号
   * @param pwdPay 支付密码
   * @param col_oidpartner 收款方商户号
   *
   * @return
   */
  public static BankcardPrepayResp bankcardPrepay(String userId, String orderId, String oid_partner, String amount,
      String notifyUrl, String payType, String cardNo, String bindMob, String pwdPay, String col_oidpartner) {
    BankcardPrepayReq req = new BankcardPrepayReq();
    req.setUser_id(userId);
    req.setOid_partner(oid_partner);
    req.setBusi_partner("101001");
    req.setApi_version("1.1");
    req.setNo_order(orderId);
    req.setDt_order(DateUtil.format(new Date(), DateUtil.dtLong));
    req.setName_goods("测试转账到商户");
    req.setMoney_order(amount);
    req.setNotify_url(notifyUrl);
    req.setRisk_item(createRiskItem());
    req.setPay_type(payType);
    req.setCard_no(cardNo);
    req.setBind_mob(bindMob);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setCol_oidpartner(col_oidpartner);
    BankcardPrepayResp resp = new BankcardPrepayResp();
    resp = postData(req, BANKCARD_PRE_PAY_URL, resp);
    return resp;
  }

  /**
   * 4.2 钱包银行卡签约支付验证
   *
   * @param token 授权码
   * @param orderId 商户唯一订单号
   * @param oid_partner 商户编号
   * @param amount 交易金额
   * @param verifyCode 短信验证码
   * @param col_oidpartner 收款方商户号
   *
   * @return
   */
  public static BankcardPayResp bankcardPay(String token, String orderId, String oid_partner, String amount,
      String verifyCode, String col_oidpartner) {
    BankcardPayReq req = new BankcardPayReq();
    req.setToken(token);
    req.setOid_partner(oid_partner);
    req.setNo_order(orderId);
    req.setMoney_order(amount);
    req.setCol_oidpartner(col_oidpartner);
    req.setVerify_code(verifyCode);
    BankcardPayResp resp = new BankcardPayResp();
    resp = postData(req, BANKCARD_PAY_VERIFY_URL, resp);
    return resp;
  }

  /**
   * 4.3 余额支付接口
   *
   * @param userId 用户唯一编号
   * @param orderId 商户唯一订单号
   * @param oid_partner 商户编号
   * @param amount 交易金额
   * @param pwdPay 支付密码
   * @param notifyUrl 服务器异步通知地址
   * @param col_oidpartner 收款方商户号
   *
   * @return
   */
  public static BalancePwdpayResp balancePwdPay(String userId, String orderId, String oid_partner, String amount,
      String pwdPay, String notifyUrl, String col_oidpartner) {
    BalancePwdpayReq req = new BalancePwdpayReq();
    req.setUser_id(userId);
    req.setOid_partner(oid_partner);
    req.setNo_order(orderId);
    req.setDt_order(DateUtil.format(new Date(), DateUtil.dtLong));
    req.setBusi_partner("101001");
    req.setName_goods("测试付款到商户");
    req.setMoney_order(amount);
    req.setPwd_pay(RSAUtil.encryptByPublicKey(pwdPay, YT_PUB_KEY));
    req.setNotify_url(notifyUrl);
    req.setRisk_item(createRiskItem());
    req.setCol_oidpartner(col_oidpartner);
    BalancePwdpayResp resp = new BalancePwdpayResp();
    resp = postData(req, BALANCE_PWD_PAY_URL, resp);
    return resp;
  }


  /**
   * 7.1 企业用户基本信息修改接口
   *
   * @param req OpenSmsUnitUserReq对象 参见LlWalletApiTest.testOpenSmsUnitUser
   *
   * @return
   */
  public static OpenSmsUnitUserResp modifyUnitUser(OpenSmsUnitUserReq req) {
    req.setPwd_pay(RSAUtil.encryptByPublicKey(req.getPwd_pay(), YT_PUB_KEY));
    req.setRisk_item(createRiskItem());
    OpenSmsUnitUserResp resp = new OpenSmsUnitUserResp();
    resp = postData(req, MODI_UNIT_USER_URL, resp);
    return resp;
  }

  @SuppressWarnings("unchecked")
  private static <T> T postData(BaseParamsReq req, String url, T respObj) {
    try {
      req.setOid_partner(req.getOid_partner() != null ? req.getOid_partner() : OID_PARTNER);
      req.setSign_type("RSA");
      String sign = SignUtil.signByRSA(req, PRI_KEY);
      req.setSign(sign);
      String jsonData = JsonUtil.toJson(req);
      Map<String, String> headers = new HashMap<String, String>();
      headers.put("Content-Type", "application/json;charset=UTF-8 ");
      String resp = HttpUtil.post(url, null, headers, jsonData);
      if (LOG.isDebugEnabled()) {
        LOG.debug("请求连连钱包API返回结果：{}", resp);
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
          LOG.warn("请求连连钱包API返回结果验签失败：{}", resp);
          return null;
        }
      } else {
        if (LOG.isWarnEnabled()) {
          LOG.warn("请求连连钱包API未成功：{}", resp);
        }
        return (T) JsonUtil.fromJson(resp, respObj.getClass());
      }
    } catch (Exception e) {
      LOG.error("请求连连钱包API时出错", e);
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  // private static <T> T postFormData(BaseParamsReq req, String url, T respObj) {
  // try {
  // req.setOid_partner(OID_PARTNER);
  // req.setSign_type("RSA");
  // req.setSign(formSign(BeanUtils.describe(req)));
  // Map<String, Object> params = BeanUtils.describe(req);
  // String resp = HttpUtil.postForm(params, url);
  // if (LOG.isDebugEnabled()) {
  // LOG.debug("请求连连钱包API返回结果：{}", resp);
  // }
  // Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
  // String ret_code = resultMap.get("ret_code");
  // String returnSign = resultMap.get("sign");
  // resultMap.remove("sign");
  // if ("0000".equals(ret_code)) {
  // if (RSAUtil.checkSign(YT_PUB_KEY, SignUtil.createLinkString(resultMap), returnSign)) {
  // return (T) JsonUtil.fromJson(resp, respObj.getClass());
  // } else {
  // LOG.warn("请求连连钱包API返回结果验签失败：{}", resp);
  // return null;
  // }
  // } else {
  // if (LOG.isWarnEnabled()) {
  // LOG.warn("请求连连钱包API未成功：{}", resp);
  // }
  // return (T) JsonUtil.fromJson(resp, respObj.getClass());
  // }
  // } catch (Exception e) {
  // LOG.error("请求连连钱包API时出错", e);
  // }
  // return null;
  // }

  private static String formSign(Map<String, Object> params) {
    Map<String, String> signParams = new HashMap<String, String>();
    try {
      Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, Object> entry = it.next();
        String key = entry.getKey();
        Object val = entry.getValue();
        if (val instanceof File || val == null) {
          continue;
        }
        signParams.put(key, val.toString());
      }
      return SignUtil.signByRSA(signParams, PRI_KEY);
    } catch (Exception e) {
      e.printStackTrace();
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

  public static String createRiskItem() {
    Map<String, String> params = new HashMap<String, String>();
    params.put("frms_ware_category", "2013");
    params.put("frms_ip_addr", "183.3.143.131");
    params.put("frms_client_chnl", "13");
    return JsonUtil.toJson(params);
  }

  public static void main(String[] args) throws Exception {
    BigDecimal transferMoney = new BigDecimal("400").multiply(new BigDecimal("0.965"));
    BigDecimal xx = new BigDecimal("400").multiply(new BigDecimal("1").subtract(new BigDecimal("0.035"))).setScale(2,
        BigDecimal.ROUND_DOWN);
    Float rete = new Float(0.035);
    BigDecimal a = new BigDecimal("400").multiply(BigDecimal.ONE.subtract(new BigDecimal(rete))).setScale(2,
        BigDecimal.ROUND_DOWN);


    System.out.println("transferMoney=" + transferMoney);
    System.out.println("xx=" + a);
    System.out.println("xx=" + new BigDecimal(1.0 - 0.035));
  }
}
