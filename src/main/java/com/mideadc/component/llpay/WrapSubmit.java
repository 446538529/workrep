package com.mideadc.component.llpay;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.mideadc.commons.domain.JsonPage;
import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llpay.bean.PaymentInfo;
import com.mideadc.component.llpay.bean.RiskItem;
import com.mideadc.component.llpay.config.LlPayConfig;

/**
 * 连连H5支付
 * 
 * @author spirng
 *
 */
public class WrapSubmit {
  private static final String COMBINE_PAY_URL = "https://wallet.lianlianpay.com/llwalletapi/combinepay.htm";
  private static final String ORDER_QUERY_URL = "https://queryapi.lianlianpay.com/orderquery.htm";
  private static final Logger LOG = LoggerFactory.getLogger(WrapSubmit.class);

  public static String buildPCRequest(String amount, String orderNo, String userId, String name, String idNo,
      String nameGoods, RiskItem riskItem) {

    PaymentInfo paymentInfo = createPCPaymentInfo(amount, orderNo, userId, name, idNo, nameGoods, riskItem);
    if (paymentInfo == null) {
      return null;
    }

    StringBuffer sbHtml = new StringBuffer();
    sbHtml.append("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
    sbHtml.append(
        "<form id=\"llpaysubmit\" name=\"llpaysubmit\" action=\"" + LlPayConfig.PAY_URL + "\" method=\"POST\">");
    sbHtml.append("<input type=\"hidden\" name=\"version\" value=\"" + paymentInfo.getVersion() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"oid_partner\" value=\"" + paymentInfo.getOid_partner() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"user_id\" value=\"" + paymentInfo.getUser_id() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"sign_type\" value=\"" + paymentInfo.getSign_type() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"sign\" value=\"" + paymentInfo.getSign() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"busi_partner\" value=\"" + paymentInfo.getBusi_partner() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"no_order\" value=\"" + paymentInfo.getNo_order() + "\"/>");
    sbHtml
        .append("<input type=\"hidden\" name=\"dt_order\" value=\"" + DateUtil.getLocalDate("yyyyMMddHHmmss") + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"name_goods\" value=\"" + paymentInfo.getName_goods() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"info_order\" value=\"" + paymentInfo.getInfo_order() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"money_order\" value=\"" + paymentInfo.getMoney_order() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"notify_url\" value=\"" + paymentInfo.getNotify_url() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"url_return\" value=\"" + paymentInfo.getUrl_return() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"userreq_ip\" value=\"" + paymentInfo.getUserreq_ip() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"url_order\" value=\"" + paymentInfo.getUrl_order() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"valid_order\" value=\"" + paymentInfo.getValid_order() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"timestamp\" value=\"" + paymentInfo.getTimestamp() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"risk_item\" value=\'" + paymentInfo.getRisk_item() + "\'/>");
    sbHtml.append("<input type=\"hidden\" name=\"pay_type\" value=\"" + paymentInfo.getPay_type() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"no_agree\" value=\"" + paymentInfo.getNo_agree() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"id_type\" value=\"" + paymentInfo.getId_type() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"id_no\" value=\"" + paymentInfo.getId_no() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"acct_name\" value=\"" + paymentInfo.getAcct_name() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"flag_modify\" value=\"" + paymentInfo.getFlag_modify() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"card_no\" value=\"" + paymentInfo.getCard_no() + "\"/>");
    sbHtml.append("<input type=\"hidden\" name=\"back_url\" value=\"" + paymentInfo.getBack_url() + "\"/>");

    // submit按钮控件请不要含有name属性
    sbHtml.append("</form>");
    sbHtml.append("<script>document.forms['llpaysubmit'].submit();</script>");
    if (LOG.isDebugEnabled()) {
      LOG.debug("生成支付表单html：{}", sbHtml.toString());
    }
    return sbHtml.toString();
  }

  private static PaymentInfo createPCPaymentInfo(String amount, String orderNo, String userId, String name, String idNo,
      String nameGoods, RiskItem riskItem) {
    // 构造支付请求对象
    PaymentInfo paymentInfo = new PaymentInfo();
    paymentInfo.setVersion("1.0");
    paymentInfo.setOid_partner(LlPayConfig.OID_PARTNER);
    paymentInfo.setUser_id(userId);
    paymentInfo.setSign_type(LlPayConfig.SIGN_TYPE);
    paymentInfo.setBusi_partner(LlPayConfig.BUSI_PARTNER);
    paymentInfo.setNo_order(orderNo);
    paymentInfo.setDt_order(DateUtil.getLocalDate("yyyyMMddHHmmss"));
    paymentInfo.setName_goods(nameGoods);
    paymentInfo.setInfo_order("汪汪信用");
    paymentInfo.setMoney_order(amount);
    paymentInfo.setNotify_url(LlPayConfig.NOTIFY_URL);
    paymentInfo.setUrl_return(LlPayConfig.URL_RETURN);
    // paymentInfo.setUserreq_ip("0:0:0:0:0:0:0:1");
    paymentInfo.setUrl_order("");
    paymentInfo.setValid_order("10080");// 单位分钟，可以为空，默认7天
    paymentInfo.setRisk_item(JsonUtil.toJson(riskItem));
    paymentInfo.setTimestamp(DateUtil.getLocalDate("yyyyMMddHHmmss"));
    // 从系统中获取用户身份信息
    paymentInfo.setId_type("0");
    paymentInfo.setId_no(idNo);
    paymentInfo.setAcct_name(name);
    paymentInfo.setFlag_modify("1");
    paymentInfo.setSign_type("RSA");
    paymentInfo.setPay_type("D");
    // paymentInfo.setCard_no(bankNo);
    // paymentInfo.setBack_url("http://0572b1ca.ngrok.io");

    // 加签名
    String sign = SignUtil.signByRSA(paymentInfo, LlPayConfig.TRADER_PRI_KEY);
    paymentInfo.setSign(sign);
    return paymentInfo;
  }

  public static String buildQuickPayH5Request(String amount, String orderNo, String userId, String name, String idNo,
      String bankCardNo, String nameGoods, RiskItem riskItem) {
    return buildH5Request(amount, orderNo, userId, name, idNo, bankCardNo, nameGoods, LlPayConfig.QUICK_PAY_H5_URL,
        riskItem);
  }

  public static String buildQuickPayH5Request(String amount, String orderNo, String userId, String name, String idNo,
      String nameGoods, RiskItem riskItem) {
    return buildH5Request(amount, orderNo, userId, name, idNo, null, nameGoods, LlPayConfig.QUICK_PAY_H5_URL, riskItem);
  }

  public static String buildH5Request(String amount, String orderNo, String userId, String name, String idNo,
      String nameGoods, RiskItem riskItem) {
    return buildH5Request(amount, orderNo, userId, name, idNo, null, nameGoods, LlPayConfig.PAY_H5_URL, riskItem);
  }

  public static String buildH5Request(String amount, String orderNo, String userId, String name, String idNo,
      String bankCardNo, String nameGoods, String reqUrl, RiskItem riskItem) {

    riskItem.setUser_info_identify_state("1");
    riskItem.setUser_info_identify_type("1");

    riskItem.setUser_info_mercht_userno(userId);
    riskItem.setUser_info_full_name(name);
    riskItem.setUser_info_id_no(idNo);

    String reqData = createH5PaymentInfo(amount, orderNo, userId, name, idNo, bankCardNo, nameGoods, riskItem);
    StringBuffer sbHtml = new StringBuffer();
    sbHtml.append("<form id=\"llpaysubmit\" name=\"llpaysubmit\" action=\"" + reqUrl + "\" method=\"POST\">");
    sbHtml.append("<input type=\"hidden\" name=\"req_data\" value=\'" + reqData + "\'/>");

    // submit按钮控件请不要含有name属性
    sbHtml.append("</form>");
    sbHtml.append("<script>document.forms['llpaysubmit'].submit();</script>");
    if (LOG.isDebugEnabled()) {
      LOG.debug("生成支付表单html：{}", sbHtml.toString());
    }
    return sbHtml.toString();
  }

  public static JsonPage buildWeChatPayRequest(String userId, String openId, String amount, String orderNo,
      RiskItem riskItem) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("no_order", orderNo);
    params.put("oid_partner", LlPayConfig.OID_PARTNER);
    params.put("appid", "wx293472955218c853");
    params.put("openid", openId);
    params.put("busi_partner", "101001");
    params.put("money_order", amount);
    params.put("no_order", orderNo);
    params.put("user_id", userId);
    params.put("col_oidpartner", LlPayConfig.OID_PARTNER);
    params.put("dt_order", DateUtil.format(new Date(), DateUtil.dtLong));
    params.put("notify_url", LlPayConfig.URL_RETURN);
    params.put("pay_type", "W");
    params.put("risk_item", JsonUtil.toJson(riskItem));
    params.put("sign_type", "RSA");
    String sign = SignUtil.signByRSA(params, LlPayConfig.TRADER_PRI_KEY);
    params.put("sign", sign);
    String jsonData = JsonUtil.toJson(params);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8 ");
    String resp = HttpUtil.post(COMBINE_PAY_URL, null, headers, jsonData);
    if (LOG.isDebugEnabled()) {
      LOG.debug("请求连连微信支付API返回结果：{}", resp);
    }
    @SuppressWarnings("unchecked")
    Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
    String ret_code = resultMap.get("ret_code");
    String returnSign = resultMap.get("sign");
    resultMap.remove("sign");
    String payLoadJson = JsonUtil.toJson(resultMap.get("payLoad"));
    resultMap.put("payLoad", payLoadJson);
    if ("0000".equals(ret_code)) {
      // String srcStr = SignUtil.createLinkString(resultMap);
      return JsonPage.createMsg(true, payLoadJson);
      // boolean isSign = RSAUtil.checkSign(LlPayConfig.YT_PUB_KEY, srcStr,
      // returnSign);
      // if (isSign) {
      // return payLoadJson;
      // } else {
      // LOG.warn("请求连连钱包API返回结果验签失败：{}", resp);
      // return null;
      // }
    } else {
      if (LOG.isWarnEnabled()) {
        LOG.warn("请求连连钱包API未成功：{}", resp);
      }
      return JsonPage.createMsg(false, resultMap.get("ret_msg"));
    }
  }

