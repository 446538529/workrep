package com.mideadc.component.llwallet.wallet.bean;

/**
 * 商户账户余额查询接口
 *
 * Created by zhaoxz on 2018/2/3.
 */
public class TraderAcctQueryReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;

    private String api_version;

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }
}
