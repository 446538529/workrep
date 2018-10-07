package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.8 用户基本信息修改接口
 * 企业钱包
 * 7.1 企业用户基本信息修改接口 7.2 企业用户对公账户修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyUserinfoResp extends BaseParamsResp {
    // 用户唯一编号
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
