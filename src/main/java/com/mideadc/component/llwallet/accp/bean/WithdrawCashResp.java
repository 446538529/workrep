package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;

import java.util.Date;

/**
 * 提现申请响应参数封装
 */
public class WithdrawCashResp extends BaseParamsResp {
    //商户用户唯一编号
    private String user_id;
    //交易流水号
    private String txn_seqno;
    //订单总金额
    private Number total_amount;
    //ACCP 系统交易单号
    private String accp_txno;
    //交易 token(用于二次短信验证)
    private String token;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getAccp_txno() {
        return accp_txno;
    }

    public void setAccp_txno(String accp_txno) {
        this.accp_txno = accp_txno;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
