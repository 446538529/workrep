package com.mideadc.component.llwallet.accp.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 商户订单信息
 */
public class OrderInfo {
    //商户交易流水号
    private String txn_seqno;
    //商户交易时间
    private Date txn_time;
    //订单总金额
    private Number total_amount;
    //订单信息
    private String order_info;
    //商品描述信息
    private String goods_name;
    //订单及商品展示地址
    private String goods_url;
    //代发交易用途(只在代发上有)
    private String txn_purpose;
    //交易附言,代发至银行账户单笔金额大于等于 5w 必须提供
    private String postscript;

    public String getTxn_seqno() {
        return txn_seqno;
    }

    public void setTxn_seqno(String txn_seqno) {
        this.txn_seqno = txn_seqno;
    }

    public Date getTxn_time() {
        return txn_time;
    }

    public void setTxn_time(Date txn_time) {
        this.txn_time = txn_time;
    }

    public Number getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Number total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_info() {
        return order_info;
    }

    public void setOrder_info(String order_info) {
        this.order_info = order_info;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public String getTxn_purpose() {
        return txn_purpose;
    }

    public void setTxn_purpose(String txn_purpose) {
        this.txn_purpose = txn_purpose;
    }

    public String getPostscript() {
        return postscript;
    }

    public void setPostscript(String postscript) {
        this.postscript = postscript;
    }
}
