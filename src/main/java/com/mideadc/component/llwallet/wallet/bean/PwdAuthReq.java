package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.4 钱包支付密码验证授权接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class PwdAuthReq extends BaseParamsReq {
    private static final long serialVersionUID = 1L;

    // 用户唯一编号
    private String user_id;
    // 支付密码
    private String pwd_pay;
    // 证件号（个人）
    private String no_idcard;
    // 营业执照号码（企业）
    private String num_license;
    // 操作标识
    private String flag_check;
    // 绑定手机号码
    private String mob_bind;
    // 风险控制参数
    private String risk_item;
    // 提现卡标识
    private String flag_cashcard;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPwd_pay() {
        return pwd_pay;
    }

    public void setPwd_pay(String pwd_pay) {
        this.pwd_pay = pwd_pay;
    }

    public String getNo_idcard() {
        return no_idcard;
    }

    public void setNo_idcard(String no_idcard) {
        this.no_idcard = no_idcard;
    }

    public String getNum_license() {
        return num_license;
    }

    public void setNum_license(String num_license) {
        this.num_license = num_license;
    }

    public String getFlag_check() {
        return flag_check;
    }

    public void setFlag_check(String flag_check) {
        this.flag_check = flag_check;
    }

    public String getMob_bind() {
        return mob_bind;
    }

    public void setMob_bind(String mob_bind) {
        this.mob_bind = mob_bind;
    }

    public String getRisk_item() {
        return risk_item;
    }

    public void setRisk_item(String risk_item) {
        this.risk_item = risk_item;
    }

    public String getFlag_cashcard() {
        return flag_cashcard;
    }

    public void setFlag_cashcard(String flag_cashcard) {
        this.flag_cashcard = flag_cashcard;
    }
}
