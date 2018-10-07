package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.9 用户绑定手机修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyUsermobReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 授权码
    private String token;
    // 绑定手机号码
    private String mob_bind;
    // 风险控制参数
    private String risk_item;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
