package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 提现申请请求参数封装
 */
public class WithdrawCashReq extends BaseParamsReq {
    //交易服务器时间戳
    private Date timestamp;
    //异步通知地址
    private String notify_url;
    //风控参数(为什么有的是risk_item?)
    private String risk;
    //绑定银行帐号
    private String linked_acctno;
    //绑卡协议号
    private String linked_agrtno;
    //垫资标识
    private String funds_flag;
    //商户订单信息
    private OrderInfo orderInfo;
    //付款方信息
    private PayerInfo payerInfo;

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

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getLinked_acctno() {
        return linked_acctno;
    }

    public void setLinked_acctno(String linked_acctno) {
        this.linked_acctno = linked_acctno;
    }

    public String getLinked_agrtno() {
        return linked_agrtno;
    }

    public void setLinked_agrtno(String linked_agrtno) {
        this.linked_agrtno = linked_agrtno;
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
}
