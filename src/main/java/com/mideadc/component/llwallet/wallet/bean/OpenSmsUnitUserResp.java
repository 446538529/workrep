package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 3.3 企业用户短信开户接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class OpenSmsUnitUserResp extends BaseParamsResp {

    // 用户唯一编号
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
