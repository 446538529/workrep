package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * 担保交易确认请求参数
 */
public class SecuredConfirmReq extends BaseParamsReq {
    //交易服务器时间戳
    private Date timestamp;
    //商户用户唯一编号
    private String user_id;
    //异步通知地址
    private String notify_url;
    //确认方式(ALL/PART)
    private String confirm_mode;
    //原商户订单信息
    private OriginalOrderInfo originalOrderInfo;
    //确认订单信息
    private ConfirmOrderInfo confirmOrderInfo;
    //确认收款方信息
    private PayeeInfo[] payeeInfo;

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

    public String getConfirm_mode() {
        return confirm_mode;
    }

    public void setConfirm_mode(String confirm_mode) {
        this.confirm_mode = confirm_mode;
    }

    public OriginalOrderInfo getOriginalOrderInfo() {
        return originalOrderInfo;
    }

    public void setOriginalOrderInfo(OriginalOrderInfo originalOrderInfo) {
        this.originalOrderInfo = originalOrderInfo;
    }

    public ConfirmOrderInfo getConfirmOrderInfo() {
        return confirmOrderInfo;
    }

    public void setConfirmOrderInfo(ConfirmOrderInfo confirmOrderInfo) {
        this.confirmOrderInfo = confirmOrderInfo;
    }

    public PayeeInfo[] getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(PayeeInfo[] payeeInfo) {
        this.payeeInfo = payeeInfo;
    }
}
