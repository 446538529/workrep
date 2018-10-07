package com.mideadc.component.llwallet.wallet.bean;

/**
 * 7.5 用户认证查询接口
 *
 * Created by zhaoxz on 2018/2/6.
 */
public class UserauthQueryResp extends BaseParamsResp {

    // 商户用户唯一编号
    private String user_id;
    // 账户等级
    private String stat_auth;
    // 年可用额度
    private String amt_year;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStat_auth() {
        return stat_auth;
    }

    public void setStat_auth(String stat_auth) {
        this.stat_auth = stat_auth;
    }

    public String getAmt_year() {
        return amt_year;
    }

    public void setAmt_year(String amt_year) {
        this.amt_year = amt_year;
    }
}
