package com.mideadc.component.llpay.bean;

import java.util.HashMap;
import java.util.Map;
import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.commons.domain.utils.JsonUtil;
import com.mideadc.commons.domain.utils.SignUtil;
import com.mideadc.component.llpay.config.LlPayConfig;

public class LlPayBeanHelper {

	public static SignApply createSignApply(String cardNo, UserParams userParams) {
		SignApply signApply = new SignApply();
		signApply.setVersion(LlPayConfig.VERSION);
		signApply.setOid_partner(LlPayConfig.OID_PARTNER);
		signApply.setUser_id(userParams.getUserDepositCardId());
		signApply.setApp_request("3");
		signApply.setSign_type(LlPayConfig.SIGN_TYPE);
		signApply.setId_type("0");
		signApply.setId_no(userParams.getIdCardNo());
		signApply.setAcct_name(userParams.getName());
		signApply.setCard_no(cardNo);
		signApply.setPay_type("I");
		signApply.setRisk_item(createRiskItem(userParams));
		signApply.setUrl_return(LlPayConfig.URL_RETURN);
		// signApply.setRepayment_plan(repayment_plan);
		// signApply.setRepayment_no(repayment_no);
		// signApply.setSms_param(sms_param);
		String sign = SignUtil.sign(signApply, "&key=" + LlPayConfig.MD5_KEY);
		signApply.setSign(sign);
		return signApply;
	}

	public static AgreenOauthApply createAgreenOauthApply(String userDepositCardId, String repaymentPlan, String agreeNo) {
		AgreenOauthApply agreenOauthApply = new AgreenOauthApply();
		agreenOauthApply.setApi_version("1.0");
		agreenOauthApply.setOid_partner(LlPayConfig.OID_PARTNER);
		agreenOauthApply.setUser_id(userDepositCardId);
		agreenOauthApply.setSign_type(LlPayConfig.SIGN_TYPE);

		// agreenOauthApply.setPlatform("");
		agreenOauthApply.setRepayment_plan("{\"repaymentPlan\":" + repaymentPlan + "}");
		agreenOauthApply.setRepayment_no(agreeNo);
		agreenOauthApply.setPay_type("D");
		agreenOauthApply.setNo_agree(agreeNo);
		String sign = SignUtil.sign(agreenOauthApply, "&key=" + LlPayConfig.MD5_KEY);
		agreenOauthApply.setSign(sign);
		return agreenOauthApply;
	}

	public static BankCardRepayment createBankCardRepayment(String orderNo, String amount, String scheduleRepaymentDate, String agreeNo, UserParams userParams) {
		BankCardRepayment bankCardRepayment = new BankCardRepayment();
		bankCardRepayment.setApi_version("1.0");
		bankCardRepayment.setOid_partner(LlPayConfig.OID_PARTNER);
		bankCardRepayment.setUser_id(userParams.getUserDepositCardId());
		bankCardRepayment.setSign_type(LlPayConfig.SIGN_TYPE);

		// bankCardRepayment.setPlatform(platform);
		bankCardRepayment.setBusi_partner("101001");
		bankCardRepayment.setNo_order(orderNo);
		bankCardRepayment.setDt_order(DateUtil.getLocalDate(DateUtil.dtLong));
		bankCardRepayment.setName_goods("储值卡分期还款");
		// bankCardRepayment.setInfo_order(info_order);
		bankCardRepayment.setMoney_order(amount);
		bankCardRepayment.setNotify_url(LlPayConfig.NOTIFY_URL);
		// bankCardRepayment.setValid_order(valid_order);
		bankCardRepayment.setRisk_item(createRiskItem(userParams));
		// bankCardRepayment.setShareing_data(shareing_data);
		bankCardRepayment.setSchedule_repayment_date(scheduleRepaymentDate);
		bankCardRepayment.setRepayment_no(agreeNo);
		bankCardRepayment.setPay_type("D");
		bankCardRepayment.setNo_agree(agreeNo);
		String sign = SignUtil.sign(bankCardRepayment, "&key=" + LlPayConfig.MD5_KEY);
		bankCardRepayment.setSign(sign);
		return bankCardRepayment;
	}

	public static BankCardUnbind createBankCardUnbind(String userDepositCardId, String agreeNo) {
		BankCardUnbind bankCardUnbind = new BankCardUnbind();
		bankCardUnbind.setOid_partner(LlPayConfig.OID_PARTNER);
		bankCardUnbind.setUser_id(userDepositCardId);
		bankCardUnbind.setSign_type(LlPayConfig.SIGN_TYPE);
		bankCardUnbind.setPay_type("D");
		bankCardUnbind.setNo_agree(agreeNo);
		String sign = SignUtil.sign(bankCardUnbind, "&key=" + LlPayConfig.MD5_KEY);
		bankCardUnbind.setSign(sign);
		return bankCardUnbind;
	}

	public static String createRiskItem(UserParams userParams) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("frms_ware_category", "2013");
		params.put("user_info_mercht_userno", userParams.getUserDepositCardId());
		params.put("user_info_dt_register", DateUtil.getLocalDate(DateUtil.dtLong));
		params.put("user_info_bind_phone", userParams.getPhone()); // 绑定的手机号
		params.put("user_info_identify_state", "1"); // 是否实名认证
		params.put("user_info_identify_type", "1"); // 实名认证方式
		params.put("user_info_full_name", userParams.getName()); // 用户姓名
		params.put("user_info_id_no", userParams.getIdCardNo()); // 用户身份证号
		return JsonUtil.toJson(params);
	}
}
