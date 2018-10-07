package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.2 钱包银行卡签约支付验证
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BankcardPayResp extends BaseParamsResp {

    // 商户订单时间
    private String dt_order;
    // 商户唯一订单号
    private String no_order;
    // 连连钱包支付单号
    private String oid_paybill;
    // 交易金额
    private String money_order;
    // 支付结果
    private String result_pay;
    // 清算日期
    private String settle_date;
    // 订单描述
    private String info_order;
    // 签约协议号
    private String no_agree;

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

    public String getResult_pay() {
        return result_pay;
    }

    public void setResult_pay(String result_pay) {
        this.result_pay = result_pay;
    }

    public String getSettle_date() {
        return settle_date;
    }

    public void setSettle_date(String settle_date) {
        this.settle_date = settle_date;
    }

    public String getInfo_order() {
        return info_order;
    }

    public void setInfo_order(String info_order) {
        this.info_order = info_order;
    }

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
    }
}
