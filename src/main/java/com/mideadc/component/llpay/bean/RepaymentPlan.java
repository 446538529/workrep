package com.mideadc.component.llpay.bean;

import java.io.Serializable;

public class RepaymentPlan implements Serializable {

	private static final long serialVersionUID = 1L;
	private String date;
	private String amount;

	public RepaymentPlan(String date, String amount) {
		this.date = date;
		this.amount = amount;
	}

	public RepaymentPlan() {
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
