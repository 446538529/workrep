package com.mideadc.component.llpay.bean;

public class SignApplyResult {
	/**
	 * 用户储值卡Id
	 */
	private String userDepositCardId;
	/**
	 * 签约协议号
	 */
	private String agreeNo;

	public SignApplyResult(String userDepositCardId, String agreeNo) {
		this.userDepositCardId = userDepositCardId;
		this.agreeNo = agreeNo;
	}

	public SignApplyResult() {
	}

	public String getUserDepositCardId() {
		return userDepositCardId;
	}

	public void setUserDepositCardId(String userDepositCardId) {
		this.userDepositCardId = userDepositCardId;
	}

	public String getAgreeNo() {
		return agreeNo;
	}

	public void setAgreeNo(String agreeNo) {
		this.agreeNo = agreeNo;
	}

}
