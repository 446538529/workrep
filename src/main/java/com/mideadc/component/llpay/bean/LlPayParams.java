package com.mideadc.component.llpay.bean;

/**
 * 支付参数
 * 
 * @author Spring
 *
 */
public class LlPayParams {

	/**
	 * 交易订单号,16位长度
	 */
	private String orderNo;

	/**
	 * 该笔订单的资金总额，单位为 RMB-元
	 */
	private String transAmount;

	/**
	 * 1-WEB、2-IOS、3-ANDROID、4-WAP、5- 其他
	 */
	private String appType;

	/**
	 * 商户编号
	 */
	private String oidPartner;

	/**
	 * 清算日期
	 */
	private String settleDate;

	/**
	 * 连连支付支付单号
	 */
	private String lianlianPayOrderId;

	/**
	 * 银行编号
	 */
	private String bankCode;

	public LlPayParams() {
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo( String orderNo ) {
		this.orderNo = orderNo;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount( String transAmount ) {
		this.transAmount = transAmount;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType( String appType ) {
		this.appType = appType;
	}


	public String getOidPartner() {
		return oidPartner;
	}


	public void setOidPartner( String oidPartner ) {
		this.oidPartner = oidPartner;
	}


	public String getSettleDate() {
		return settleDate;
	}


	public void setSettleDate( String settleDate ) {
		this.settleDate = settleDate;
	}


	public String getLianlianPayOrderId() {
		return lianlianPayOrderId;
	}


	public void setLianlianPayOrderId( String lianlianPayOrderId ) {
		this.lianlianPayOrderId = lianlianPayOrderId;
	}


	public String getBankCode() {
		return bankCode;
	}


	public void setBankCode( String bankCode ) {
		this.bankCode = bankCode;
	}
}
