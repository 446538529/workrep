package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;

/**
 *余额支付响应结果封装
 */
public class BalancePayResp extends BaseParamsResp{
    //商户用户唯一编号
    private String user_id;
    //交易流水号
    private String txn_seqno;
    //订单总金额
    private Number total_amount;
    //ACCP系统交易单号
    private String accp_txno;
    //交易token(二次短信验证需要)
    private String token;
    //账务日期
    private String accounting_date;
    //支付完成时间
    private String finish_time;

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

    public String getAccounting_date() {
        return accounting_date;
    }

    public void setAccounting_date(String accounting_date) {
        this.accounting_date = accounting_date;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }
}
