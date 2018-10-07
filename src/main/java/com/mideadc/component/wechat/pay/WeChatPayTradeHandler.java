package com.mideadc.component.wechat.pay;

public interface WeChatPayTradeHandler {

	/**
	 * 支付成功时的回调
	 * 
	 * @param mch_id
	 *            商户号
	 * @param out_trade_no
	 *            商户订单号
	 * @param trade_no
	 *            微信支付订单号
	 * @param total_fee
	 *            订单金额
	 */
	public void success(String mch_id, String out_trade_no, String trade_no, String total_fee);

	public void fail(String out_trade_no, String trade_no);

	public String getWeChatKey(String mch_id);
}
