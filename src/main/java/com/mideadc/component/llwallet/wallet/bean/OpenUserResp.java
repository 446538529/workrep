package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 3.3 钱包开户接口（通过短信验证）
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class OpenUserResp extends BaseParamsResp {

	private static final long serialVersionUID = 1L;
	// 用户号
	private String oid_userno;
	// 用户唯一编号
	private String user_id;
	// 钱包状态 0 :V0(待实名认证)、 1:V1(完成信息认证) 2:V2(V1+证件认证)
	private String stat_user;

	public String getOid_userno() {
		return oid_userno;
	}

	public void setOid_userno(String oid_userno) {
		this.oid_userno = oid_userno;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStat_user() {
		return stat_user;
	}

	public void setStat_user(String stat_user) {
		this.stat_user = stat_user;
	}

}
