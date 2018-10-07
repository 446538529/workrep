package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.3 余额支付接口
 * 企业钱包
 * 5.4 企业钱包余额消费接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BalancePwdpayReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    //用户唯一编号
    private String user_id;
    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 订单有效时间
    private String valid_order;
    // 商户业务类型 (301001 我要付款 301002 我要收款 101001 虚拟商品销售 109001 实物商品销售 )
    private String busi_partner;
    // 商品名称
    private String name_goods;
    // 交易金额
    private String money_order;
    // 订单描述
    private String info_order;
    // 支付密码
    private String pwd_pay;
    // 服务器异步通知地址
    private String notify_url;
    // 风险控制参数
    private String risk_item;
    // 收款方商户号
    private String col_oidpartner;
    // 收款方用户唯一编号
    private String col_userid;
    // 分帐信息数据
    private String shareing_data;

    // 担保交易信息
    //担保商户号
    private String secured_partner;
    // 买方确认收货有效期
    private String buyer_confirm_valid;
    // 卖方发货有效期
    private String seller_send_valid;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getValid_order() {
        return valid_order;
    }

    public void setValid_order(String valid_order) {
        this.valid_order = valid_order;
    }

    public String getBusi_partner() {
        return busi_partner;
    }

    public void setBusi_partner(String busi_partner) {
        this.busi_partner = busi_partner;
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

    public String getPwd_pay() {
        return pwd_pay;
    }

    public void setPwd_pay(String pwd_pay) {
        this.pwd_pay = pwd_pay;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }

    public String getCol_oidpartner() {
        return col_oidpartner;
    }

    public void setCol_oidpartner(String col_oidpartner) {
        this.col_oidpartner = col_oidpartner;
    }

    public String getCol_userid() {
        return col_userid;
    }

    public void setCol_userid(String col_userid) {
        this.col_userid = col_userid;
    }

    public String getShareing_data() {
        return shareing_data;
    }

    public void setShareing_data(String shareing_data) {
        this.shareing_data = shareing_data;
    }

    public String getSecured_partner() {
        return secured_partner;
    }

    public void setSecured_partner(String secured_partner) {
        this.secured_partner = secured_partner;
    }

    public String getBuyer_confirm_valid() {
        return buyer_confirm_valid;
    }

    public void setBuyer_confirm_valid(String buyer_confirm_valid) {
        this.buyer_confirm_valid = buyer_confirm_valid;
    }

    public String getSeller_send_valid() {
        return seller_send_valid;
    }

    public void setSeller_send_valid(String seller_send_valid) {
        this.seller_send_valid = seller_send_valid;
    }
}
