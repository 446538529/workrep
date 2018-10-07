package com.mideadc.component.llpay.bean;

public class AgreenOauthApply extends BaseParams {
	private static final long serialVersionUID = 1L;
	// 平台来源
	private String platform;
	// 版本号
	private String api_version;
	// 还款计划
	private String repayment_plan;
	// 还款计划编号
	private String repayment_no;
	// 短信参数
	private String sms_param;
	// 支付方式
	private String pay_type;
	// 签约协议号
	private String no_agree;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getRepayment_plan() {
		return repayment_plan;
	}

	public void setRepayment_plan(String repayment_plan) {
		this.repayment_plan = repayment_plan;
	}

	public String getRepayment_no() {
		return repayment_no;
	}

	public void setRepayment_no(String repayment_no) {
		this.repayment_no = repayment_no;
	}

	public String getSms_param() {
		return sms_param;
	}

	public void setSms_param(String sms_param) {
		this.sms_param = sms_param;
	}

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
