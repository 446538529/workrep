package com.mideadc.component.wechat;

import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.component.wechat.bean.*;
import com.mideadc.component.wechat.config.WeChatConfig;

import java.util.HashMap;
import java.util.Map;

public class WeChatApi {
	// 获取access_token URL
	private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
	// 通过code换取网页授权access_token URL
	private static String ACCESS_TOKEN_BY_CODE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";
	// 拉取用户信息(需scope为 snsapi_userinfo) URL
	private static String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";
	// 发送模板消息 URL
	private static String SEND_TPL_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";
	// 生成带参数的二维码 URL
	private static String CREATE_QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=";

	/**
	 * 微信小程序URL
	 */
	private static String ACCESS_TOKEN_APP_URL = "https://api.weixin.qq.com/sns/jscode2session";

	/**
	 * 通过jscode获取微信小程序会话秘钥session_key
	 * 参考：https://developers.weixin.qq.com/miniprogram/dev/api/open-api/login/code2Session.html
	 * @param jsCode
	 * @param appId
	 * @param secret
	 * @return
	 */
	public static AccessTokenAppResp getAppAccessTokenByCode(String jsCode,String appId, String secret) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", appId);
		params.put("secret", secret);
		params.put("js_code", jsCode);
		params.put("grant_type", "authorization_code");
		String resp = HttpUtil.get(ACCESS_TOKEN_APP_URL, params);
		AccessTokenAppResp accessTokenResp = JsonUtil.fromJson(resp, AccessTokenAppResp.class);
		return accessTokenResp;
	}
	/**
	 * 获取access token<br>
	 * 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183
	 * 
	 * @return
	 */
	public static AccessTokenResp getAccessToken(WeChatConfig weChatConfig) {
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", weChatConfig.APPID);
		params.put("secret", weChatConfig.SECRET);
		params.put("grant_type", "client_credential");
		String resp = HttpUtil.get(ACCESS_TOKEN_URL, params);
		AccessTokenResp accessTokenResp = JsonUtil.fromJson(resp, AccessTokenResp.class);
		return accessTokenResp;
	}

	/**
	 * 通过code换取网页授权access_token<br>
	 * 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842
	 * 
	 * @param code
	 * @return
	 */
	public static AccessTokenResp getAccessTokenByCode(String code, WeChatConfig weChatConfig) {
		// https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", weChatConfig.APPID);
		params.put("secret", weChatConfig.SECRET);
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		String resp = HttpUtil.get(ACCESS_TOKEN_BY_CODE_URL, params);
		AccessTokenResp accessTokenResp = JsonUtil.fromJson(resp, AccessTokenResp.class);
		return accessTokenResp;
	}

	public static AccessTokenResp getAccessTokenByCode(String code, String appId, String secret) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("appid", appId);
		params.put("secret", secret);
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		String resp = HttpUtil.get(ACCESS_TOKEN_BY_CODE_URL, params);
		AccessTokenResp accessTokenResp = JsonUtil.fromJson(resp, AccessTokenResp.class);
		return accessTokenResp;
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	public static WeChatUserInfo getUserInfo(String accessToken, String openid) {
		// https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", accessToken);
		params.put("openid", openid);
		params.put("lang", "zh_CN");
		String resp = HttpUtil.get(USER_INFO_URL, params);
		WeChatUserInfo accessTokenResp = JsonUtil.fromJson(resp, WeChatUserInfo.class);
		return accessTokenResp;
	}

	/**
	 * 发送模板消息<br>
	 * 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277
	 * 
	 * @param touser
	 * @param template_id
	 * @param url
	 * @param dataParams
	 */
	public static SendTplMsgResp sendTplMsg(String touser, String template_id, String url, Map<String, String> dataParams, WeChatConfig weChatConfig) {
		Map<String, String> params = new HashMap<String, String>();
		AccessTokenResp token = getAccessToken(weChatConfig);
		params.put("access_token", token.getAccessToken());
		TplMsg tplMsg = new TplMsg(touser, template_id, url, dataParams);
		String jsonBody = JsonUtil.toJson(tplMsg);
		String resp = HttpUtil.post(SEND_TPL_MSG_URL, params, null, jsonBody);
		SendTplMsgResp sendTplMsgResp = JsonUtil.fromJson(resp, SendTplMsgResp.class);
		return sendTplMsgResp;
	}

	public static String getQRCodeUrl(String accessToken, String flag) {
		String jsonBody = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\":\"" + flag + "\"}}}";
		String resp = HttpUtil.post(CREATE_QR_CODE_URL + accessToken, null, null, jsonBody);
		Map<String, String> responseMap = JsonUtil.fromJson(resp, Map.class);
		String url = responseMap.get("url");
		return url;
	}

	public static void main(String[] args) {
		WeChatConfig weChatConfig = new WeChatConfig();
		weChatConfig.APPID = "wx532b16d646bde121";
		weChatConfig.MCH_ID = "1357774702";
		weChatConfig.KEY = "WWXY64ILTKCH16CQ2502SI8ZNMTM67VS";
		weChatConfig.NOTIFY_URL = "http://card.52wxr.com";
		weChatConfig.SECRET = "2a38091011905f4168d41ffc76958e12";
		weChatConfig.CERTIFICATE_PASSWORD = "1357774702";
		weChatConfig.CERTIFICATE_PATH = "/Users/spirng/WW/cert/apiclient_cert.p12";
		// weChatConfig.CERTIFICATE_PATH =
		// "C:/anzhuangjia/WeChatCert/apiclient_cert.p12";
		// Map<String, String> dataParams = new HashMap<String, String>();
		// dataParams.put("tradeDateTime", DateUtil.getLocalDate());
		// dataParams.put("tradeType", "消费");
		// dataParams.put("curAmount", "389.00");
		// dataParams.put("remark", "点击查看详情");
		// sendTplMsg("oKMb6sqUsq0x-ILK7E235jJP4reI",
		// "DuNmreE-DKY9n1vbyBVfd5Xrwg40sybOdo7yyf49Y9E", "http://www.52wxr.com",
		// dataParams);

		// String qrCode = WeChatPaySubmit.buildCodeUrl("iWatch",
		// DateUtil.getOrderNum(), "100");
		// System.err.println(qrCode);
		// String result34 = DateUtil.getOrderNum();
		// boolean result = WeChatPaySubmit.sendRedPack(result34, "Spring",
		// "oKMb6sqUsq0x-ILK7E235jJP4reI", "100", "不客气，拿去花吧", weChatConfig);
		// System.err.println(result);
		// System.err.println(result34);
		// RedPackSendResult result2 = WeChatPaySubmit.getRedPackSendResult("0000000",
		// weChatConfig);
		//
		// System.err.println(result2);
		//
		// RedPackSendResult result3 = WeChatPaySubmit.getRedPackSendResult(result34,
		// weChatConfig);
		// System.err.println(result3);
		String accessToken = "4_xzXcLjj4inlGnSdI389r54io-KvHZ6tM-gIlfJEHKtKXWPPVLO26Zbxznit-AzJNrjBxhjxNbwb1X04Lm2lSBWSUClRkAKwjnvAsFr2vcL29OSTsIF_Y7cL6hOQTuIs7jVOP7ROrdWifUh-NVFLfAGDAKQ";
		String qrCodeUrl = getQRCodeUrl(accessToken, "Hello");
		System.err.println("qrCodeUrl:" + qrCodeUrl);
	}

}
