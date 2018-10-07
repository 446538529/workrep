package com.mideadc.component.llwallet.wallet.bean;

/**
 * 企业钱包
 * 3.6 个体工商户银行卡绑卡验证接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class BankcardAuthverfyResp extends BaseParamsResp {

    // 用户唯一编号
    private String user_id;
    // 银行卡号
    private String card_no;
    // 所属银行编号 （个体工商户可不传，通过3.5，3.6接口绑定，其他类型必传）
    private String bank_code;
    // 签约协议号
    private String no_agree;
    // 钱包状态（0 ：V0(待实名认证) 1：V1（完成信息认证） 2：V2（V1+证件认证））
    private String stat_user;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getNo_agree() {
        return no_agree;
    }

    public void setNo_agree(String no_agree) {
        this.no_agree = no_agree;
    }

    public String getStat_user() {
        return stat_user;
    }

    public void setStat_user(String stat_user) {
        this.stat_user = stat_user;
    }
}
