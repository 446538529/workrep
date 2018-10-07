package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.1 钱包用户查询接口
 * 企业钱包
 * 6.1 钱包用户查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class SingleuserQueryResp extends BaseParamsResp {

    private String name_user;
    // 账户可用余额
    private String balance;
    // 账户冻结余额
    private String freeze_balance;
    // 可提现金额
    private String cashout_amt;
    // 用户注册时间
    private String dt_register;
    // 用户状态
    private String stat_user;
    // 用户唯一编号
    private String user_id;
    // 证件类型
    private String type_idcard;
    // 法人证件号
    private String no_idcard;
    // 绑定手机号码
    private String mob_bind;
    // 联系地址
    private String addr_conn;
    // 审核状态（1:实名认证通过 2:实名认证不通过 3:审核中 4:审核通过 5:审核不通过 6:证件过期 7:待完善）
    private String kyc_status ;
    // 失败原因
    private String fail_reason;
    // 身份证有效期
    private String exp_idcard;
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

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFreeze_balance() {
        return freeze_balance;
    }

    public void setFreeze_balance(String freeze_balance) {
        this.freeze_balance = freeze_balance;
    }

    public String getCashout_amt() {
        return cashout_amt;
    }

    public void setCashout_amt(String cashout_amt) {
        this.cashout_amt = cashout_amt;
    }

    public String getDt_register() {
        return dt_register;
    }

    public void setDt_register(String dt_register) {
        this.dt_register = dt_register;
    }

    public String getStat_user() {
        return stat_user;
    }

    public void setStat_user(String stat_user) {
        this.stat_user = stat_user;
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

    public String getAddr_conn() {
        return addr_conn;
    }

    public void setAddr_conn(String addr_conn) {
        this.addr_conn = addr_conn;
    }

    public String getKyc_status() {
        return kyc_status;
    }

    public void setKyc_status(String kyc_status) {
        this.kyc_status = kyc_status;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

    public String getExp_idcard() {
        return exp_idcard;
    }

    public void setExp_idcard(String exp_idcard) {
        this.exp_idcard = exp_idcard;
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

    public void setAddr_dist(String addr_dist) {
        this.addr_dist = addr_dist;
    }

    public String getBusi_user() {
        return busi_user;
    }

    public void setBusi_user(String busi_user) {
        this.busi_user = busi_user;
    }
}
