package com.mideadc.component.llwallet.wallet.bean;

import java.io.Serializable;

public class BaseParamsResp implements Serializable {
	private static final long serialVersionUID = 1L;
	// 交易结果代码
	private String ret_code;
	// 交易结果描述
	private String ret_msg;
	// 签名方式 RSA 或者 MD5
	private String sign_type;
	// 签名
	private String sign;
	// 用户所属商户号
	private String oid_partner;

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
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

	public String getOid_partner() {
		return oid_partner;
	}

	public void setOid_partner(String oid_partner) {
		this.oid_partner = oid_partner;
	}

	public boolean isSuccess() {
		return "0000".equals(ret_code);
	}

}
