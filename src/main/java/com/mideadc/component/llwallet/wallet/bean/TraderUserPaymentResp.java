package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 2.1 商户付款 B2C(所属+收款商户号)
 * 企业钱包
 * 5.6 商户付款钱包用户接口（B2C）
 * 
 * @author spirng
 *
 */
public class TraderUserPaymentResp extends BaseParamsResp {
	private static final long serialVersionUID = 5545567836367976968L;
	// 商户订单时间
	private String dt_order;
	// 商户唯一订单号
	private String no_order;
	// 交易金额
	private String money_order;
	// 连连钱包支付单号
	private String oid_paybill;

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}

	public String getOid_paybill() {
		return oid_paybill;
	}

	public void setOid_paybill(String oid_paybill) {
		this.oid_paybill = oid_paybill;
	}

}
