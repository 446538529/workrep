package com.mideadc.component.wechat.bean;
//客服发送对话框消息 发送文本消息
public class TextContent {
	private String content;

	public TextContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
