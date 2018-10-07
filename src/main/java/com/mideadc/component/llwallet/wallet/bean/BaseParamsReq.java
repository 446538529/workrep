package com.mideadc.component.llwallet.wallet.bean;

import java.io.Serializable;

public class BaseParamsReq implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户所属商户号
	private String oid_partner;
	// 签名方式 RSA 或者 MD5
	private String sign_type;
	// 签名
	private String sign;

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
