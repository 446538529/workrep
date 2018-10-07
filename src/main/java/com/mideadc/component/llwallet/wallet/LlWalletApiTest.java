package com.mideadc.component.llwallet.wallet;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import com.mideadc.component.llwallet.wallet.bean.AuthUserResp;
import com.mideadc.component.llwallet.wallet.bean.BalancePwdpayResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardAuthverfyResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardOpenauthResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardPayResp;
import com.mideadc.component.llwallet.wallet.bean.BankcardPrepayResp;
import com.mideadc.component.llwallet.wallet.bean.BankpayPwdsetResp;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;
import com.mideadc.component.llwallet.wallet.bean.CashoutcombineApplyResp;
import com.mideadc.component.llwallet.wallet.bean.ModifyUnituserAcctReq;
import com.mideadc.component.llwallet.wallet.bean.ModifyUsermobResp;
import com.mideadc.component.llwallet.wallet.bean.OpenSmsUnitUserReq;
import com.mideadc.component.llwallet.wallet.bean.OpenSmsUnitUserResp;
import com.mideadc.component.llwallet.wallet.bean.OpenUserResp;
import com.mideadc.component.llwallet.wallet.bean.SingleuserQueryResp;
import com.mideadc.component.llwallet.wallet.bean.SmsCheckResp;
import com.mideadc.component.llwallet.wallet.bean.SmsSendResp;
import com.mideadc.component.llwallet.wallet.bean.TraderAcctQueryResp;
import com.mideadc.component.llwallet.wallet.bean.TraderUserPaymentResp;
import com.mideadc.component.llwallet.wallet.bean.UserauthQueryResp;
import com.mideadc.component.llwallet.wallet.bean.UserbankcardResp;

public class LlWalletApiTest {

