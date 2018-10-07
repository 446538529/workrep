package com.mideadc.component.wechat.pay;

import java.util.Date;
import java.util.Map;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JaxbUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.commons.domain.utils.UUIDUtils;
import com.mideadc.component.wechat.bean.PayRequest;
import com.mideadc.component.wechat.bean.RedPack;
import com.mideadc.component.wechat.bean.RedPackRecord;
import com.mideadc.component.wechat.bean.RedPackRecordResp;
import com.mideadc.component.wechat.bean.RedPackResp;
import com.mideadc.component.wechat.bean.Refund;
import com.mideadc.component.wechat.bean.UnifiedOrder;
import com.mideadc.component.wechat.bean.UnifiedOrderResp;
import com.mideadc.component.wechat.config.WeChatConfig;

@SuppressWarnings("unchecked")
public class WeChatPay {
  private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPay.class);
  private static String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
  private static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
  private static String RED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
  private static String RED_PACK_RECORD_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";

  /**
   * 统一下单
   * 
   * @param openId
   * @param subject
   * @param out_trade_no
   * @param total_fee
   * @return
   */
  public static UnifiedOrderResp createUnifiedOrder(String openId, String subject, String out_trade_no,
      String total_fee, String tradeType, WeChatConfig weChatConfig) {
    UnifiedOrder unifiedOrder = new UnifiedOrder();
    unifiedOrder.setAppid(weChatConfig.PAYAPPID);
    unifiedOrder.setMch_id(weChatConfig.MCH_ID);
    unifiedOrder.setBody(subject);
    unifiedOrder.setNonce_str(new Date().getTime() + "");
    unifiedOrder.setNotify_url(weChatConfig.NOTIFY_URL);
    unifiedOrder.setOut_trade_no(out_trade_no);
    unifiedOrder.setSpbill_create_ip("192.168.1.1");
    unifiedOrder.setTotal_fee(total_fee);
    unifiedOrder.setTrade_type(tradeType);
    unifiedOrder.setOpenid(openId);

    unifiedOrder.setSign(SignUtil.sign(unifiedOrder, "&key=" + weChatConfig.KEY));

    String xml = JaxbUtil.convertToXml(unifiedOrder);
    LOGGER.debug("统一下单body:{}", xml);
    String resp = HttpUtil.post(ORDER_URL, null, null, xml);
    LOGGER.debug("统一下单Response:{}", resp);
    UnifiedOrderResp unifiedOrderResp = JaxbUtil.converyToJavaBean(resp, UnifiedOrderResp.class);
    return unifiedOrderResp;
  }

  /**
   * 发送红包
   * 
   * @param orderNo
   * @param sendName
   * @param openId
   * @param totalAmount
   * @param wishing
   * @return
   */
  public static RedPackResp sendRedPack(String orderNo, String sendName, String openId, String totalAmount,
      String wishing, WeChatConfig weChatConfig) {
    RedPack rp = new RedPack();
    rp.setNonce_str(UUIDUtils.uuid());
    rp.setMch_billno(orderNo);
    rp.setMch_id(weChatConfig.MCH_ID);
    rp.setWxappid(weChatConfig.APPID);
    rp.setSend_name(sendName);
    rp.setRe_openid(openId);
    rp.setTotal_amount(totalAmount);
    rp.setTotal_num("1");
    rp.setWishing(wishing);
    rp.setClient_ip("192.168.1.1");
    rp.setAct_name("活动");
    // rp.setRemark(remark);
    rp.setSign(SignUtil.sign(rp, "&key=" + weChatConfig.KEY));
    String xml = JaxbUtil.convertToXml(rp);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("发放红包body:{}", xml);
    }
    SSLConnectionSocketFactory sslsf =
        HttpUtil.createSSLConnectionSocketFactory(weChatConfig.CERTIFICATE_PATH, weChatConfig.CERTIFICATE_PASSWORD);
    String resp = HttpUtil.postWidthCertificate(RED_PACK_URL, xml, sslsf);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("发放红包Response:{}", resp);
    }
    RedPackResp redPackResp = JaxbUtil.converyToJavaBean(resp, RedPackResp.class);
    return redPackResp;
  }

  /**
   * 查询发送红包记录
   *
   * @param orderNo
   * @return
   */
  public static RedPackRecordResp createRedPackRecordResp(String orderNo, WeChatConfig weChatConfig) {
    RedPackRecord redPackRecord = new RedPackRecord();
    redPackRecord.setAppid(weChatConfig.APPID);
    redPackRecord.setNonce_str(UUIDUtils.uuid());
    redPackRecord.setBill_type("MCHT");
    redPackRecord.setMch_id(weChatConfig.MCH_ID);
    redPackRecord.setMch_billno(orderNo);
    redPackRecord.setSign(SignUtil.sign(redPackRecord, "&key=" + weChatConfig.KEY));
    String xml = JaxbUtil.convertToXml(redPackRecord);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("查询红包发送body:{}", xml);
    }
    SSLConnectionSocketFactory sslsf =
        HttpUtil.createSSLConnectionSocketFactory(weChatConfig.CERTIFICATE_PATH, weChatConfig.CERTIFICATE_PASSWORD);
    String resp = HttpUtil.postWidthCertificate(RED_PACK_RECORD_URL, xml, sslsf);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("查询红包发送Response:{}", resp);
    }
    RedPackRecordResp redPackRecordResp = JaxbUtil.converyToJavaBean(resp, RedPackRecordResp.class);
    return redPackRecordResp;
  }

  public static void refund(String out_trade_no, String total_fee, WeChatConfig weChatConfig) {
    Refund refund = new Refund();
    refund.setAppid(weChatConfig.APPID);
    refund.setMch_id(weChatConfig.MCH_ID);
    refund.setNonce_str(new Date().getTime() + "");
    refund.setOp_user_id(weChatConfig.MCH_ID);
    refund.setOut_refund_no(out_trade_no);
    refund.setOut_trade_no(out_trade_no);
    refund.setRefund_fee(total_fee);
    refund.setTotal_fee(total_fee);
    refund.setSign(SignUtil.sign(refund, "&key=" + weChatConfig.KEY));

    String xml = JaxbUtil.convertToXml(refund);
    LOGGER.debug("申请退款body:{}", xml);

    SSLConnectionSocketFactory sslsf =
        HttpUtil.createSSLConnectionSocketFactory(weChatConfig.CERTIFICATE_PATH, weChatConfig.CERTIFICATE_PASSWORD);
    String resp = HttpUtil.postWidthCertificate(REFUND_URL, xml, sslsf);
    LOGGER.debug("申请退款Response:{}", resp);
  }

  /**
   * 创建支付请求参数
   * 
   * @param prepayId
   * @return
   */
  public static PayRequest createPayRequest(String prepayId, WeChatConfig weChatConfig) {
    PayRequest payRequest = new PayRequest();
    payRequest.setAppId(weChatConfig.PAYAPPID);
    payRequest.setTimeStamp(new Date().getTime() + "");
    payRequest.setNonceStr(new Date().getTime() + "");
    payRequest.setPackage1("prepay_id=" + prepayId);
    payRequest.setSignType("MD5");

    String json = JsonUtil.toJson(payRequest);
    Map<String, String> map = JsonUtil.fromJson(json, Map.class);
    payRequest.setPaySign(SignUtil.sign(map, "&key=" + weChatConfig.KEY));
    LOGGER.debug("创建支付请求参数:{}", map);
    return payRequest;
  }
}
