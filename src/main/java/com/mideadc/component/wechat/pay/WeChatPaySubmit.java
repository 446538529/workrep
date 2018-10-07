package com.mideadc.component.wechat.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.component.wechat.bean.PayRequest;
import com.mideadc.component.wechat.bean.RedPackRecordResp;
import com.mideadc.component.wechat.bean.RedPackResp;
import com.mideadc.component.wechat.bean.RedPackSendResult;
import com.mideadc.component.wechat.bean.UnifiedOrderResp;
import com.mideadc.component.wechat.config.WeChatConfig;

public class WeChatPaySubmit {
	private static final Logger LOGGER = LoggerFactory.getLogger(WeChatPaySubmit.class);

	/**
	 * 微信公众号中支付
	 * 
	 * @param subject
	 *            标题
	 * @param out_trade_no
	 *            订单号
	 * @param total_fee
	 *            额度，单位分
	 * @param openId
	 *            支付用户的openId
	 * @return
	 */
	public static String buildRequest(String subject, String out_trade_no, String total_fee, String openId, WeChatConfig weChatConfig) {
		UnifiedOrderResp unifiedOrderResp = WeChatPay.createUnifiedOrder(openId, subject, out_trade_no, total_fee, "JSAPI", weChatConfig);
		String prepayId = unifiedOrderResp.getPrepay_id();
		PayRequest payRequest = WeChatPay.createPayRequest(prepayId, weChatConfig);
		String wxJson = JsonUtil.toJson(payRequest);
		return wxJson;
	}

	/**
	 * 生成二维码，用户用微信扫描支付
	 * 
	 * @param subject
	 *            标题
	 * @param out_trade_no
	 *            订单号
	 * @param total_fee
	 *            额度，单位分
	 * @return
	 */
	public static String buildCodeUrl(String subject, String out_trade_no, String total_fee, WeChatConfig weChatConfig) {
		UnifiedOrderResp unifiedOrderResp = WeChatPay.createUnifiedOrder(null, subject, out_trade_no, total_fee, "NATIVE", weChatConfig);
		String codeUrl = unifiedOrderResp.getCode_url();
		return codeUrl;
	}

	/**
	 * 发红包
	 * 
	 * @param sendName
	 *            发送人名称
	 * @param openId
	 *            接收用户用户openId
	 * @param totalAmount
	 *            额度，单位分
	 * @param wishing
	 *            祝福语
	 * @return
	 */
	public static boolean sendRedPack(String orderNo, String sendName, String openId, String totalAmount, String wishing, WeChatConfig weChatConfig) {
		RedPackResp resp = WeChatPay.sendRedPack(orderNo, sendName, openId, totalAmount, wishing, weChatConfig);
		if ("SUCCESS".equals(resp.getReturn_code()) && "SUCCESS".equals(resp.getResult_code())) {
			return true;
		}
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("发送微信红包失败：{}", resp);
		}
		return false;
	}

	/**
	 * 查询发送红包记录
	 *
	 * @param orderNo
	 *            订单号
	 * @return
	 */
	public static RedPackSendResult getRedPackSendResult(String orderNo, WeChatConfig weChatConfig) {
		RedPackRecordResp redPackRecordResp = WeChatPay.createRedPackRecordResp(orderNo, weChatConfig);
		RedPackSendResult redPackSendResult = new RedPackSendResult();
		if ("SUCCESS".equals(redPackRecordResp.getReturn_code()) && "SUCCESS".equals(redPackRecordResp.getResult_code())) {
			redPackSendResult.setReason(redPackRecordResp.getReason());
			if (redPackRecordResp.getStatus().equals("SENDING")) {
				redPackSendResult.setStatus(1);
			} else if (redPackRecordResp.getStatus().equals("SENT")) {
				redPackSendResult.setStatus(2);
			} else if (redPackRecordResp.getStatus().equals("FAILED")) {
				redPackSendResult.setStatus(3);
			} else if (redPackRecordResp.getStatus().equals("RECEIVED")) {
				redPackSendResult.setStatus(4);
			} else if (redPackRecordResp.getStatus().equals("RFUND_ING")) {
				redPackSendResult.setStatus(5);
			} else if (redPackRecordResp.getStatus().equals("REFUND")) {
				redPackSendResult.setStatus(6);
			}

			return redPackSendResult;
		}
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error("查询红包发送结果：{}", redPackRecordResp);
		}
		return redPackSendResult;
	}
}
