package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 7.3 订单查询接口
 * 企业钱包
 * 6.3 订单查询接口
 *
 * Created by zhaoxz on 2018/1/31.
 */
public class OrderQueryReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;
    // 商户唯一订单号
    private String no_order;
    // 商户订单时间
    private String dt_order;
    // 连连钱包支付单号
    private String oid_paybill;
    // 收付标识 （收付类型，标志交易收付款方类型 0：商户收款（单 业务等） 1：商户付款 （商户 提现、批付 提现、 批付 业务 等） 2：内部收款（用户收款，转账，充值等） 3：用户提现 ）
    private String type_dc;
    // 查询版本号
    private String query_version;
    //用户唯一编号
    private String user_id;

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getDt_order() {
        return dt_order;
    }

    public void setDt_order(String dt_order) {
        this.dt_order = dt_order;
    }

    public String getOid_paybill() {
        return oid_paybill;
    }

    public void setOid_paybill(String oid_paybill) {
        this.oid_paybill = oid_paybill;
    }

    public String getType_dc() {
        return type_dc;
    }

    public void setType_dc(String type_dc) {
        this.type_dc = type_dc;
    }

    public String getQuery_version() {
        return query_version;
    }

    public void setQuery_version(String query_version) {
        this.query_version = query_version;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
