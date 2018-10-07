package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包、企业钱包
 * 3.1 钱包下发短信接口
 *
 * Created by zhaoxz on 2018/1/29.
 */
public class SmsSendReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 绑定手机号码
    private String mob_bind;
    // 营业执照号码（企业用户找回支付密码时需要传入）
    private String num_license;
    // 操作内容
    // 0:用户开户 1:企业用户开户 2:找回企业支付密码|修改绑定手机号码 3:修改用户基本信息 默认 0
    private String flag_send;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMob_bind() {
        return mob_bind;
    }

    public void setMob_bind(String mob_bind) {
        this.mob_bind = mob_bind;
    }

    public String getNum_license() {
        return num_license;
    }

    public void setNum_license(String num_license) {
        this.num_license = num_license;
    }

    public String getFlag_send() {
        return flag_send;
    }

    public void setFlag_send(String flag_send) {
        this.flag_send = flag_send;
    }
}

