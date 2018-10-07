package com.mideadc.component.llwallet.wallet;

/**
 * Created by zhaoxz on 2018/2/7.
 */
public interface LlWalletTradeHandler {

    /**
     * 照片审核结果接收成功时的回调函数
     *
     * @param user_id
     *            商户用户唯一编号
     * @param kyc_status
     *            审核状态（0:待实名认证 1:实名认证通过 2:实名认证不通过 3:审核中 4:审核通过 5:审核不通过 6:证件过期 7:待完善 ）
     * @param oid_partner
     *            商户编号
     *
     */
    public void success(String user_id, String kyc_status, String oid_partner);


    /**
     * 照片审核结果接收失败时的回调函数
     *
     */
    public void fail(String msg);

}
