package com.mideadc.component.llpay.bean;

public class RiskItem {
	private String frms_ware_category = "2013";
	private String user_info_mercht_userno;// 平台的用户id
	private String user_info_dt_register;// 用户在你们平台的注册时间
	private String user_info_bind_phone;// 用户在你们平台绑定的手机号

	private String user_info_identify_state;// 是否实名认证
	private String user_info_identify_type;// 实名认证方式

	private String user_info_full_name;// 用户姓名
	private String user_info_id_no;// 用户身份证号

	public static RiskItem createRiskItem(String mobile, String registerDate) {
		RiskItem riskItem = new RiskItem();
		riskItem.setUser_info_dt_register(registerDate);
		riskItem.setUser_info_bind_phone(mobile);
		return riskItem;
	}

	public static RiskItem createRiskItem(String mobile, String registerDate, String category) {
		RiskItem riskItem = new RiskItem();
		riskItem.setUser_info_dt_register(registerDate);
		riskItem.setUser_info_bind_phone(mobile);
		riskItem.setFrms_ware_category(category);
		return riskItem;
	}

	public static RiskItem createRiskItem(String userId, String name, String idCardNo, String mobile, String registerDate) {
		RiskItem riskItem = new RiskItem();
		riskItem.setUser_info_id_no(userId);
		riskItem.setUser_info_dt_register(registerDate);
		riskItem.setUser_info_bind_phone(mobile);
		riskItem.setUser_info_identify_state("1");
		riskItem.setUser_info_identify_type("1");
		riskItem.setUser_info_full_name(name);
		riskItem.setUser_info_id_no(idCardNo);
		return riskItem;
	}

	public String getFrms_ware_category() {
		return frms_ware_category;
	}

	public void setFrms_ware_category(String frms_ware_category) {
		this.frms_ware_category = frms_ware_category;
	}

	public String getUser_info_mercht_userno() {
		return user_info_mercht_userno;
	}

	public void setUser_info_mercht_userno(String user_info_mercht_userno) {
		this.user_info_mercht_userno = user_info_mercht_userno;
	}

	public String getUser_info_dt_register() {
		return user_info_dt_register;
	}

	public void setUser_info_dt_register(String user_info_dt_register) {
		this.user_info_dt_register = user_info_dt_register;
	}

	public String getUser_info_bind_phone() {
		return user_info_bind_phone;
	}

	public void setUser_info_bind_phone(String user_info_bind_phone) {
		this.user_info_bind_phone = user_info_bind_phone;
	}

	public String getUser_info_identify_state() {
		return user_info_identify_state;
	}

	public void setUser_info_identify_state(String user_info_identify_state) {
		this.user_info_identify_state = user_info_identify_state;
	}

	public String getUser_info_identify_type() {
		return user_info_identify_type;
	}

	public void setUser_info_identify_type(String user_info_identify_type) {
		this.user_info_identify_type = user_info_identify_type;
	}

	public String getUser_info_full_name() {
		return user_info_full_name;
	}

	public void setUser_info_full_name(String user_info_full_name) {
		this.user_info_full_name = user_info_full_name;
	}

	public String getUser_info_id_no() {
		return user_info_id_no;
	}

	public void setUser_info_id_no(String user_info_id_no) {
		this.user_info_id_no = user_info_id_no;
	}

}
