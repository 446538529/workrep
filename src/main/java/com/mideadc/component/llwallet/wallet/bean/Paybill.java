package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.2 用户收支明细
 * 企业钱包
 * 6.2 用户收支明细查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class Paybill {
    // 业务类型 (110001账户充值 101001虚拟商品销售 107001商户付款 202000账号提现 301000转账 301001我要付款 301002我要收款)
    private String oid_biz;
    // 连连支付支付单号
    private String oid_paybill;
    // 账务日期
    private String date_acct;
    // 交易后余额
    private String amt_bal;
    // 资金存取标识
    private String flag_dc;
    // 收款金额
    private String amt_inoccur;
    // 付款金额
    private String amt_outoccur;
    // 交易时间
    private String dt_billtrans;
    // 备注
    private String memo;

    public String getOid_biz() {
        return oid_biz;
    }

    public void setOid_biz(String oid_biz) {
        this.oid_biz = oid_biz;
    }

    public String getOid_paybill() {
        return oid_paybill;
    }

    public void setOid_paybill(String oid_paybill) {
        this.oid_paybill = oid_paybill;
    }

    public String getDate_acct() {
        return date_acct;
    }

    public void setDate_acct(String date_acct) {
        this.date_acct = date_acct;
    }

    public String getAmt_bal() {
        return amt_bal;
    }

    public void setAmt_bal(String amt_bal) {
        this.amt_bal = amt_bal;
    }

    public String getFlag_dc() {
        return flag_dc;
    }

    public void setFlag_dc(String flag_dc) {
        this.flag_dc = flag_dc;
    }

    public String getAmt_inoccur() {
        return amt_inoccur;
    }

    public void setAmt_inoccur(String amt_inoccur) {
        this.amt_inoccur = amt_inoccur;
    }

    public String getAmt_outoccur() {
        return amt_outoccur;
    }

    public void setAmt_outoccur(String amt_outoccur) {
        this.amt_outoccur = amt_outoccur;
    }

    public String getDt_billtrans() {
        return dt_billtrans;
    }

    public void setDt_billtrans(String dt_billtrans) {
        this.dt_billtrans = dt_billtrans;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
