package com.mideadc.component.llwallet.wallet.bean;

import java.util.List;

/**
 * 连连钱包
 * 7.4 签约查询接口
 * 企业钱包
 * 6.5 个体工商户绑卡查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserbankcardResp extends BaseParamsResp {

    // 商户用户唯一编号
    private String user_id;
    // 总记录条数
    private String count;
    // 结果集
    private List<UserbankcardAgreement> agreement_list;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<UserbankcardAgreement> getAgreement_list() {
        return agreement_list;
    }

    public void setAgreement_list(List<UserbankcardAgreement> agreement_list) {
        this.agreement_list = agreement_list;
    }
}
