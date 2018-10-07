package com.mideadc.component.llwallet.accp.bean;

/**
 * 原商户订单信息(用在退款请求中)
 */
public class OriginalOrderInfo {
    //原担保支付交易商户系统唯一交易流水号
    private String txn_seqno;
    //订单总金额
    private Number total_amount;

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
}
