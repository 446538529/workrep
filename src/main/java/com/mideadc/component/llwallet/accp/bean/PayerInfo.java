package com.mideadc.component.llwallet.accp.bean;

/**
 * 付款方信息
 */
public class PayerInfo {
    //商户用户唯一编号
    private String user_id;
    //支付密码
    private String password;
    //密码随机因子key
    private String random_key;
    //付款方类型(用户或者商户，USER/MERCHANT),代发需要
    private String payer_type;
    //付款方标识(用户id或者商户号),代发需要
    private String payer_id;
    //付款方账户类型,代发需要
    private String payer_accttype;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandom_key() {
        return random_key;
    }

    public void setRandom_key(String random_key) {
        this.random_key = random_key;
    }

    public String getPayer_type() {
        return payer_type;
    }

    public void setPayer_type(String payer_type) {
        this.payer_type = payer_type;
    }

    public String getPayer_id() {
        return payer_id;
    }

    public void setPayer_id(String payer_id) {
        this.payer_id = payer_id;
    }

    public String getPayer_accttype() {
        return payer_accttype;
    }

    public void setPayer_accttype(String payer_accttype) {
        this.payer_accttype = payer_accttype;
    }
}

