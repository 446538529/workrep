package com.mideadc.component.llpay.bean;

/**
 * 银行卡解约 API 接口
 * 
 * @author spirng
 *
 */
public class BankCardUnbind extends BaseParams {
	private static final long serialVersionUID = 1L;
	private String no_agree;
	private String pay_type;

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getNo_agree() {
		return no_agree;
	}

	public void setNo_agree(String no_agree) {
		this.no_agree = no_agree;
	}
}
