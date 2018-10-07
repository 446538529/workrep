package com.mideadc.component.wechat;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.commons.domain.utils.Dom4jUtil;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.component.wechat.bean.AccessTokenResp;
import com.mideadc.component.wechat.bean.CustomMsg;
import com.mideadc.component.wechat.bean.SendTplMsgResp;
import com.mideadc.component.wechat.bean.TextContent;
import com.mideadc.component.wechat.bean.TplMsg;
import com.mideadc.component.wechat.bean.TplMsgValue;
import com.mideadc.component.wechat.open.AesException;
import com.mideadc.component.wechat.open.WXBizMsgCrypt;

/**
 * 参考：https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419318292&lang=zh_CN
 * 
 * @author Spirng
 *
 */
public class WeChatOpenApi {
  private static final Logger LOG = LoggerFactory.getLogger(WeChatOpenApi.class);
  public static String COMPONENT_APPID = "xx";
  public static String COMPONENT_APPSECRET = "xx";
  public static String TOKEN = "xx-wesrNi6kseSxdf6FFiPyemODI-88CjkIFKQeRtyye";
  public static String ENCODING_AES_KEY = "xx";


  // 获取第三方平台component_access_token URL
  public static final String COMPONENT_ACCESS_TOKEN_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
  // 获取预授权码pre_auth_code URL
  public static final String PRE_AUTH_CODE_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";
  // 获取jsapi_ticket URL
  public static final String JSAPI_TICKET_URL =
      "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={ACCESS_TOKEN}&type=jsapi";
  // 通过code换取access_token URL
  public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/component/access_token";
  // 发送模板消息 URL
  private static String SEND_TPL_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send";
  // 使用授权码换取公众号或小程序的接口调用凭据和授权信息 URL
  private static String GET_AUTH_INFO_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=";
  // 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）URL
  private static String AUTHORIZER_REFRESH_TOKEN_URL =
      "https://api.weixin.qq.com/cgi-bin/component/api_authorizer_token?component_access_token=";
  // 发送模板消息 URL
  private static String SEND_CUSTOM_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

  /**
   * 获取component_verify_ticket
   * 
   * @param msgSignature
   * @param timestamp
   * @param nonce
   * @param xmlBody
   * @return
   */
  public static String getcomponentVerifyTicket(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String componentVerifyTicket = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/ComponentVerifyTicket");
    return componentVerifyTicket;
  }

  public static String getInfoType(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String infoType = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/InfoType");
    return infoType;
  }

  public static String getMsgType(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String value = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/MsgType");
    return value;
  }

  public static String getEvent(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String value = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/Event");
    return value;
  }

  public static String getEventKey(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String value = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/EventKey");
    return value;
  }

  public static String getAuthorizationCode(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String authorizationCode = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/AuthorizationCode");
    return authorizationCode;
  }

  public static String getAuthorizerAppId(String msgSignature, String timestamp, String nonce, String xmlBody) {
    String decryptXml = getDecryptXml(msgSignature, timestamp, nonce, xmlBody);
    String authorizerAppId = Dom4jUtil.selectSingleNodeText(decryptXml, "//xml/AuthorizerAppid");
    return authorizerAppId;
  }

  public static String getDecryptXml(String msgSignature, String timestamp, String nonce, String xmlBody) {
    try {
      WXBizMsgCrypt wxOpenCrypt = new WXBizMsgCrypt(TOKEN, ENCODING_AES_KEY, COMPONENT_APPID);
      String decryptXml = wxOpenCrypt.decryptMsg(msgSignature, timestamp, nonce, xmlBody);
      if (LOG.isDebugEnabled()) {
        LOG.debug("解密后的XML:\r\n{}", decryptXml);
      }
      return decryptXml;
    } catch (AesException e) {
      LOG.error("解密XML时出错", e);
    }
    return null;
  }

