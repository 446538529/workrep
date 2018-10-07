package com.mideadc.component.llpay.config;

public class LlPayConfig {

	// 连连支付WEB收银台支付服务地址
	public static String PAY_URL = "https://cashier.lianlianpay.com/payment/authpay.htm";
	public static String PAY_H5_URL = "https://wap.lianlianpay.com/authpay.htm";
	public static String QUICK_PAY_H5_URL = "https://wap.lianlianpay.com/payment.htm";
	// WAP签约授权接口 H5 请求地址
	public static String SIGN_APPLY_H5_URL = "https://wap.lianlianpay.com/signApply.htm";
	// 授权申请API接口请求地址
	public static String AGREEN_OAUTH_APPLY_URL = "https://repaymentapi.lianlianpay.com/agreenoauthapply.htm";
	// 银行卡还款扣款接口请求地址
	public static String BANK_CARD_REPAYMENT_URL = "https://repaymentapi.lianlianpay.com/bankcardrepayment.htm";
	// 银行卡解约 API 接口
	public static String BANK_CARD_UNBIND_URL = "https://traderapi.lianlianpay.com/bankcardunbind.htm";
	// 银通公钥
	public static String YT_PUB_KEY;
	// 商户私钥
	public static String TRADER_PRI_KEY;
	// MD5 KEY
	public static String MD5_KEY;
	// 接收异步通知地址
	public static String NOTIFY_URL;
	// 支付结束后返回地址
	public static String URL_RETURN;
	// 商户编号
	public static String OID_PARTNER;
	// 签名方式 RSA或MD5
	public static String SIGN_TYPE;
	// 接口版本号，固定1.0
	public static String VERSION = "1.1";
	// 业务类型，连连支付根据商户业务为商户开设的业务类型； （101001：虚拟商品销售、109001：实物商品销售、108001：外部账户充值）
	public static String BUSI_PARTNER = "101001";

	public static String REAL_TIME_NOTIFY_URL;
	public static String REAL_TIME_PAY_SUBMIT_URL;
	public static String REAL_TIME_PAY_QUERY_URL;
	public static String REAL_TIME_PAY_CALL_BACK_URL;

}
