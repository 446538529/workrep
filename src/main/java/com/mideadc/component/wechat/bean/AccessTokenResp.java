package com.mideadc.component.wechat.bean;

import com.google.gson.annotations.SerializedName;

public class AccessTokenResp {
	@SerializedName("access_token")
	private String accessToken;
	@SerializedName("expires_in")
	private int expiresIn;
	@SerializedName("refresh_token")
	private String refreshToken;
	private String openid;
	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "AccessTokenResp [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshToken=" + refreshToken + ", openid=" + openid + ", scope=" + scope + "]";
	}

}
