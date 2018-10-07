package com.mideadc.component.llwallet.accp.bean;

/**
 * 原付款方式退款规则信息,付款时组合付款，退款则对应付款方式退对应的金额
 */
public class RefundMethod {
    //付款方式
    private String method;
    //退款金额
    private Number amount;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }
}
