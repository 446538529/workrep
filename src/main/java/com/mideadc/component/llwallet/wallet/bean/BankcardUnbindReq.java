package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.3 银行卡解绑接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class BankcardUnbindReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 银通协议编号
    private String no_agree;
    // 支付方式(2：快捷支付（借记卡-默认） 3：快捷支付（信用卡） D: 认证支付)
    private String pay_type;
    // 原支付密码
    private String pwd_pay;
    // 用户类型 (0 钱包用户(默认) 8 匿名用户)
    private String type_user;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
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

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }
}
