package com.mideadc.component.llwallet.wallet.bean;

/**
 * 3.5 个体工商户绑卡认证接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class BankcardOpenauthResp extends BaseParamsResp {

    // 用户唯一编号
    private String user_id;
    // 所属银行编号
    private String bank_code;
    // 授权码
    private String token;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
