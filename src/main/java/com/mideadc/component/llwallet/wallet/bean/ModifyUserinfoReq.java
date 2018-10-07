package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.8 用户基本信息修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyUserinfoReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 授权码
    private String token;
    // 姓名 (用户状态为V1V2 下不可修改 )
    private String user_name;
    // 证件类型 (用户状态为V1V2 下不可修改 )
    private String type_idcard;
    // 联系地址
    private String addr_conn;
    // 身份证有效期类型 （0：非永久 1：永久 默认非永久 ）
    private String type_expidcard;
    // 身份证有效期
    private String exp_idcard;
    // 性别
    private String flg_sex;
    // 职业类别
    private String oid_job;
    // 风险控制参数
    private String risk_item;
    // 省级地址
    private String addr_pro;
    // 市级地址
    private String addr_city;
    // 区级地址
    private String addr_dist;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getAddr_conn() {
        return addr_conn;
    }

    public void setAddr_conn(String addr_conn) {
        this.addr_conn = addr_conn;
    }

    public String getType_expidcard() {
        return type_expidcard;
    }

    public void setType_expidcard(String type_expidcard) {
        this.type_expidcard = type_expidcard;
    }

    public String getExp_idcard() {
        return exp_idcard;
    }

    public void setExp_idcard(String exp_idcard) {
        this.exp_idcard = exp_idcard;
    }

    public String getFlg_sex() {
        return flg_sex;
    }

    public void setFlg_sex(String flg_sex) {
        this.flg_sex = flg_sex;
    }

    public String getOid_job() {
        return oid_job;
    }

    public void setOid_job(String oid_job) {
        this.oid_job = oid_job;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
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
}
