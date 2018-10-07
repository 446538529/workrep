package com.mideadc.component.llwallet.wallet.bean;

/**
 * 企业钱包
 * 4.1 WEB 充值网关接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class WebrechargeGatewayReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 版本号
    private String version;
    // 用户所属平台编号
    private String platform;
    // 时间戳
    private String timestamp;
    // 用户端申请IP
    private String userreq_ip;
    // 用户名
    private String user_login;
    // 商户业务类型 (内部账户充值 : 110001)
    private String busi_partner = "110001";
    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 商品名称
    private String name_goods;
    // 交易金额
    private String money_order;
    // 订单描述
    private String info_order;
    // 服务器异步通 知地址
    private String notify_url;
    // 返回商户地址
    private String url_return;
    // 订单有效时间
    private String valid_order;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserreq_ip() {
        return userreq_ip;
    }

    public void setUserreq_ip(String userreq_ip) {
        this.userreq_ip = userreq_ip;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getBusi_partner() {
        return busi_partner;
    }

    public void setBusi_partner(String busi_partner) {
        this.busi_partner = busi_partner;
    }

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getDt_order() {
        return dt_order;
    }

    public void setDt_order(String dt_order) {
        this.dt_order = dt_order;
    }

    public String getName_goods() {
        return name_goods;
    }

    public void setName_goods(String name_goods) {
        this.name_goods = name_goods;
    }

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

    public String getInfo_order() {
        return info_order;
    }

    public void setInfo_order(String info_order) {
        this.info_order = info_order;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getUrl_return() {
        return url_return;
    }

    public void setUrl_return(String url_return) {
        this.url_return = url_return;
    }

    public String getValid_order() {
        return valid_order;
    }

    public void setValid_order(String valid_order) {
        this.valid_order = valid_order;
    }
}
