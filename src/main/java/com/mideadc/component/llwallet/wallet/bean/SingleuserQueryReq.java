package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.1 钱包用户查询接口
 * 企业钱包
 * 6.1 钱包用户查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class SingleuserQueryReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
