package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.10 用户职业住址修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyBaseUserinfoReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 联系地址
    private String addr_conn;
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
    // 身份证有效期
    private String exp_idcard;
    // 身份证有效期类型 （0：非永久 1：永久 默认非永久 ）
    private String type_expidcard;
    // 是否同意连连开户协议
    private String consent_agreement;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAddr_conn() {
        return addr_conn;
    }

    public void setAddr_conn(String addr_conn) {
        this.addr_conn = addr_conn;
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

    public String getConsent_agreement() {
        return consent_agreement;
    }

    public void setConsent_agreement(String consent_agreement) {
        this.consent_agreement = consent_agreement;
    }
}
