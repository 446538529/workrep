package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.4 签约查询接口
 * 企业钱包
 * 6.5 个体工商户绑卡查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserbankcardReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 商户用户唯一编号
    private String user_id;
    // 支付方式
    private String pay_type;
    // 提现卡标识 （7.4接口使用）
    private String cashcard_flag;
    // 签约协议号
    private String no_agree;
    // 银行账号
    private String card_no;

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

    public String getCashcard_flag() {
        return cashcard_flag;
    }

    public void setCashcard_flag(String cashcard_flag) {
        this.cashcard_flag = cashcard_flag;
    }

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
}
