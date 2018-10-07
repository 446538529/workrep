package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;

/**
 * ACCP支付统一创单响应
 */
public class TradeCreateResp extends BaseParamsResp{
    //商户用户唯一编号
    private String user_id;
    //订单总金额
    private Double total_amount;
    //交易流水号
    private String txn_seqno;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public String getTxn_seqno() {
        return txn_seqno;
    }

    public void setTxn_seqno(String txn_seqno) {
        this.txn_seqno = txn_seqno;
    }
}
