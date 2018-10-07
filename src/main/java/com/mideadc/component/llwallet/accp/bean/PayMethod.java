package com.mideadc.component.llwallet.accp.bean;

/**
 * 付款方式
 */
public class PayMethod {
    //付款方式
    private String method;
    //付款金额(所有付款方式的金额之和等于订单总金额)
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
