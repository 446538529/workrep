package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.10 用户职业住址修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyBaseUserinfoResp extends BaseParamsResp {
    // 用户唯一编号
    private String user_id;
    // 钱包状态 （0 ：V0(待实名认证) 1：V1（完成信息认证） 2：V2（V1+证件认证））
    private String stat_user;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getStat_user() {
        return stat_user;
    }

    public void setStat_user(String stat_user) {
        this.stat_user = stat_user;
    }
}
