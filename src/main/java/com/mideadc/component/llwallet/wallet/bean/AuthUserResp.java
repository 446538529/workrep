package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.7 钱包实名认证接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class AuthUserResp extends BaseParamsResp {

	private static final long serialVersionUID = 1L;
	// 用户唯一编号
	private String user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