  public static JsonPage buildWeChatPayRequest(String userId, String openId, String amount, String orderNo) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("no_order", orderNo);
    params.put("oid_partner", LlPayConfig.OID_PARTNER);
    params.put("appid", "wx293472955218c853");
    params.put("openid", openId);
    params.put("busi_partner", "101001");
    params.put("money_order", amount);
    params.put("no_order", orderNo);
    params.put("user_id", userId);
    params.put("col_oidpartner", LlPayConfig.OID_PARTNER);
    params.put("dt_order", DateUtil.format(new Date(), DateUtil.dtLong));
    params.put("notify_url", LlPayConfig.URL_RETURN);
    params.put("pay_type", "W");
    params.put("risk_item", createRiskItem());
    params.put("sign_type", "RSA");
    String sign = SignUtil.signByRSA(params, LlPayConfig.TRADER_PRI_KEY);
    params.put("sign", sign);
    String jsonData = JsonUtil.toJson(params);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8 ");
    String resp = HttpUtil.post(COMBINE_PAY_URL, null, headers, jsonData);
    if (LOG.isDebugEnabled()) {
      LOG.debug("请求连连微信支付API返回结果：{}", resp);
    }
    @SuppressWarnings("unchecked")
    Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
    String ret_code = resultMap.get("ret_code");
    String returnSign = resultMap.get("sign");
    resultMap.remove("sign");
    String payLoadJson = JsonUtil.toJson(resultMap.get("payLoad"));
    resultMap.put("payLoad", payLoadJson);
    if ("0000".equals(ret_code)) {
      // String srcStr = SignUtil.createLinkString(resultMap);
      return JsonPage.createMsg(true, payLoadJson);
      // boolean isSign = RSAUtil.checkSign(LlPayConfig.YT_PUB_KEY, srcStr,
      // returnSign);
      // if (isSign) {
      // return payLoadJson;
      // } else {
      // LOG.warn("请求连连钱包API返回结果验签失败：{}", resp);
      // return null;
      // }
    } else {
      if (LOG.isWarnEnabled()) {
        LOG.warn("请求连连钱包API未成功：{}", resp);
      }
      return JsonPage.createMsg(false, resultMap.get("ret_msg"));
    }
  }

  public static JsonPage buildWeChatPayRequest(LlPayConfig llPayConfig, String userId, String openId, String amount,
      String orderNo, RiskItem riskItem) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("no_order", orderNo);
    params.put("oid_partner", llPayConfig.OID_PARTNER);
    params.put("appid", "wx293472955218c853");
    params.put("openid", openId);
    params.put("busi_partner", "101001");
    params.put("money_order", amount);
    params.put("no_order", orderNo);
    params.put("user_id", userId);
    params.put("col_oidpartner", llPayConfig.OID_PARTNER);
    params.put("dt_order", DateUtil.format(new Date(), DateUtil.dtLong));
    params.put("notify_url", llPayConfig.NOTIFY_URL);
    params.put("pay_type", "W");
    params.put("risk_item", createRiskItem());
    params.put("sign_type", "RSA");
    params.put("risk_item", JsonUtil.toJson(riskItem));
    String sign = SignUtil.signByRSA(params, llPayConfig.TRADER_PRI_KEY);
    params.put("sign", sign);
    String jsonData = JsonUtil.toJson(params);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Content-Type", "application/json;charset=UTF-8 ");
    LOG.info("微信支付调用连连支付参数:{}", jsonData);
    String resp = HttpUtil.post(COMBINE_PAY_URL, null, headers, jsonData);
    if (LOG.isDebugEnabled()) {
      LOG.debug("请求连连微信支付API返回结果：{}", resp);
    }
    @SuppressWarnings("unchecked")
    Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
    String ret_code = resultMap.get("ret_code");
    String returnSign = resultMap.get("sign");
    resultMap.remove("sign");
    String payLoadJson = JsonUtil.toJson(resultMap.get("payLoad"));
    resultMap.put("payLoad", payLoadJson);
    if ("0000".equals(ret_code)) {
      // String srcStr = SignUtil.createLinkString(resultMap);
      return JsonPage.createMsg(true, payLoadJson);
      // boolean isSign = RSAUtil.checkSign(LlPayConfig.YT_PUB_KEY, srcStr,
      // returnSign);
      // if (isSign) {
      // return payLoadJson;
      // } else {
      // LOG.warn("请求连连钱包API返回结果验签失败：{}", resp);
      // return null;
      // }
    } else {
      if (LOG.isWarnEnabled()) {
        LOG.warn("请求连连钱包API未成功：{}", resp);
      }
      return JsonPage.createMsg(false, resultMap.get("ret_msg"));
    }
  }

  private static String createH5PaymentInfo(String amount, String orderNo, String userId, String name, String idNo,
      String bankCardNo, String nameGoods, RiskItem riskItem) {
    PaymentInfo payInfo = new PaymentInfo();
    payInfo.setApp_request("3");
    // payInfo.setBg_color(request.getParameter("bg_color"));
    payInfo.setBusi_partner(LlPayConfig.BUSI_PARTNER);
    payInfo.setCard_no(bankCardNo);
    payInfo.setDt_order(DateUtil.getLocalDate("yyyyMMddHHmmss"));
    payInfo.setId_no(idNo);
    payInfo.setInfo_order("汪汪信用");
    payInfo.setMoney_order(amount);
    payInfo.setName_goods(nameGoods);
    payInfo.setNo_agree("");
    payInfo.setNo_order(orderNo);
    payInfo.setNotify_url(LlPayConfig.NOTIFY_URL);
    payInfo.setOid_partner(LlPayConfig.OID_PARTNER);
    payInfo.setAcct_name(name);
    payInfo.setRisk_item(JsonUtil.toJson(riskItem));
    payInfo.setSign_type("MD5");
    payInfo.setUrl_return(LlPayConfig.URL_RETURN);
    payInfo.setUser_id(userId);
    // payInfo.setValid_order("30");
    // payInfo.setBack_url(LlPayConfig.URL_RETURN);// modify by wys

    // 加签名
    String sign = SignUtil.sign(payInfo, "&key=" + LlPayConfig.MD5_KEY);
    // String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(payInfo)),
    // LlPayConfig.TRADER_PRI_KEY, LlPayConfig.MD5_KEY);
    payInfo.setSign(sign);
    String req_data = JSON.toJSONString(payInfo);
    return req_data;
  }

  public static String orderQuery(String orderNo) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("oid_partner", LlPayConfig.OID_PARTNER);
    params.put("sign_type", "RSA");
    params.put("no_order", orderNo);
    params.put("dt_order", DateUtil.getLocalDate("yyyyMMddHHmmss"));

    // 加签名
    String sign = SignUtil.signByRSA(params, LlPayConfig.TRADER_PRI_KEY);
    params.put("sign", sign);
    String resp = HttpUtil.post(ORDER_QUERY_URL, null, null, JsonUtil.toJson(params));
    if (LOG.isDebugEnabled()) {
      LOG.debug("请求连连支付结果查询API返回结果：{}", resp);
    }

    @SuppressWarnings("unchecked")
    Map<String, String> resultMap = JsonUtil.fromJson(resp, HashMap.class);
    String ret_code = resultMap.get("ret_code");
    if ("0000".equals(ret_code)) {
      Map<String, String> resultPay = new HashMap<>();
      resultPay.put("SUCCESS", "支付成功");
      resultPay.put("WAITING", "等待支付");
      resultPay.put("PROCESSING", "银行支付处理中");
      resultPay.put("REFUND", "退款");
      resultPay.put("FAILURE", "失败");
      return resultPay.get(resultMap.get("result_pay"));
    } else {
      if (LOG.isWarnEnabled()) {
        LOG.warn("请求连连钱包API未成功：{}", resp);
      }
      return "ret_msg";
    }
  }

  /**
   * 根据连连支付风控部门要求的参数进行构造风控参数
   * 
   * @return
   */
  // private static String createRiskItem(String userId) {
  // JSONObject riskItemObj = new JSONObject();
  // riskItemObj.put("user_info_mercht_userno", userId);
  // return riskItemObj.toString();
  // }
  public static String createRiskItem() {
    Map<String, String> params = new HashMap<String, String>();
    params.put("frms_ware_category", "2013");
    params.put("user_info_mercht_userno", "001");
    return JsonUtil.toJson(params);
  }

  public static void main(String[] args) {

    // LlPayConfig llf = new LlPayConfig();
    LlPayConfig.MD5_KEY = "xxx";
    LlPayConfig.TRADER_PRI_KEY =
        "xx/vMzCxFsvZpqqJtLACq/LdU7995RLsipDgatXjE2Q1EJLDpUgJfmEPFN4lbTIM4alqHhhP+DFtbBduDy+j9RAe7XiNIOB8RBoGuaQ5qDRMi7mvyTZ3K/p5jXuqnW5ghNqWa5b0B3+2nQ+jEYYCPBkWJehGTlW3asrAgMBAAECgYAw12dOaBXxRt+6V0KTksWdooq093ZQyiFiTVA1dXeO9UA/AW3vi7MXBz9mp5X7Xefuu0gOZsizV1GC9Z6RwCdKrxskVyDIHHD4BP8BiazOKBhbuWATFBxP7X/3aQjzDciBgQHv6RCLTqWPTTslc8oGfHVHBeOE1Wob/t3cbVZXEQJBAN75TMmTcbhIQXC4T5xXlriygSG6ePdZtVsZj0MSngxssMpV/1O6TTHLWAYwx/KkfhOv+3Ror7beQbeY2FJSrX8CQQDXZIfqGyebikL9hKCEMA8cz1tqX8sAtyKVpCFaKthMZEFFSY5E4nIuGaLX8PprKiJcvNnKcs8z3teIbVWYvfBVAkBqHBGiy/wOSrR5w/x+1l/vvWMeffMbIyHfHKbEsJNuLjtjztEXM02RKMfXClfc7NLi45iyqS8Vw2day+4GHzpZAkEAu48C+0xiFQM0imYvEGx4/HFj/SElOJ5AM2YU1NtyNjMm0xrWFA3Lt3EDaF6i8SZjfbXFQJDw9Q4bSOVMIBFlcQJASp/yM5ixV2g6ZdLEckElMKuHN39YdfvhsFTUpaSgu+n26onLtrZDqDT+tl7Jux1xrcUE+ufENd0jFLe7RGztOg==";
    LlPayConfig.YT_PUB_KEY =
        "xx/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    LlPayConfig.OID_PARTNER = "xx"; // 用户所属商户号
    LlPayConfig.NOTIFY_URL = "xx";
    LlPayConfig.URL_RETURN = "xx";

    String orderNo = DateUtil.getOrderNum();

    RiskItem riskItem = new RiskItem();

    riskItem.setFrms_ware_category("2013");
    riskItem.setUser_info_mercht_userno("0bb6b963d2e64d42811abf42eb56ef5f"); // 平台的用户id
    riskItem.setUser_info_bind_phone("15521383741"); // 绑定的手机号
    riskItem.setUser_info_id_no("44203219941011300572");// 用户身份证号
    riskItem.setUser_info_full_name("赵孝智");// 用户姓名
    riskItem.setUser_info_identify_type("1");// 实名认证方式
    riskItem.setUser_info_identify_state("1");// 是否实名认证
    riskItem.setUser_info_dt_register(DateUtil.getLocalDate(DateUtil.dtLong));

    // JsonPage jp = buildWeChatPayRequest("d31dc6d16e6b4f2ebafa78e7765467e7",
    // "oDMiAvxsxSnq_b1RWbtCY5Jh4epE", "0.01", orderNo, riskItem);
    String queryOrderNo = "20180305175050687";
    orderQuery(queryOrderNo);

  }
}
