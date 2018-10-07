package com.mideadc.component.llpay;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.LianLianPaySecurity;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llpay.bean.PaymentInfo;
import com.mideadc.component.llpay.config.LlPayConfig;

/**
 * 实时付款
 * 
 * @author spirng
 *
 */
public class RealtimePaymentSubmit {
  private static final Logger LOG = LoggerFactory.getLogger(RealtimePaymentSubmit.class);
  public static final String URL = "https://instantpay.lianlianpay.com/paymentapi/payment.htm";

  /**
   * 
   * @param name 姓名
   * @param cardNo 银行卡号
   * @param amount 金额
   * @param orderNo 订单号
   * @param remark 备注
   * @param flag_card 对公对私标志 0：对私 1：对公
   * @return
   */
  public static String submit(String name, String cardNo, String amount, String orderNo, String remark, int flag_card) {
    Map<String, String> params = new HashMap<String, String>();
    PaymentInfo info = createPaymentInfo(name, cardNo, amount, orderNo, remark, flag_card);
    String json = JsonUtil.toJson(info);
    try {
      if (LOG.isDebugEnabled()) {
        LOG.debug("实时付款请求参数：{}", json);
      }
      String encryptStr = LianLianPaySecurity.encrypt(json, LlPayConfig.YT_PUB_KEY);
      params.put("pay_load", encryptStr);
      params.put("oid_partner", LlPayConfig.OID_PARTNER);
      String reqJson = JsonUtil.toJson(params);
      Map<String, String> headers = new HashMap<String, String>();
      headers.put("Content-Type", "application/json");
      String response = HttpUtil.post(URL, null, headers, reqJson);
      Map<String, String> responseParams = JsonUtil.fromJson(response, HashMap.class);
      String code = responseParams.get("ret_code");
      if (StringUtils.isNoneBlank(code) && "0000".equals(code)) {
        return "success";
      }
      return response;
    } catch (Exception e) {
      LOG.error("实时付款时出错", e);
    }
    return "false";
  }

  private static PaymentInfo createPaymentInfo(String name, String cardNo, String amount, String orderNo, String remark,
      int flag_card) {
    PaymentInfo info = new PaymentInfo();
    info.setOid_partner(LlPayConfig.OID_PARTNER);
    info.setApi_version("1.0");
    info.setSign_type("RSA");
    info.setNo_order(orderNo);
    info.setDt_order(DateUtil.getLocalDate(DateUtil.dtLong));
    info.setCard_no(cardNo);
    info.setAcct_name(name);
    info.setMoney_order(amount);
    info.setInfo_order("实时付款");
    info.setFlag_card(flag_card + "");
    info.setNotify_url(LlPayConfig.REAL_TIME_NOTIFY_URL);
    info.setMemo(remark);
    String sign = SignUtil.signByRSA(info, LlPayConfig.TRADER_PRI_KEY);
    info.setSign(sign);
    return info;
  }

  public static void main(String[] args) {

    LlPayConfig.MD5_KEY = "xx";
    LlPayConfig.OID_PARTNER = "xx";
    LlPayConfig.REAL_TIME_NOTIFY_URL = "xx";
    String cardNo = "";
    LlPayConfig.YT_PUB_KEY =
        "xx/DiwdCf/aZsxxcacDnooGph3d2JOj5GXWi+q3gznZauZjkNP8SKl3J2liP0O6rU/Y/29+IUe+GTMhMOFJuZm1htAtKiu5ekW0GlBMWxf4FPkYlQkPE0FtaoMP3gYfh+OwI+fIRrpW3ySn3mScnc6Z700nU/VYrRkfcSCbSnRwIDAQAB";
    LlPayConfig.TRADER_PRI_KEY =
        "xx/vMzCxFsvZpqqJtLACq/LdU7995RLsipDgatXjE2Q1EJLDpUgJfmEPFN4lbTIM4alqHhhP+DFtbBduDy+j9RAe7XiNIOB8RBoGuaQ5qDRMi7mvyTZ3K/p5jXuqnW5ghNqWa5b0B3+2nQ+jEYYCPBkWJehGTlW3asrAgMBAAECgYAw12dOaBXxRt+6V0KTksWdooq093ZQyiFiTVA1dXeO9UA/AW3vi7MXBz9mp5X7Xefuu0gOZsizV1GC9Z6RwCdKrxskVyDIHHD4BP8BiazOKBhbuWATFBxP7X/3aQjzDciBgQHv6RCLTqWPTTslc8oGfHVHBeOE1Wob/t3cbVZXEQJBAN75TMmTcbhIQXC4T5xXlriygSG6ePdZtVsZj0MSngxssMpV/1O6TTHLWAYwx/KkfhOv+3Ror7beQbeY2FJSrX8CQQDXZIfqGyebikL9hKCEMA8cz1tqX8sAtyKVpCFaKthMZEFFSY5E4nIuGaLX8PprKiJcvNnKcs8z3teIbVWYvfBVAkBqHBGiy/wOSrR5w/x+1l/vvWMeffMbIyHfHKbEsJNuLjtjztEXM02RKMfXClfc7NLi45iyqS8Vw2day+4GHzpZAkEAu48C+0xiFQM0imYvEGx4/HFj/SElOJ5AM2YU1NtyNjMm0xrWFA3Lt3EDaF6i8SZjfbXFQJDw9Q4bSOVMIBFlcQJASp/yM5ixV2g6ZdLEckElMKuHN39YdfvhsFTUpaSgu+n26onLtrZDqDT+tl7Jux1xrcUE+ufENd0jFLe7RGztOg==";
    String amount = "1.00";
    String orderNo = DateUtil.getOrderNum();
    String name = "";
    String remark = "我的测试";
    int flag_card = 0;
    RealtimePaymentSubmit.submit(name, cardNo, amount, orderNo, remark, flag_card);
  }
}
