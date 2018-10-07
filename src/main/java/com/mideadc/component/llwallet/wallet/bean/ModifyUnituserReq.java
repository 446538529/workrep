package com.mideadc.component.llwallet.wallet.bean;

/**
 * 企业钱包
 * 7.1 企业用户基本信息修改接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class ModifyUnituserReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 授权码
    private String token;
    // 用户唯一编号
    private String user_id;
    // 姓名
    private String user_name;
    // 证件类型
    private String type_idcard;
    // 法人证件号
    private String no_idcard;
    // 身份证有效期
    private String exp_idcard;
    // 身份证有效期类型 （0：非永久 1：永久 默认非永久 ）
    private String type_expidcard;
    // 营业执照类型 （0 普通营业执照 1 多证合一营业执照（存在独立的组织机构代 码证）(合证不合号) 2 多证合一营业执照（不存在独立的组织机构 代码证）(合证合号)）
    private String type_license;
    // 企业地址
    private String addr_unit;
    // 联系地址
    private String addr_conn;
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
    // 组织机构代码 （营业执照类型0，1 的时候需要传）
    private String org_code;
    // 营业执照号码
    private String num_license;
    // 营业执照有效期 （非永久类型需要传）
    private String exp_license;
    // 企业注册类型 （0:企业 1:个体工商户 2:事业单位 3:社会团体）
    private String type_register;
    // 营业执照有效期类型 （0非永久 1永久 默认非永久）
    private String type_explicense;
    // 组织机构代码有效期 （营业执照类型0，1 的时候需要传）
    private String exp_orgcode;
    // 风险控制参数
    private String risk_item;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public String getType_license() {
        return type_license;
    }

    public void setType_license(String type_license) {
        this.type_license = type_license;
    }

    public String getAddr_unit() {
        return addr_unit;
    }

    public void setAddr_unit(String addr_unit) {
        this.addr_unit = addr_unit;
    }

    public String getAddr_conn() {
        return addr_conn;
    }

    public void setAddr_conn(String addr_conn) {
        this.addr_conn = addr_conn;
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

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getNum_license() {
        return num_license;
    }

    public void setNum_license(String num_license) {
        this.num_license = num_license;
    }

    public String getExp_license() {
        return exp_license;
    }

    public void setExp_license(String exp_license) {
        this.exp_license = exp_license;
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

    public String getExp_orgcode() {
        return exp_orgcode;
    }

    public void setExp_orgcode(String exp_orgcode) {
        this.exp_orgcode = exp_orgcode;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }
}
