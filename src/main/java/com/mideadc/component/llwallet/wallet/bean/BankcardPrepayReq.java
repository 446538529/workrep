package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.1 钱包签约支付预处理接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BankcardPrepayReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;

    //用户唯一编号
    private String user_id;

    //订单信息
    // 付款金额
    private String busi_partner;
    // 版本号
    private String api_version;
    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 商品名称
    private String name_goods;
    // 订单描述
    private String info_order;
    // 交易金额
    private String money_order;
    // 服务器异步通 知地址
    private String notify_url;
    // 订单有效时间
    private String valid_order;
    // 风险控制参数
    private String risk_item;

    // 支付参数
    // 支付方式
    private String pay_type;
    // 银行卡号
    private String card_no;
    // 银行账号姓名
    private String acct_name;
    // 证件类型
    private String id_type;
    // 证件号码
    private String id_no;
    // 银行编号
    private String bank_code;
    // 绑定手机号
    private String bind_mob;
    // 信用卡有效期
    private String vali_date;
    // 信用卡CVV2
    private String cvv2;
    // 签约协议号
    private String no_agree;
    // 支付密码
    private String pwd_pay;
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

    public String getBusi_partner() {
        return busi_partner;
    }

    public void setBusi_partner(String busi_partner) {
        this.busi_partner = busi_partner;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
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

    public String getInfo_order() {
        return info_order;
    }

    public void setInfo_order(String info_order) {
        this.info_order = info_order;
    }

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getValid_order() {
        return valid_order;
    }

    public void setValid_order(String valid_order) {
        this.valid_order = valid_order;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBind_mob() {
        return bind_mob;
    }

    public void setBind_mob(String bind_mob) {
        this.bind_mob = bind_mob;
    }

    public String getVali_date() {
        return vali_date;
    }

    public void setVali_date(String vali_date) {
        this.vali_date = vali_date;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
    }

    public String getPwd_pay() {
        return pwd_pay;
    }

    public void setPwd_pay(String pwd_pay) {
        this.pwd_pay = pwd_pay;
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
