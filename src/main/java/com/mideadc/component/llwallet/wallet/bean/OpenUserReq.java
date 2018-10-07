package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 3.3 钱包开户接口（通过短信验证）
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class OpenUserReq extends BaseParamsReq {

	private static final long serialVersionUID = 1L;
	// 用户唯一编号
	private String user_id;
	// 法人姓名
	private String name_user;
	// 法人证件类型
	private String type_idcard = "0";
	// 法人证件号
	private String no_idcard;
    // 登陆密码
	private String pwd_login;
    // 支付密码
	private String pwd_pay;
    // 联系地址
	private String addr_conn;
	// YYYYMMDD 格式，需要大于当天 非永久必传
	private String exp_idcard;
	// 0：非永久 1：永久 默认非永久
	private String type_expidcard = "0";
    // 职业类别
	private String oid_job = "19";
    // 授权码
	private String token;
    // 省级地址
    private String addr_pro;
    // 市级地址
    private String addr_city;
    // 区级地址
    private String addr_dist;
    // 开户认证标示
	private String flag_auth = "0";
    // 风险控制参数
	private String risk_item;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getType_idcard() {
		return type_idcard;
	}

	public void setType_idcard(String type_idcard) {
		this.type_idcard = type_idcard;
	}

	public String getNo_idcard() {
		return no_idcard;
	}

	public void setNo_idcard(String no_idcard) {
		this.no_idcard = no_idcard;
	}

	public String getPwd_login() {
		return pwd_login;
	}

	public void setPwd_login(String pwd_login) {
		this.pwd_login = pwd_login;
	}

	public String getPwd_pay() {
		return pwd_pay;
	}

	public void setPwd_pay(String pwd_pay) {
		this.pwd_pay = pwd_pay;
	}

	public String getAddr_conn() {
		return addr_conn;
	}

	public void setAddr_conn(String addr_conn) {
		this.addr_conn = addr_conn;
	}

	public String getExp_idcard() {
		return exp_idcard;
	}

	public void setExp_idcard(String exp_idcard) {
		this.exp_idcard = exp_idcard;
	}

	public String getType_expidcard() {
		return type_expidcard;
	}

	public void setType_expidcard(String type_expidcard) {
		this.type_expidcard = type_expidcard;
	}

	public String getOid_job() {
		return oid_job;
	}

	public void setOid_job(String oid_job) {
		this.oid_job = oid_job;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAddr_pro() {
		return addr_pro;
	}

	public void setAddr_pro(String addr_pro) {
		this.addr_pro = addr_pro;
	}

	public String getAddr_city() {
		return addr_city;
	}

	public void setAddr_city(String addr_city) {
		this.addr_city = addr_city;
	}

	public String getAddr_dist() {
		return addr_dist;
	}

	public void setAddr_dist(String addr_dist) {
		this.addr_dist = addr_dist;
	}

	public String getFlag_auth() {
		return flag_auth;
	}

	public void setFlag_auth(String flag_auth) {
		this.flag_auth = flag_auth;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

}
