package com.mideadc.component.llwallet.wallet.bean;

/**
 * 企业钱包
 * 7.2 企业用户对公账户修改接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class ModifyUnituserAcctReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 授权码
    private String token;
    // 开户行所在市编码
    private String city_code;
    // 开户支行名称
    private String brabank_name;
    // 银行账号
    private String card_no;
    // 所属银行编号
    private String bank_code;
    // 银行开户名称
    private String acct_name;
    // 大额行号
    private String prcptcd;
    // 风险控制参数
    private String risk_item;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getBrabank_name() {
        return brabank_name;
    }

    public void setBrabank_name(String brabank_name) {
        this.brabank_name = brabank_name;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getAcct_name() {
        return acct_name;
    }

    public void setAcct_name(String acct_name) {
        this.acct_name = acct_name;
    }

    public String getPrcptcd() {
        return prcptcd;
    }

    public void setPrcptcd(String prcptcd) {
        this.prcptcd = prcptcd;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }
}
