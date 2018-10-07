package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.7 担保交易确认交易接口
 * 企业钱包
 * 5.10 担保交易确认交易接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class SecuredpayConfirmReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    //担保商户号
    private String secured_partner;
    // 版本号
    private String api_version;
    // 商户确认订单号
    private String no_confirm;
    // 商户确认时间
    private String dt_confirm;
    // 确认交易金额
    private String money_order;
    // 部分确认收款方标识
    private String col_custid;
    // 部分确认收款 方类型
    private String col_custtype;
    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 连连钱包支付单号
    private String oid_paybill;

    public String getSecured_partner() {
        return secured_partner;
    }

    public void setSecured_partner(String secured_partner) {
        this.secured_partner = secured_partner;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getNo_confirm() {
        return no_confirm;
    }

    public void setNo_confirm(String no_confirm) {
        this.no_confirm = no_confirm;
    }

    public String getDt_confirm() {
        return dt_confirm;
    }

    public void setDt_confirm(String dt_confirm) {
        this.dt_confirm = dt_confirm;
    }

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

    public String getCol_custid() {
        return col_custid;
    }

    public void setCol_custid(String col_custid) {
        this.col_custid = col_custid;
    }

    public String getCol_custtype() {
        return col_custtype;
    }

    public void setCol_custtype(String col_custtype) {
        this.col_custtype = col_custtype;
    }

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getDt_order() {
        return dt_order;
    }

    public void setDt_order(String dt_order) {
        this.dt_order = dt_order;
    }

    public String getOid_paybill() {
        return oid_paybill;
    }

    public void setOid_paybill(String oid_paybill) {
        this.oid_paybill = oid_paybill;
    }
}
