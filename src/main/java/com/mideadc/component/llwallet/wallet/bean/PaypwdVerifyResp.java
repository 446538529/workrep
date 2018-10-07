package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.6 绑定银行卡授权验证接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class PaypwdVerifyResp extends BaseParamsResp {

    // 用户唯一编号
    private String user_id;
    // 授权码
    private String token;
    // 签约协议号
    private String no_agree;
    // 所属银行编号
    private String bank_code;
    // 银行卡号
    private String card_no;

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

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }
}
