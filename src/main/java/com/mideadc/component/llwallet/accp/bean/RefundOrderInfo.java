package com.mideadc.component.llwallet.accp.bean;

/**
 * 退款订单信息封装
 */
public class RefundOrderInfo {
    //退款订单号标识一次退款请求，商户系统需保证唯一
    private String refund_seqno;
    //退款订单时间(退款交易商户系统交易时间,yyyyMMddHHmmss)
    private String refund_time;
    //原收款方 id,确认前退款收款方指定为担保平台商户号,已确认交易的退款指定担保交易真实收款方id
    private String payee_id;
    //原收款方类型(USER/MERCHANT)
    private String payee_type;
    //原收款方账户类型
    private String payee_accttype;
    //退款总金额
    private String refund_amount;

    public String getRefund_seqno() {
        return refund_seqno;
    }

    public void setRefund_seqno(String refund_seqno) {
        this.refund_seqno = refund_seqno;
    }

    public String getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
    }

    public String getPayee_type() {
        return payee_type;
    }

    public void setPayee_type(String payee_type) {
        this.payee_type = payee_type;
    }

    public String getPayee_accttype() {
        return payee_accttype;
    }

    public void setPayee_accttype(String payee_accttype) {
        this.payee_accttype = payee_accttype;
    }

    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }
}
