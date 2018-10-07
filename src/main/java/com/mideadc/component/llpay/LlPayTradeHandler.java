package com.mideadc.component.llpay;

public interface LlPayTradeHandler {

	/**
	 * 支付成功时的回调函数
	 * 
	 * @param no_order
	 *            商户请求时的订单号
	 * @param result_pay
	 *            扣款结果
	 * @param oid_partner
	 *            商户号
	 */
//	public void success(String no_order, String result_pay, String oid_partner);

	/**
	 * 支付成功时的回调函数
	 *
	 * @param no_order
	 *            商户请求时的订单号
	 * @param result_pay
	 *            扣款结果
	 * @param oid_partner
	 *            商户号
	 * @param info_order
	 *            订单描述（通过下划线拼接商户订单描述和付款失败原因）
	 */
	public void success(String no_order, String result_pay, String oid_partner, String info_order);


	/**
	 * 支付失败时的回调函数
	 * 
	 */
	public void fail(String msg);

}
