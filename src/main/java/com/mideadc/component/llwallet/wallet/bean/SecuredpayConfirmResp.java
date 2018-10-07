package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.7 担保交易确认交易接口
 * 企业钱包
 * 5.10 担保交易确认交易接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class SecuredpayConfirmResp extends BaseParamsResp {

    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 确认交易金额
    private String money_order;

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

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }
}
