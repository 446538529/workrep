package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包、企业钱包
 * 3.5 银行卡、个体工商户绑卡认证接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class BankcardOpenauthReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 支付方式 （2：快捷支付（借记卡 默认） 3：快捷支付（信用卡） D: 认证支付 ）
    private String pay_type;
    // 版本号
    private String api_version;
    // 风险控制参数
    private String risk_item;
    // 银行卡号
    private String card_no;
    // 绑定手机号码
    private String bind_mob;
    // 信用卡有效期
    private String vali_date;
    // 信用卡CVV2
    private String cvv2;
    // 实名认证标示 （1：Ⅰ类账户认证（默认） 2：Ⅱ类账户认证 3：Ⅲ类账户认证）
    private String flag_auth;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
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

    public String getFlag_auth() {
        return flag_auth;
    }

    public void setFlag_auth(String flag_auth) {
        this.flag_auth = flag_auth;
    }
}
