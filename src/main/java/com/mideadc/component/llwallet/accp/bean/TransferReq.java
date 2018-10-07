package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 代发申请请求参数封装
 */
public class TransferReq extends BaseParamsReq{
    //交易服务器时间戳
    private Date timestamp;
    //异步通知地址
    private String notify_url;
    //支付有效期(单位：分钟，默认3天)
    private Number pay_expire;
    //垫资标识,标识该笔代发交易是否支持平台商户垫资，适用于代发付款方为用户的业务场景，默认：N ,不支持，支持是Y
    private String funds_flag;
    //商户订单信息
    private OrderInfo orderInfo;
    //付款方信息
    private PayerInfo payerInfo;
    //收款方信息
    private PayeeInfo payeeInfo;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public Number getPay_expire() {
        return pay_expire;
    }

    public void setPay_expire(Number pay_expire) {
        this.pay_expire = pay_expire;
    }

    public String getFunds_flag() {
        return funds_flag;
    }

    public void setFunds_flag(String funds_flag) {
        this.funds_flag = funds_flag;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public PayeeInfo getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(PayeeInfo payeeInfo) {
        this.payeeInfo = payeeInfo;
    }
}
