package com.mideadc.component.llpay.bean;

import java.io.Serializable;

public class BaseParams implements Serializable {
	private static final long serialVersionUID = 1L;
	// 版本号
	private String version;
	// 商户编号
	private String oid_partner;
	// 商户用户唯一编号
	private String user_id;
	// 签名方式 RSA 或者 MD5
	private String sign_type;
	// 签名
	private String sign;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
