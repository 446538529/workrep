package com.mideadc.component.llwallet.accp.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;

import java.util.Date;

/**
 * ACCP支付统一创单请求
 */
public class TradeCreateReq extends BaseParamsReq {
    //交易服务器时间戳
    private Date timestamp;
    //交易类型
    private String txn_type;
    //商户用户唯一编号
    private String user_id;
    //用户类型
    private String user_type;
    //异步通知地址
    private String notify_url;
    //交易返回地址
    private String return_url;
    //支付有效期
    private Number pay_expire;
    //商户订单信息
    private OrderInfo orderInfo;
    //收款方信息（可以有多个收款方）
    private PayeeInfo[] payeeInfo;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxn_type() {
        return txn_type;
    }

    public void setTxn_type(String txn_type) {
        this.txn_type = txn_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public Number getPay_expire() {
        return pay_expire;
    }

    public void setPay_expire(Number pay_expire) {
        this.pay_expire = pay_expire;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public PayeeInfo[] getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(PayeeInfo[] payeeInfo) {
        this.payeeInfo = payeeInfo;
    }
}
