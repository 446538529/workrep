package com.mideadc.component.wechat.bean;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.mideadc.commons.domain.utils.JsonUtil;

public class TplMsg {
	private String touser;
	private String template_id;
	private String url;
	private Map<String, TplMsgValue> data;

	public TplMsg() {
	}

	public TplMsg(String touser, String template_id, String url, Map<String, String> params) {
		this.touser = touser;
		this.template_id = template_id;
		this.url = url;
		this.data = new HashMap<String, TplMsgValue>();
		Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			data.put(key, new TplMsgValue(value));
		}
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, TplMsgValue> getData() {
		return data;
	}

	public void setData(Map<String, TplMsgValue> data) {
		this.data = data;
	}

	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "Hello world");
		params.put("first", "恭喜你购买成功！");
		params.put("age", "18");
		TplMsg tpl1 = new TplMsg("aaa", "123", "http://www.baidu.com", params);
		System.out.println(JsonUtil.toJson(tpl1));

	}
}
