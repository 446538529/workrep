package com.mideadc.component.llpay.bean;

public class UserParams {
	/**
	 * 储值卡Id
	 */
	private String userDepositCardId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idCardNo;
	/**
	 * 电话
	 */
	private String phone;

	public UserParams(String userDepositCardId, String name, String idCardNo, String phone) {
		this.userDepositCardId = userDepositCardId;
		this.name = name;
		this.idCardNo = idCardNo;
		this.phone = phone;
	}

	public UserParams() {
	}

	public String getUserDepositCardId() {
		return userDepositCardId;
	}

	public void setUserDepositCardId(String userDepositCardId) {
		this.userDepositCardId = userDepositCardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
