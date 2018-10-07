package com.mideadc.component.wechat.bean;

public class TplMsgValue {
	private String value;
	private String color = "#173177";

	public TplMsgValue(String value, String color) {
		this.value = value;
		this.color = color;
	}

	public TplMsgValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
