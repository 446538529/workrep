package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 充值、消费、提现、代发类交易需要二次进行付款方短信验证的请求
 */
public class TradeSecondSmsValidReq extends BaseParamsReq {
    //交易服务器时间戳
    private Date timestamp;
    //付款方类型
    private String payer_type;
    //付款方标识
    private String payer_id;
    //交易流水号
    private String txn_seqno;
    //订单总金额
    private Number total_amount;
    //交易 token
    private String token;
    //短信验证码
    private String verify_code;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPayer_type() {
        return payer_type;
    }

    public void setPayer_type(String payer_type) {
        this.payer_type = payer_type;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
