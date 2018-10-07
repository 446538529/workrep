package com.mideadc.component.llwallet.accp.bean;

import com.mideadc.component.llwallet.wallet.bean.BaseParamsReq;
import com.mideadc.component.llwallet.wallet.bean.BaseParamsResp;

import java.util.Date;

/**
 * 提现结果查询响应参数
 */
public class WithdrawCashQueryResp extends BaseParamsResp{
    //账务日期(yyyyMMdd)
    private String accounting_date;
    //支付完成时间(yyyyMMddHHmmss)
    private String finish_time;
    //提现交易状态,TRADE_SUCCESS:成功/TRADE_FAILURE:交易失败/TRADE_CANCEL:退汇/TRADE_PREPAID:预付完成
    private String txn_status;
    //提现失败原因,txn_status为FAILURE或者CANCEL时，返回失败原因
    private String failure_reason;
    //提现收款银行编码
    private String bankcode;
    //付款方信息
    private PayerInfo payerInfo;
    //商户订单信息
    private OrderInfo orderInfo;

    public String getAccounting_date() {
        return accounting_date;
    }

    public void setAccounting_date(String accounting_date) {
        this.accounting_date = accounting_date;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getTxn_status() {
        return txn_status;
    }

    public void setTxn_status(String txn_status) {
        this.txn_status = txn_status;
    }

    public String getFailure_reason() {
        return failure_reason;
    }

    public void setFailure_reason(String failure_reason) {
        this.failure_reason = failure_reason;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
