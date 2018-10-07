package com.mideadc.component.llpay;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.RSAUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llpay.config.LlPayConfig;

/**
 * 支付结果
 * 
 * @author Spring
 *
 */
public class LlPayResult {

  private static final Logger LOG = LoggerFactory.getLogger(LlPayResult.class);

  /**
   * 
   * @param request
   * @param no_order 商户请求时的订单号
   * @param result_pay 扣款结果
   */
  // @SuppressWarnings("unchecked")
  // public static String doHandler(HttpServletRequest request, LlPayTradeHandler handler) {
  // try {
  // String requestBody = IOUtils.toString(request.getInputStream());
  // LOG.debug("连连支付结果回调通知：\r\n{} \r\n", requestBody);
  // if (StringUtils.isBlank(requestBody)) {
  // if (LOG.isWarnEnabled()) {
  // LOG.warn("没有接收到参数");
  // }
  // return null;
  // }
  // Map<String, String> params = JsonUtil.fromJson(requestBody, HashMap.class);
  // Map<String, String> resultParams = new HashMap<String, String>();
  // if (checkSign(params)) {
  // resultParams.put("ret_code", "0000");
  // resultParams.put("ret_msg", "交易成功");
  // handler.success(params.get("no_order"), params.get("result_pay"), params.get("oid_partner"));
  // } else {
  // resultParams.put("ret_code", "9999");
  // resultParams.put("ret_msg", "验签失败");
  // handler.fail("验签失败");
  // }
  // String responseJson = JsonUtil.toJson(resultParams);
  // LOG.debug("返回给连连： \r\n{} \r\n", responseJson);
  // return responseJson;
  // } catch (Exception e) {
  // handler.fail("连连支付回调通知异常");
  // LOG.error("连连支付回调通知异常", e);
  // }
  // return null;
  // }

  /**
   * 验签
   * 
   * @param params
   * @return
   */
  private static boolean checkSign(Map<String, String> params) {
    try {
      String signType = params.get("sign_type");
      String llSign = params.get("sign");
      params.remove("sign");
      if (signType.equals("RSA")) {
        return RSAUtil.checkSign(LlPayConfig.YT_PUB_KEY, SignUtil.createLinkString(params), llSign);
      } else {
        String sign = SignUtil.sign(params, "&key=" + LlPayConfig.MD5_KEY);
        return sign.equals(llSign);
      }
    } catch (Exception e) {
      LOG.error("验签失败", e);
    }
    return false;
  }

  /**
   *
   * @param request
   * @param no_order 商户请求时的订单号
   * @param result_pay 扣款结果
   * @param oid_partner 扣款结果
   * @param info_order 扣款结果
   */
  @SuppressWarnings("unchecked")
  public static String doHandler(HttpServletRequest request, LlPayTradeHandler handler) {
    try {
      String requestBody = IOUtils.toString(request.getInputStream());
      LOG.debug("连连支付结果回调通知：\r\n{} \r\n", requestBody);
      if (StringUtils.isBlank(requestBody)) {
        if (LOG.isWarnEnabled()) {
          LOG.warn("没有接收到参数");
        }
        return null;
      }
      Map<String, String> params = JsonUtil.fromJson(requestBody, HashMap.class);
      Map<String, String> resultParams = new HashMap<String, String>();
      if (checkSign(params)) {
        resultParams.put("ret_code", "0000");
        resultParams.put("ret_msg", "交易成功");
        handler.success(params.get("no_order"), params.get("result_pay"), params.get("oid_partner"),
            params.get("info_order") == null ? null : params.get("info_order"));
      } else {
        resultParams.put("ret_code", "9999");
        resultParams.put("ret_msg", "验签失败");
        handler.fail("验签失败");
      }
      String responseJson = JsonUtil.toJson(resultParams);
      LOG.debug("返回给连连： \r\n{} \r\n", responseJson);
      return responseJson;
    } catch (Exception e) {
      handler.fail("连连支付回调通知异常");
      LOG.error("连连支付回调通知异常", e);
    }
    return null;
  }
}
