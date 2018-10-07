package com.mideadc.component.wechat.config;

public class WeChatConfig {
	public String APPID;
	public String MCH_ID;
	public String NOTIFY_URL;
	public String SECRET;
	public String CERTIFICATE_PATH;
	public String CERTIFICATE_PASSWORD;
	public String KEY;
	public String AttentionQRcode;
	public String WeChatName;
	public String PAYAPPID;

	public String getPAYAPPID() {
		return PAYAPPID;
	}

	public void setPAYAPPID(String PAYAPPID) {
		this.PAYAPPID = PAYAPPID;
	}

	public String getAPPID() {
		return APPID;
	}

	public void setAPPID(String aPPID) {
		APPID = aPPID;
	}

	public String getMCH_ID() {
		return MCH_ID;
	}

	public void setMCH_ID(String mCH_ID) {
		MCH_ID = mCH_ID;
	}

	public String getNOTIFY_URL() {
		return NOTIFY_URL;
	}

	public void setNOTIFY_URL(String nOTIFY_URL) {
		NOTIFY_URL = nOTIFY_URL;
	}

	public String getSECRET() {
		return SECRET;
	}

	public void setSECRET(String sECRET) {
		SECRET = sECRET;
	}

	public String getCERTIFICATE_PATH() {
		return CERTIFICATE_PATH;
	}

	public void setCERTIFICATE_PATH(String cERTIFICATE_PATH) {
		CERTIFICATE_PATH = cERTIFICATE_PATH;
	}

	public String getCERTIFICATE_PASSWORD() {
		return CERTIFICATE_PASSWORD;
	}

	public void setCERTIFICATE_PASSWORD(String cERTIFICATE_PASSWORD) {
		CERTIFICATE_PASSWORD = cERTIFICATE_PASSWORD;
	}

	public String getKEY() {
		return KEY;
	}

	public void setKEY(String kEY) {
		KEY = kEY;
	}

	public String getAttentionQRcode() {
		return AttentionQRcode;
	}

	public void setAttentionQRcode(String attentionQRcode) {
		AttentionQRcode = attentionQRcode;
	}

	public String getWeChatName() {
		return WeChatName;
	}

	public void setWeChatName(String weChatName) {
		WeChatName = weChatName;
	}
}
