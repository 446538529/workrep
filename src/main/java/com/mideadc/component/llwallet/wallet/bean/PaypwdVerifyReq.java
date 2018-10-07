package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.6 绑定银行卡授权验证接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class PaypwdVerifyReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 授权码
    private String token;
    // 短信验证码
    private String verify_code;

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

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
