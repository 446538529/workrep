package com.mideadc.component.llwallet.wallet.bean;

/**
 * 3.3 企业用户短信开户接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class OpenSmsUnitUserReq extends BaseParamsReq {

	private static final long serialVersionUID = 1L;
	// 用户唯一编号
	private String user_id;
	// 绑定手机号码
	private String mob_bind;
	// 授权码
	private String token;
	// 法人姓名
	private String name_user;
	// 法人证件号
	private String no_idcard;
	// 法人身份证有效期
	private String exp_idcard;
	// 法人身份证有效期类型
	private String type_expidcard;
	// 支付密码
	private String pwd_pay;
	// 企业地址
	private String addr_unit;
	// 省级地址
	private String addr_pro;
	// 市级地址
	private String addr_city;
	// 区级地址
	private String addr_dist;
	// 经营范围
	private String busi_user;
	// 企业名称
	private String name_unit;
	// 营业执照号码
	private String num_license;
	// 组织机构代码 （营业执照类型0，1 的时候需要传）
	private String org_code;
	// 企业注册类型 （0:企业 1:个体工商户 2:事业单位 3:社会团体）
	private String type_register;
	// 营业执照有效期类型
	private String type_explicense;
	// 营业执照有效期
	private String exp_license;
	// 营业执照类型 （0 普通营业执照 1 多证合一营业执照（存在独立的组织机构代 码证）(合证不合号) 2 多证合一营业执照（不存在独立的组织机构
	// 代码证）(合证合号)）
	private String type_license;
	// 组织机构代码有效期 （营业执照类型0，1 的时候需要传）
	private String exp_orgcode;
	// 开户行所在市编码 （需查看文档附件）
	private String city_code;
	// 开户支行名称
	private String brabank_name;
	// 银行账号 （个体工商户可不传，通过3.5，3.6接口绑定，其他类型必传）
	private String card_no;
	// 所属银行编号 （个体工商户可不传，通过3.5，3.6接口绑定，其他类型必传）
	private String bank_code;
	// 大额行号 （若传，则省市支行可不传，且大额行号已此为准。26家银行可不传）
	// private String prcptcd;
	// 开户银行名称 （若不传默认为企业名称name_unit）
	private String acct_name;
	// 风险控制参数
	private String risk_item;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getMob_bind() {
		return mob_bind;
	}

	public void setMob_bind(String mob_bind) {
		this.mob_bind = mob_bind;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getNo_idcard() {
		return no_idcard;
	}

	public void setNo_idcard(String no_idcard) {
		this.no_idcard = no_idcard;
	}

	public String getPwd_pay() {
		return pwd_pay;
	}

	public void setPwd_pay(String pwd_pay) {
		this.pwd_pay = pwd_pay;
	}

	public String getAddr_unit() {
		return addr_unit;
	}

	public void setAddr_unit(String addr_unit) {
		this.addr_unit = addr_unit;
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

    public void setAddr_dist(String addr_dist) {
		this.addr_dist = addr_dist;
	}

	public String getBusi_user() {
		return busi_user;
	}

	public void setBusi_user(String busi_user) {
		this.busi_user = busi_user;
	}

	public String getName_unit() {
		return name_unit;
	}

	public void setName_unit(String name_unit) {
		this.name_unit = name_unit;
	}

	public String getNum_license() {
		return num_license;
	}

	public void setNum_license(String num_license) {
		this.num_license = num_license;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getType_register() {
		return type_register;
	}

	public void setType_register(String type_register) {
		this.type_register = type_register;
	}

	public String getType_explicense() {
		return type_explicense;
	}

	public void setType_explicense(String type_explicense) {
		this.type_explicense = type_explicense;
	}

	public String getExp_license() {
		return exp_license;
	}

	public void setExp_license(String exp_license) {
		this.exp_license = exp_license;
	}

	public String getType_license() {
		return type_license;
	}

	public void setType_license(String type_license) {
		this.type_license = type_license;
	}

	public String getExp_orgcode() {
		return exp_orgcode;
	}

	public void setExp_orgcode(String exp_orgcode) {
		this.exp_orgcode = exp_orgcode;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getBrabank_name() {
		return brabank_name;
	}

	public void setBrabank_name(String brabank_name) {
		this.brabank_name = brabank_name;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

}
