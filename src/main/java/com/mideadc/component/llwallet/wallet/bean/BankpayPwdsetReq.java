package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.5 绑定银行卡授权申请接口
 * 接口使用场景：可调用签约申请接口或密保校验接口授权完成后来调用重置密码功能，若绑定新卡，会自动解约原绑定的银行卡，若绑定原来的卡，则不受影响。
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class BankpayPwdsetReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 银行卡号
    private String card_no;
    // 绑定手机号码
    private String bind_mob;
    // 姓名
    private String acct_name;
    // 证件类型
    private String id_type;
    // 证件号
    private String id_no;
    // 信用卡有效期
    private String vali_date;
    // 信用卡CVV2
    private String cvv2;
    // 支付方式(2：快捷支付（借记卡-默认） 3：快捷支付（信用卡） D: 认证支付)
    private String pay_type;
    // 重置支付密码
    private String pwd_pay;
    // 风险控制参数
    private String risk_item;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getPwd_pay() {
        return pwd_pay;
    }

    public void setPwd_pay(String pwd_pay) {
        this.pwd_pay = pwd_pay;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }
}
