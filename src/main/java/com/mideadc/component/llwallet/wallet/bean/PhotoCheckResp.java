package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 3.7 照片审核异步通知
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class PhotoCheckResp {
    // 用户所属商户号
    private String oid_partner;
    // 签名方式
    private String sign_type;
    // 签名
    private String sign;
    // 开户姓名
    private String name_user;
    // 开户完成时间
    private String dt_register;
    // 实名认证等级
    private String level_auth;
    // 商户用户唯一 编号
    private String user_id;
    // 证件类型
    private String type_idcard;
    // 商户用户唯一 编号
    private String no_idcard ;
    // 绑定手机号码
    private String mob_bind ;
    // 审核状态（1:实名认证通过 2:实名认证不通过 3:审核中 4:审核通过 5:审核不通过 6:证件过期 7:待完善）
    private String kyc_status ;

    public String getOid_partner() {
        return oid_partner;
    }

    public void setOid_partner(String oid_partner) {
        this.oid_partner = oid_partner;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getDt_register() {
        return dt_register;
    }

    public void setDt_register(String dt_register) {
        this.dt_register = dt_register;
    }

    public String getLevel_auth() {
        return level_auth;
    }

    public void setLevel_auth(String level_auth) {
        this.level_auth = level_auth;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getMob_bind() {
        return mob_bind;
    }

    public void setMob_bind(String mob_bind) {
        this.mob_bind = mob_bind;
    }

    public String getKyc_status() {
        return kyc_status;
    }

    public void setKyc_status(String kyc_status) {
        this.kyc_status = kyc_status;
    }
}
