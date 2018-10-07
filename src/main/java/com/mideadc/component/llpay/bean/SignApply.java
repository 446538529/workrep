package com.mideadc.component.llpay.bean;

public class SignApply extends BaseParams {
	private static final long serialVersionUID = 1L;
	// 请求应用标识 1-Android 2-ios 3-WAP
	private String app_request;
	// 证件类型 0:身份证
	private String id_type;
	// 证件号码
	private String id_no;
	// 姓名
	private String acct_name;
	// 银行卡号
	private String card_no;
	// 签约方式 分期付签约传 I
	private String pay_type;
	// 风险控制参数
	private String risk_item;
	// 签约结束回调 通知地址
	private String url_return;
	// 还款计划
	private String repayment_plan;
	// 还款计划编号
	private String repayment_no;
	// 短信参数，商户名称 与 商户联系方式
	// 例 如 : {"contract_type":" 融 资 租 赁 ","contact_way":"0571-12345678"}
	private String sms_param;

	public String getApp_request() {
		return app_request;
	}

	public void setApp_request(String app_request) {
		this.app_request = app_request;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

	public String getUrl_return() {
		return url_return;
	}

	public void setUrl_return(String url_return) {
		this.url_return = url_return;
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
}
