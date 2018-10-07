package com.mideadc.component.llwallet.accp.bean;

/**
 * 确认订单信息(用在担保交易确认)
 */
public class ConfirmOrderInfo {
    //确认订单号
    private String confirm_seqno;
    //确认时间(yyyyMMddHHmmss)
    private String confirm_time;
    //确认金额
    private Number confirm_amount;

    public String getConfirm_seqno() {
        return confirm_seqno;
    }

    public void setConfirm_seqno(String confirm_seqno) {
        this.confirm_seqno = confirm_seqno;
    }

    public String getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(String confirm_time) {
        this.confirm_time = confirm_time;
    }

    public Number getConfirm_amount() {
        return confirm_amount;
    }

    public void setConfirm_amount(Number confirm_amount) {
        this.confirm_amount = confirm_amount;
    }
}
