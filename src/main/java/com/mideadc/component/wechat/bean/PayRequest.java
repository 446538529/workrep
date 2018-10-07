package com.mideadc.component.wechat.bean;

import com.google.gson.annotations.SerializedName;
import com.mideadc.commons.domain.utils.JsonUtil;

public class PayRequest {
	private String appId;
	private String timeStamp;
	private String nonceStr;
	@SerializedName("package")
	private String package1;
	private String signType;
	private String paySign;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackage1() {
		return package1;
	}

	public void setPackage1(String package1) {
		this.package1 = package1;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	public static void main(String[] args) {
		PayRequest pr = new PayRequest();
		pr.setPackage1("a=b");
		String json = JsonUtil.toJson(pr);
		System.out.println(json);
	}
}
