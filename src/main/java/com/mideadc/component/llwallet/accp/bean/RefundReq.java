package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 退款请求参数
 */
public class RefundReq extends BaseParamsReq {
    //交易服务器时间戳
    private Date timestamp;
    //商户用户唯一编号
    private String user_id;
    //异步通知地址
    private String notify_url;
    //退款原因
    private String refund_reason;
    //原商户订单信息
    private OriginalOrderInfo originalOrderInfo;
    //退款订单信息
    private RefundOrderInfo refundOrderInfo;
    //原付款方式退款规则信息（多个）,付款时用了什么方式，退款则对应
    private RefundMethod[] refundMethods;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public OriginalOrderInfo getOriginalOrderInfo() {
        return originalOrderInfo;
    }

    public void setOriginalOrderInfo(OriginalOrderInfo originalOrderInfo) {
        this.originalOrderInfo = originalOrderInfo;
    }

    public RefundOrderInfo getRefundOrderInfo() {
        return refundOrderInfo;
    }

    public void setRefundOrderInfo(RefundOrderInfo refundOrderInfo) {
        this.refundOrderInfo = refundOrderInfo;
    }

    public RefundMethod[] getRefundMethods() {
        return refundMethods;
    }

    public void setRefundMethods(RefundMethod[] refundMethods) {
        this.refundMethods = refundMethods;
    }
}
