package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 银行卡快捷支付请求
 */
public class BankcardPayReq extends BaseParamsReq {
    //时间戳
    private Date timestamp;
    //商户交易流水号
    private String txn_seqno;
    //订单总金额
    private Double total_amount;
    //风控参数
    private String risk_item;
    //付款方信息
    private PayerInfo payerInfo;
    //付款银行信息
    private BankCardInfo bankCardInfo;
    //付款方式信息（可以多个,多个付款方式金额之和等于订单总金额）
    private PayMethod[] payMethods;

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

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
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

    public BankCardInfo getBankCardInfo() {
        return bankCardInfo;
    }

    public void setBankCardInfo(BankCardInfo bankCardInfo) {
        this.bankCardInfo = bankCardInfo;
    }

    public PayMethod[] getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(PayMethod[] payMethods) {
        this.payMethods = payMethods;
    }
}
