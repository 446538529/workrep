package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 6.7 钱包实名认证接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class AuthUserReq extends BaseParamsReq {

	private static final long serialVersionUID = 1L;
	// 用户唯一编号
	private String user_id;
	// 用户认证状态 1:I类账户认证 2:II类账户认证 3:III类账户认证
	private String check_auth;
	// 风险控制参数
	private String risk_item;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCheck_auth() {
		return check_auth;
	}

	public void setCheck_auth(String check_auth) {
		this.check_auth = check_auth;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

}
