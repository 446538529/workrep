package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.4 签约查询接口返回结果集
 * 企业钱包
 * 6.5 个体工商户绑卡查询接口返回结果集
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserbankcardAgreement {
    // 签约协议号
    private String no_agree;
    // 银行卡号后4位
    private String card_no;
    // 所属银行编号
    private String bank_code;
    // 所属银行名称
    private String bank_name;
    // 银行卡类型 （2-储蓄卡  3-信用卡）
    private String card_type ;
    // 绑定手机号码
    private String bind_mobile;
    // 提现卡标识
    private String cash_type;

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
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

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getBind_mobile() {
        return bind_mobile;
    }

    public void setBind_mobile(String bind_mobile) {
        this.bind_mobile = bind_mobile;
    }

    public String getCash_type() {
        return cash_type;
    }

    public void setCash_type(String cash_type) {
        this.cash_type = cash_type;
    }
}
