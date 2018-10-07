package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.4 余额支付短信验证
 * 企业钱包
 * 5.5 余额支付短信验证
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BalancepayVerifyReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 授权码
    private String token;
    // 商户唯一订单号
    private String no_order;
    // 用户唯一编号
    private String user_id;
    // 交易金额
    private String money_order;
    // 短信验证码
    private String verify_code;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
