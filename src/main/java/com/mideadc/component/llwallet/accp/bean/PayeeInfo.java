package com.mideadc.component.llwallet.accp.bean;

/**
 * 收款方信息
 */
public class PayeeInfo {
    //收款方id
    private String payee_id;
    //收款方类型
    private String payee_type;
    //收款账户类型
    private String payee_accttype;
    //收款金额
    private Number payee_amount;
    //收款备注
    private String payee_memo;

    //银行帐号,代发需要
    private String bank_acctno;
    //银行编码,代发需要
    private String bank_code;
    //户名，代发需要
    private String bank_acctname;
    //大额行号,代发需要，银行大额行号，收款方类型为对公银行账户必须
    private String cnaps_code;

    public String getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(String payee_id) {
        this.payee_id = payee_id;
    }

    public String getPayee_type() {
        return payee_type;
    }

    public void setPayee_type(String payee_type) {
        this.payee_type = payee_type;
    }

    public String getPayee_accttype() {
        return payee_accttype;
    }

    public void setPayee_accttype(String payee_accttype) {
        this.payee_accttype = payee_accttype;
    }

    public Number getPayee_amount() {
        return payee_amount;
    }

    public void setPayee_amount(Number payee_amount) {
        this.payee_amount = payee_amount;
    }

    public String getPayee_memo() {
        return payee_memo;
    }

    public void setPayee_memo(String payee_memo) {
        this.payee_memo = payee_memo;
    }

    public String getBank_acctno() {
        return bank_acctno;
    }

    public void setBank_acctno(String bank_acctno) {
        this.bank_acctno = bank_acctno;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_acctname() {
        return bank_acctname;
    }

    public void setBank_acctname(String bank_acctname) {
        this.bank_acctname = bank_acctname;
    }

    public String getCnaps_code() {
        return cnaps_code;
    }

    public void setCnaps_code(String cnaps_code) {
        this.cnaps_code = cnaps_code;
    }
}
