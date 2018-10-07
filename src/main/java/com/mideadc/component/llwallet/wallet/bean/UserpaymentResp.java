package com.mideadc.component.llwallet.wallet.bean;

import java.util.List;

/**
 * 连连钱包
 * 7.2 用户收支明细查询接口
 * 企业钱包
 * 6.2 用户收支明细查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserpaymentResp extends BaseParamsResp {

    private String countno;
    // 账单信息详情
    private List<Paybill> paybillList;

    public String getCountno() {
        return countno;
    }

    public void setCountno(String countno) {
        this.countno = countno;
    }

    public List<Paybill> getPaybillList() {
        return paybillList;
    }

    public void setPaybillList(List<Paybill> paybillList) {
        this.paybillList = paybillList;
    }
}
