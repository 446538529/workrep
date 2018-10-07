package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.5 用户认证查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserauthQueryReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 商户用户唯一编号
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
