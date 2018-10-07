package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包、企业钱包
 * 5.1 用户银行卡、企业用户、 个体工商户提现申请
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class CashoutcombineApplyResp extends BaseParamsResp {
    // 用户唯一编号
    private String user_id;
    // 冻结余额
    private String freeze_balance;
    // 可用余额
    private String balance;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFreeze_balance() {
        return freeze_balance;
    }

    public void setFreeze_balance(String freeze_balance) {
        this.freeze_balance = freeze_balance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
