package com.mideadc.component.llwallet.wallet.bean;

/**
 * 商户账户余额查询接口
 *
 * Created by zhaoxz on 2018/2/3.
 */
public class TraderAcctQueryResp extends BaseParamsResp {

    // 商户未结算金额
    private String amt_unsettle;
    // 商户可用余额
    private String amt_balance;

    public String getAmt_unsettle() {
        return amt_unsettle;
    }

    public void setAmt_unsettle(String amt_unsettle) {
        this.amt_unsettle = amt_unsettle;
    }

    public String getAmt_balance() {
        return amt_balance;
    }

    public void setAmt_balance(String amt_balance) {
        this.amt_balance = amt_balance;
    }
}
