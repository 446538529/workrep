package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.2 用户收支明细查询接口
 * 企业钱包
 * 6.2 用户收支明细查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class UserpaymentReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 用户唯一编号
    private String user_id;
    // 查询偏移量
    private String offset;
    // 每页记录数
    private String maxrecordes;
    // 开始时间
    private String dt_start;
    // 结束时间
    private String dt_end;
    // 查询结果排序方式（0：顺序（默认） 1：倒序）
    private String reverseOrder;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getMaxrecordes() {
        return maxrecordes;
    }

    public void setMaxrecordes(String maxrecordes) {
        this.maxrecordes = maxrecordes;
    }

    public String getDt_start() {
        return dt_start;
    }

    public void setDt_start(String dt_start) {
        this.dt_start = dt_start;
    }

    public String getDt_end() {
        return dt_end;
    }

    public void setDt_end(String dt_end) {
        this.dt_end = dt_end;
    }

    public String getReverseOrder() {
        return reverseOrder;
    }

    public void setReverseOrder(String reverseOrder) {
        this.reverseOrder = reverseOrder;
    }
}
