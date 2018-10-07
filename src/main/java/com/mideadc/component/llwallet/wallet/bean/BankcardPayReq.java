package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 4.2 钱包银行卡签约支付验证
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class BankcardPayReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 授权码
    private String token;
    // 商户唯一订单号
    private String no_order;
    // 交易金额
    private String money_order;
    // 收款方商户号
    private String col_oidpartner;
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

    public String getMoney_order() {
        return money_order;
    }

    public void setMoney_order(String money_order) {
        this.money_order = money_order;
    }

    public String getCol_oidpartner() {
        return col_oidpartner;
    }

    public void setCol_oidpartner(String col_oidpartner) {
        this.col_oidpartner = col_oidpartner;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }
}