  /**
   * 获取第三方平台component_access_token
   * 
   * @param componentVerifyTicket
   * @return
   */
  public static String getComponentAccessToken(String componentVerifyTicket) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("component_appid", COMPONENT_APPID);
    params.put("component_appsecret", COMPONENT_APPSECRET);
    params.put("component_verify_ticket", componentVerifyTicket);
    String reqJson = JsonUtil.toJson(params);
    String response = HttpUtil.post(COMPONENT_ACCESS_TOKEN_URL, null, null, reqJson);
    if (null != response) {
      @SuppressWarnings("unchecked")
      Map<String, String> respJson = JsonUtil.fromJson(response, HashMap.class);
      String componentAccessToken = respJson.get("component_access_token");
      if (null != componentAccessToken) {
        return componentAccessToken;
      } else {
        LOG.error("获取第三方平台component_access_token失败：{}", response);
      }
    }
    return null;
  }

  /**
   * 获取预授权码pre_auth_code
   * 
   * @param componentAccessToken
   * @return
   */
  public static String getPreAuthCode(String componentAccessToken) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("component_appid", COMPONENT_APPID);
    String response = HttpUtil.post(PRE_AUTH_CODE_URL + componentAccessToken, null, null, JsonUtil.toJson(params));
    if (null != response) {
      @SuppressWarnings("unchecked")
      Map<String, String> respJson = JsonUtil.fromJson(response, HashMap.class);
      String preAuthCode = respJson.get("pre_auth_code");
      if (null != preAuthCode) {
        return preAuthCode;
      } else {
        LOG.error("获取预授权码pre_auth_code失败：{}", response);
      }
    }
    return null;
  }

  public static String getAuthorizerPageUrl(String componentAccessToken, String redirectUrl) {
    String preAuthCode = getPreAuthCode(componentAccessToken);
    String authUrl = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=" + COMPONENT_APPID
        + "&pre_auth_code=" + preAuthCode + "&redirect_uri=" + redirectUrl;
    return authUrl;
  }

  /**
   * 通过code换取access_token
   * 
   * @param appId
   * @param code
   * @param componentAccessToken
   * @return
   */
  public static AccessTokenResp getAccessToken(String appId, String code, String componentAccessToken) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("appid", appId);
    params.put("code", code);
    params.put("grant_type", "authorization_code");
    params.put("component_appid", COMPONENT_APPID);
    params.put("component_access_token", componentAccessToken);
    String resp = HttpUtil.get(ACCESS_TOKEN_URL, params);
    AccessTokenResp accessTokenResp = JsonUtil.fromJson(resp, AccessTokenResp.class);
    return accessTokenResp;
  }

  /**
   * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
   * 
   * @param authorizationCode 授权code,会在授权成功时返回给第三方平台，详见第三方平台授权流程说明
   * @param componentAccessToken
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static Map getAuthorizationInfo(String authorizationCode, String componentAccessToken) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("component_appid", COMPONENT_APPID);
    params.put("authorization_code", authorizationCode);
    String resp = HttpUtil.post(GET_AUTH_INFO_URL + componentAccessToken, null, null, JsonUtil.toJson(params));
    Map<String, Map> respMap = JsonUtil.fromJson(resp, HashMap.class);
    return respMap.get("authorization_info");
  }

  /**
   * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
   * 
   * @param authorizerAppId 公众号appId
   * @param authorizerRefreshToken
   * @param componentAccessToken
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static String authorizerRefreshToken(String authorizerAppId, String authorizerRefreshToken,
      String componentAccessToken) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("component_appid", COMPONENT_APPID);
    params.put("authorizer_appid", authorizerAppId);
    params.put("authorizer_refresh_token", authorizerRefreshToken);
    String resp =
        HttpUtil.post(AUTHORIZER_REFRESH_TOKEN_URL + componentAccessToken, null, null, JsonUtil.toJson(params));
    Map respMap = JsonUtil.fromJson(resp, HashMap.class);
    String authorizer_access_token = respMap.get("authorizer_access_token").toString();
    return authorizer_access_token;
  }

  /**
   * 发送对话框 图文消息<br>
   * 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277
   *
   * @param touser
   * @param authorizerAccessToken
   * @return
   */
  public static SendTplMsgResp sendCustomMsgResp(CustomMsg customMsg, String authorizerAccessToken) {
    /*
     * CustomMsg customMsg=new CustomMsg(); customMsg.setTouser(touser); customMsg.setMsgtype("news");
     * Articles news = new Articles(); Article article = new Article();
     * article.setDescription("老板说了，过门都是客，相遇也是缘，送你优惠券，您一定要笑纳哦！\n" +
     * "那恭敬不如从命了，有券不用，亏在眼前！");//图文消息/视频消息/音乐消息的描述
     * article.setPicurl("");//图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
     * article.setTitle("关注就送优惠券");//图文消息/视频消息/音乐消息的标题 //图文推送链接 String url="https://www.baidu.com";
     * article.setUrl(url);//图文消息被点击后跳转的链接 Article[] articles = {article}; news.setArticles(articles);
     * customMsg.setNews(news);
     */
    Map<String, String> params = new HashMap<String, String>();
    params.put("access_token", authorizerAccessToken);
    String jsonBody = JsonUtil.toJson(customMsg);
    String resp = HttpUtil.post(SEND_CUSTOM_MSG_URL, params, null, jsonBody);
    SendTplMsgResp sendTplMsgResp = JsonUtil.fromJson(resp, SendTplMsgResp.class);
    return sendTplMsgResp;
  }

  /**
   * 发送对话框 文字消息<br>
   * 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277
   *
   * @param touser
   * @param text
   * @param authorizerAccessToken
   * @return
   */
  public static SendTplMsgResp sendCustomMsgResp(String touser, String text, String authorizerAccessToken) {
    CustomMsg customMsg = new CustomMsg(touser, "text", new TextContent(text));
    Map<String, String> params = new HashMap<String, String>();
    params.put("access_token", authorizerAccessToken);
    String jsonBody = JsonUtil.toJson(customMsg);
    String resp = HttpUtil.post(SEND_CUSTOM_MSG_URL, params, null, jsonBody);
    SendTplMsgResp sendTplMsgResp = JsonUtil.fromJson(resp, SendTplMsgResp.class);
    return sendTplMsgResp;
  }

  /**
   * 发送模板消息<br>
   * 新版 可以增加字体颜色 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277
   *
   * @param touser
   * @param template_id
   * @param url
   * @param data
   * @param authorizerAccessToken
   * @return
   */
  public static SendTplMsgResp sendTplMsgResp(String touser, String template_id, String url,
      Map<String, TplMsgValue> data, String authorizerAccessToken) {
    TplMsg tplMsg = new TplMsg();
    tplMsg.setTouser(touser);
    tplMsg.setTemplate_id(template_id);
    tplMsg.setUrl(url);
    tplMsg.setData(data);
    Map<String, String> params = new HashMap<String, String>();
    params.put("access_token", authorizerAccessToken);
    String jsonBody = JsonUtil.toJson(tplMsg);
    String resp = HttpUtil.post(SEND_TPL_MSG_URL, params, null, jsonBody);
    SendTplMsgResp sendTplMsgResp = JsonUtil.fromJson(resp, SendTplMsgResp.class);
    return sendTplMsgResp;
  }

  /**
   * 发送模板消息<br>
   * 模板字体颜色都是黑色 参考：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277
   * 
   * @param touser
   * @param template_id
   * @param url
   * @param dataParams
   * @param authorizerAccessToken
   * @return
   */
  public static SendTplMsgResp sendTplMsg(String touser, String template_id, String url, Map<String, String> dataParams,
      String authorizerAccessToken) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("access_token", authorizerAccessToken);
    TplMsg tplMsg = new TplMsg(touser, template_id, url, dataParams);
    String jsonBody = JsonUtil.toJson(tplMsg);
    String resp = HttpUtil.post(SEND_TPL_MSG_URL, params, null, jsonBody);
    SendTplMsgResp sendTplMsgResp = JsonUtil.fromJson(resp, SendTplMsgResp.class);
    return sendTplMsgResp;
  }


  /**
   * 获取jsapi_ticket
   *
   * @param componentAccessToken
   * @return
   */
  public static String getJsapiTicket(String componentAccessToken) {
    String url = JSAPI_TICKET_URL.replace("{ACCESS_TOKEN}", componentAccessToken);
    String response = HttpUtil.get(url);
    if (null != response) {
      @SuppressWarnings("unchecked")
      Map<String, String> respJson = JsonUtil.fromJson(response, HashMap.class);
      String ticket = respJson.get("ticket");
      if (null != ticket) {
        return ticket;
      } else {
        LOG.error("获取jsapi_ticket失败：{}", response);
      }
    }
    return null;
  }

  public static void main(String[] args) throws Exception {
    String accessToken =
        "RadIAkqtVWP5R_ljdGSdWWW5F0znHdocF9nnbe7LHjBGMzQSqpAjZ-dDaacEIeUPVPPLv-IwCxxqV4w9fsG7kvPVhMrFEl49pSAHSqasJxw0Vx7S6uAIyraUrG1isYuBZEGfAKDEJL";
    // String url = getAuthorizerPageUrl(accessToken, "https://open.52wxr.com/");
    // System.err.println(url);

    Map<String, String> dataParams = new HashMap<String, String>();
    dataParams.put("tradeDateTime", DateUtil.getLocalDate());
    dataParams.put("tradeType", "消费21");
    dataParams.put("curAmount", "389.00");
    dataParams.put("remark", "点击查看详情111");
    String touser = "oKMb6sqUsq0x-ILK7E235jJP4reI";
    String template_id = "DuNmreE-DKY9n1vbyBVfd5Xrwg40sybOdo7yyf49Y9E";
    String url1 = "";
    sendTplMsg(touser, template_id, url1, dataParams, accessToken);

    // Map m =
    // getAuthInfo("queryauthcode@@@xV__PzoTo-NJ4ayKw1Vgg-K8Mq0uEEnylTu66yXDErOQgCo3uY8kIZ7ETU3H2ykiAsed2jODahSCnXELjD_PHA",
    // accessToken);
    // System.err.println(m);
  }

}
