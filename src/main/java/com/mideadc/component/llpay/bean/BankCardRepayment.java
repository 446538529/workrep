package com.mideadc.component.llpay.bean;

/**
 * 银行卡还款扣款参数
 * 
 * @author spirng
 *
 */
public class BankCardRepayment extends BaseParams {

	private static final long serialVersionUID = 1L;
	// 平台来源
	private String platform;
	// 商户业务类型
	private String busi_partner;
	// 版本号
	private String api_version;
	// 商户唯一订单 号
	private String no_order;
	// 商户订单时间 格式:YYYYMMDDH24MISS 14 位数字， 精确到秒
	private String dt_order;
	// 商品名称
	private String name_goods;
	// 订单描述
	private String info_order;
	// 还款金额
	private String money_order;
	// 服务器异步通知地址
	private String notify_url;
	// 订单有效时间
	private String valid_order;
	// 风险控制参数
	private String risk_item;
	// 分账信息
	private String shareing_data;
	// 计划还款日期 2010-07-06
	private String schedule_repayment_date;
	// 还款计划编号
	private String repayment_no;
	// 支付方式
	private String pay_type;
	// 签约协议号
	private String no_agree;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getBusi_partner() {
		return busi_partner;
	}

	public void setBusi_partner(String busi_partner) {
		this.busi_partner = busi_partner;
	}

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getName_goods() {
		return name_goods;
	}

	public void setName_goods(String name_goods) {
		this.name_goods = name_goods;
	}

	public String getInfo_order() {
		return info_order;
	}

	public void setInfo_order(String info_order) {
		this.info_order = info_order;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getValid_order() {
		return valid_order;
	}

	public void setValid_order(String valid_order) {
		this.valid_order = valid_order;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

	public String getShareing_data() {
		return shareing_data;
	}

	public void setShareing_data(String shareing_data) {
		this.shareing_data = shareing_data;
	}

	public String getSchedule_repayment_date() {
		return schedule_repayment_date;
	}

	public void setSchedule_repayment_date(String schedule_repayment_date) {
		this.schedule_repayment_date = schedule_repayment_date;
	}

	public String getRepayment_no() {
		return repayment_no;
	}

	public void setRepayment_no(String repayment_no) {
		this.repayment_no = repayment_no;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}

	public String getNo_agree() {
		return no_agree;
	}

	public void setNo_agree(String no_agree) {
		this.no_agree = no_agree;
	}
}