  @Test
  public void testSmsSend() {
    String userId = "004";
    String mobile = "13726229345";
    SmsSendResp resp = LlWalletApi.smsSend(userId, mobile, "0");
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testSmsCheck() {
    String userId = "004";
    String token = "B32F4BC26C71A4DA843D41FF42FC1DFE";
    String verifyCode = "928608";
    SmsCheckResp resp = LlWalletApi.smsCheck(userId, token, verifyCode);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testOpenUser() {
    String userId = "004";
    String token = "4C3A96AA099B70649306A99390571F15";
    String name = "xxx";
    String idCardNo = "xxx";
    String expiryDate = "20180812";
    String payPwd = "123345";
    String province = "440000";
    String city = "440900";
    String district = "440981";
    String address = "xxx";
    OpenUserResp resp =
        LlWalletApi.openUser(userId, name, idCardNo, expiryDate, payPwd, province, city, district, address, token);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testOpenSmsUnitUser() {
    String token = "F95050D23A9CFE039D71B79E86C26AAD";
    String userId = "004";
    OpenSmsUnitUserReq req = new OpenSmsUnitUserReq();
    req.setUser_id(userId);
    req.setMob_bind("15521383741");
    req.setToken(token);
    req.setName_user("xxx");
    req.setNo_idcard("xxx");
    req.setExp_idcard("20351020");
    req.setPwd_pay("123345");
    req.setAddr_unit("xxx");
    req.setAddr_pro("440000");
    req.setAddr_city("440100");
    req.setAddr_dist("440106");
    req.setBusi_user("xxx");
    req.setName_unit("xxx");
    req.setNum_license("xxx");
    req.setType_explicense("1");
    req.setType_register("1");
    req.setType_license("2");
    req.setRisk_item(LlWalletApi.createRiskItem());

    OpenSmsUnitUserResp resp = LlWalletApi.openSmsUnitUser(req);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  // @Test
  // public void testUploadUnitPhoto() {
  // String userId = "002";
  // String notifyUrl = "http://test.api.52wxr.com/llpay/bankcardrepayment";
  // String frontCard = "/Users/spirng/WW/tmp/ll/法人身份证正面.jpg";
  // String backCard = "/Users/spirng/WW/tmp/ll/法人身份证反面.jpg";
  // String copyLicense = "/Users/spirng/WW/tmp/ll/营业执照副本.jpeg";
  // String bankOpenLicense = "/Users/spirng/WW/tmp/ll/开户许可证_20170830171042.jpg";
  //
  // UploadUnitPhotoReq req = new UploadUnitPhotoReq();
  // req.setUser_id(userId);
  // req.setNotify_url(notifyUrl);
  // req.setFront_card(new File(frontCard));
  // req.setBack_card(new File(backCard));
  // req.setCopy_license(new File(copyLicense));
  // req.setBank_openlicense(new File(bankOpenLicense));
  // UploadUnitPhotoResp resp = LlWalletApi.uploadUnitPhoto(req);
  // System.err.println(ReflectionToStringBuilder.toString(resp));
  // }

  // @Test
  // public void testUploadCardPhoto() {
  // String userId = "003";
  // String notifyUrl = "http://test.api.52wxr.com/llpay/bankcardrepayment";
  // String frontCard = "/Users/spirng/WW/tmp/ll/法人身份证正面.jpg";
  // String backCard = "/Users/spirng/WW/tmp/ll/法人身份证反面.jpg";
  //
  // UploadCardPhotoReq req = new UploadCardPhotoReq();
  // req.setUser_id(userId);
  // req.setNotify_url(notifyUrl);
  // req.setFront_card(new File(frontCard));
  // req.setBack_card(new File(backCard));
  // UploadUnitPhotoResp resp = LlWalletApi.uploadCardPhoto(req);
  // System.err.println(ReflectionToStringBuilder.toString(resp));
  // }

  @Test
  public void testBankcardOpenauth() {
    String userId = "004";
    String payType = "2";
    String cardNo = "xxx";
    String bindMob = "xxx";
    String flagAuth = "2";
    BankcardOpenauthResp resp = LlWalletApi.bankcardOpenauth(userId, payType, cardNo, bindMob, null, null, flagAuth);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBankcardAuthverfy() {
    String userId = "004";
    String token = "814C8FEE954C8B058D0E8E8EC42851B0";
    String verifyCode = "564212";
    BankcardAuthverfyResp resp = LlWalletApi.bankcardAuthverfy(userId, token, verifyCode);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testModifyUserMob() {
    String userId = "004";
    String token = "48437A9CF212192D2C25B5E2260E1B93";
    String bindMob = "xxx";
    ModifyUsermobResp resp = LlWalletApi.modifyUserMob(userId, token, bindMob);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testTraderUserPayment() {
    String userId = "002";
    String amount = "5";
    String pay_oidpartner = "201708310000857929";
    String orderId = "20180305111398";
    TraderUserPaymentResp resp = LlWalletApi.traderUserPayment(userId, amount, pay_oidpartner, orderId);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testAuthUser() {
    String userId = "001";
    String checkAuth = "1";
    AuthUserResp resp = LlWalletApi.authUser(userId, checkAuth);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testCashoutcombineApplyUnit() {
    String userId = "002";
    String noOrder = "20180208170607";
    String amount = "0.1";
    String pwdPay = "123654";
    String feeData = "";
    String notifyUrl = "xxx";
    String paytimeType = "2";
    CashoutcombineApplyResp resp =
        LlWalletApi.cashoutcombineApplyUnit(userId, noOrder, amount, pwdPay, feeData, notifyUrl, paytimeType);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testCashoutcombineApply() {
    String userId = "003";
    String noOrder = "20180203145507";
    String amount = "0.5";
    String cardNo = "xxx";
    String noAgree = "";
    String pwdPay = "123345";
    String feeData = "";
    String notifyUrl = "xxx";
    String paytimeType = "2";
    CashoutcombineApplyResp resp = LlWalletApi.cashoutcombineApply(userId, noOrder, amount, cardNo, noAgree, pwdPay,
        feeData, notifyUrl, paytimeType);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testSingleuserQuery() {
    String userId = "d31dc6d16e6b4f2ebafa78e7765467e7";
    SingleuserQueryResp resp = LlWalletApi.singleuserQuery(userId);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testUserbankcard() {
    String userId = "002";
    UserbankcardResp resp = LlWalletApi.userBankcard(userId);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testUserAuthQuery() {
    String userId = "002";
    UserauthQueryResp resp = LlWalletApi.userAuthQuery(userId);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testPayPwdset() {
    String userId = "003";
    String pwdPayNew = "";
    String token = "";
    BaseParamsResp resp = LlWalletApi.payPwdset(userId, pwdPayNew, token);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testPayPwdmodify() {
    String userId = "002";
    String pwdPay = "123654";
    String pwdPayNew = "06340082";
    BaseParamsResp resp = LlWalletApi.payPwdmodify(userId, pwdPay, pwdPayNew);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBankcardUnbind() {
    String userId = "004";
    String noAgree = "2018020691955929";
    String payType = "2";
    String pwdPay = "123345";
    String typeUser = "0";
    BaseParamsResp resp = LlWalletApi.bankcardUnbind(userId, noAgree, payType, pwdPay, typeUser);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testPwdAuth() {
    String userId = "002";
    String pwdPay = "123654";
    String idcardNo = "";
    String mobile = "15820592741";
    SmsCheckResp resp = LlWalletApi.pwdAuth(userId, pwdPay, idcardNo, mobile);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testPwdAuthUnit() {
    String userId = "002";
    String pwdPay = "123654";
    String license = "914401063400821295";
    SmsCheckResp resp = LlWalletApi.pwdAuthUnit(userId, pwdPay, license);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBankpayPwdset() {
    String userId = "004";
    String cardNo = "xxx";
    String mobile = "xx";
    String name = "xxx";
    String idNo = "xxx";
    String payType = "2";
    String pwdPay = "123345";
    BankpayPwdsetResp resp = LlWalletApi.bankpayPwdset(userId, cardNo, mobile, name, idNo, null, null, payType, pwdPay);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testTraderAcctQuery() {
    String oid_partner = "xxx";
    TraderAcctQueryResp resp = LlWalletApi.traderAcctQuery(oid_partner);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBankcardPrepay() {
    String userId = "003";
    String orderId = "20180205215100";
    String oid_partner = "201801260001452037";
    String amount = "0.5";
    String notifyUrl = "xxx";
    String payType = "2";
    String cardNo = "xxx";
    String bindMob = "15521383741";
    String pwdPay = "123345";
    String col_oidpartner = "xxx";
    BankcardPrepayResp resp = LlWalletApi.bankcardPrepay(userId, orderId, oid_partner, amount, notifyUrl, payType,
        cardNo, bindMob, pwdPay, col_oidpartner);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBankcardPay() {
    String userId = "003";
    String orderId = "xxx";
    String oid_partner = "xxx";
    String amount = "1";
    String verifyCode = "";
    String col_oidpartner = "xxx";
    BankcardPayResp resp = LlWalletApi.bankcardPay(userId, orderId, oid_partner, amount, verifyCode, col_oidpartner);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testBalancePwdPay() {
    String userId = "003";
    String orderId = "xx";
    String oid_partner = "xx";
    String amount = "0.5";
    String pwdPay = "123345";
    String notifyUrl = "xxxx";
    String col_oidpartner = "xxx";
    BalancePwdpayResp resp =
        LlWalletApi.balancePwdPay(userId, orderId, oid_partner, amount, pwdPay, notifyUrl, col_oidpartner);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testPayPwdVerify() {
    String userId = "004";
    String token = "B32F4BC26C71A4DA843D41FF42FC1DFE";
    String verifyCode = "928608";
    SmsCheckResp resp = LlWalletApi.payPwdVerify(userId, token, verifyCode);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void testModifyUnituserAcct() {
    ModifyUnituserAcctReq req = new ModifyUnituserAcctReq();
    req.setUser_id("002");
    req.setToken("07DE273E8E92AECD44455EFFF181A076");
    req.setCity_code("330100");
    req.setBrabank_name("xxx");
    req.setCard_no("xxx");
    req.setBank_code("03080000");
    req.setAcct_name("xx");
    OpenSmsUnitUserResp resp = LlWalletApi.modifyUnituserAcct(req);
    System.err.println(ReflectionToStringBuilder.toString(resp));
  }

  @Test
  public void test() {
    String appId = StringUtils.substringBefore("wx293472955218c853:oDMiAv2MWltrJwlFhcgtD0zv2kwA", ":");
    String openid = StringUtils.substringAfter("wx293472955218c853:oDMiAv2MWltrJwlFhcgtD0zv2kwA", ":");
    System.err.println(appId);
    System.err.println(openid);
    test333("\"APPID\":\"" + appId + "\"");
  }

  public void test333(String mm) {
    System.err.println("mm" + mm);
  }

}
