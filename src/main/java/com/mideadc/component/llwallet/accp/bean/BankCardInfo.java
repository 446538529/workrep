package com.mideadc.component.llwallet.accp.bean;

/**
 * 付款银行卡信息
 */
public class BankCardInfo {
    //绑定银行账号
    private String linked_acctno;
    //绑卡协议号
    private String linked_agrtno;
    //银行预留手机号
    private String linked_phone;
    //银行账户名称
    private String linked_acctname;
    //证件类型
    private String id_type;
    //证件号码
    private String id_no;
    //信用卡 cvv2
    private String cvv2;
    //信用卡有效期
    private String valid_thru;

    public String getLinked_acctno() {
        return linked_acctno;
    }

    public void setLinked_acctno(String linked_acctno) {
        this.linked_acctno = linked_acctno;
    }

    public String getLinked_agrtno() {
        return linked_agrtno;
    }

    public void setLinked_agrtno(String linked_agrtno) {
        this.linked_agrtno = linked_agrtno;
    }

    public String getLinked_phone() {
        return linked_phone;
    }

    public void setLinked_phone(String linked_phone) {
        this.linked_phone = linked_phone;
    }

    public String getLinked_acctname() {
        return linked_acctname;
    }

    public void setLinked_acctname(String linked_acctname) {
        this.linked_acctname = linked_acctname;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getValid_thru() {
        return valid_thru;
    }

    public void setValid_thru(String valid_thru) {
        this.valid_thru = valid_thru;
    }
}
