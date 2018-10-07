package com.mideadc.component.wechat.config;

// 调用第三方支付配置信息
public class WeChantPayCfg {

    public String mid; // 商户号

    public String inst_mid; // 机构商户号

    public String tid; //终端号

    public String orderNo;  // 订单号

    private String payChannel;//支付渠道(1:银联 2：双乾 3：汪汪惠分享)

    public String key; // MD5密钥

    public String msgSrcId; //消息来源

    public String mrate; // 商户费率

    public String amount; // 支付金额

    public String openId; // 付款人openId

    public String payOpenId; // 付款人在汪汪惠分享下的openId

    public String pay_request_url; // 调用支付接口API地址

    public String notify_url; // 支付结果回调通知地址

    public static String page_return_url = "http://www.52wxr.com"; // 网页跳转地址

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getInst_mid() {
        return inst_mid;
    }

    public void setInst_mid(String inst_mid) {
        this.inst_mid = inst_mid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMsgSrcId() {
        return msgSrcId;
    }

    public void setMsgSrcId(String msgSrcId) {
        this.msgSrcId = msgSrcId;
    }

    public String getMrate() {
        return mrate;
    }

    public void setMrate(String mrate) {
        this.mrate = mrate;
    }

    public String getPay_request_url() {
        return pay_request_url;
    }

    public void setPay_request_url(String pay_request_url) {
        this.pay_request_url = pay_request_url;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public static String getPage_return_url() {
        return page_return_url;
    }

    public static void setPage_return_url(String page_return_url) {
        WeChantPayCfg.page_return_url = page_return_url;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPayOpenId() {
        return payOpenId;
    }

    public void setPayOpenId(String payOpenId) {
        this.payOpenId = payOpenId;
    }
}
