package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.9 用户绑定手机修改接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class ModifyUsermobResp extends BaseParamsResp {

    // 用户唯一编号
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
