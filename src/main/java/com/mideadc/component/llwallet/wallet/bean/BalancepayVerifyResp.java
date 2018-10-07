package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.4 余额支付短信验证
 * 企业钱包
 * 5.5 余额支付短信验证
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BalancepayVerifyResp extends BaseParamsResp {

    // 商户订单时间
    private String dt_order;
    // 商户唯一订单号
    private String no_order;
    // 连连钱包支付单号
    private String oid_paybill;
    // 交易金额
    private String money_order;
    // 用户姓名
    private String name_user;
    // 账户可用余额
    private String balance;
    // 账户冻结余额
    private String freeze_balance;

    public String getDt_order() {
        return dt_order;
    }

    public void setDt_order(String dt_order) {
        this.dt_order = dt_order;
    }

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getOid_paybill() {
        return oid_paybill;
    }

    public void setOid_paybill(String oid_paybill) {
        this.oid_paybill = oid_paybill;
    }

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

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
}
