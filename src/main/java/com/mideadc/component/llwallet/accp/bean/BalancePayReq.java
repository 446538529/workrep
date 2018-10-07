package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 余额支付请求参数封装
 */
public class BalancePayReq extends BaseParamsReq{
    //交易服务器时间戳
    private Date timestamp;
    //商户交易流水号
    private String txn_seqno;
    //订单总金额
    private Number total_amount;
    //优惠金额(使用优惠券才有)
    private Number coupon_amount;
    //风控参数
    private String risk_item;
    //付款方信息
    private PayerInfo payerInfo;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxn_seqno() {
        return txn_seqno;
    }

    public void setTxn_seqno(String txn_seqno) {
        this.txn_seqno = txn_seqno;
    }

    public Number getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Number total_amount) {
        this.total_amount = total_amount;
    }

    public Number getCoupon_amount() {
        return coupon_amount;
    }

    public void setCoupon_amount(Number coupon_amount) {
        this.coupon_amount = coupon_amount;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }
}
