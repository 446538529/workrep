package com.mideadc.component.llwallet.wallet.bean;

/**
 * 连连钱包
 * 2.1 商户付款 B2C(所属+收款商户号)
 * 企业钱包
 * 5.6 商户付款钱包用户接口（B2C）
 * 
 * @author spirng
 *
 */
public class TraderUserPaymentReq extends BaseParamsReq {

	private static final long serialVersionUID = 1L;

	// 付款方商户号
	private String pay_oidpartner;
	// 收款方用户
	private String col_userid;
	// 付款金额
	private String money_order;
	// 风险控制参数
	private String risk_item;
	// 订单附加信息
	private String info_order;
	// 支付来源
	private String proc_src;
	// 商品名称
	private String name_goods;
	// 商户订单时间
	private String dt_order;
	// 商户唯一订单号
	private String no_order;

	public String getPay_oidpartner() {
		return pay_oidpartner;
	}

	public void setPay_oidpartner(String pay_oidpartner) {
		this.pay_oidpartner = pay_oidpartner;
	}

	public String getCol_userid() {
		return col_userid;
	}

	public void setCol_userid(String col_userid) {
		this.col_userid = col_userid;
	}

	public String getMoney_order() {
		return money_order;
	}

	public void setMoney_order(String money_order) {
		this.money_order = money_order;
	}

	public String getRisk_item() {
		return risk_item;
	}

	public void setRisk_item(String risk_item) {
		this.risk_item = risk_item;
	}

	public String getInfo_order() {
		return info_order;
	}

	public void setInfo_order(String info_order) {
		this.info_order = info_order;
	}

	public String getProc_src() {
		return proc_src;
	}

	public void setProc_src(String proc_src) {
		this.proc_src = proc_src;
	}

	public String getName_goods() {
		return name_goods;
	}

	public void setName_goods(String name_goods) {
		this.name_goods = name_goods;
	}

	public String getDt_order() {
		return dt_order;
	}

	public void setDt_order(String dt_order) {
		this.dt_order = dt_order;
	}

	public String getNo_order() {
		return no_order;
	}

	public void setNo_order(String no_order) {
		this.no_order = no_order;
	}

}
