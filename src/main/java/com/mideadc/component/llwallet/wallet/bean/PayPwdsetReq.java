package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.1 钱包支付密码找回
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class PayPwdsetReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 新支付密码
    private String pwd_pay_new;
    // 授权码
    private String token;
    // 风险控制参数
    private String risk_item;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPwd_pay_new() {
        return pwd_pay_new;
    }

    public void setPwd_pay_new(String pwd_pay_new) {
        this.pwd_pay_new = pwd_pay_new;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }
}
