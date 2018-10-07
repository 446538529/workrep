package com.mideadc.component.llwallet.wallet.bean;

import java.io.File;

/**
 * 企业钱包 3.4 企业用户上传照片接口
 *
 * Created by zhaoxz on 2018/2/1.
 */
public class UploadUnitPhotoReq extends BaseParamsReq {

	private static final long serialVersionUID = 1L;
	// 商户用户唯一编号
	private String user_id;
	// 服务器异步通知地址
	private String notify_url;
	// 法人身份证正面照片
	private File front_card;
	// 法人身份证反面照片
	private File back_card;
	// 营业执照复印件
	private File copy_license;
	// 组织机构代码复印件
	private File copy_org;
	// 银行开户许可证
	private File bank_openlicense;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public File getFront_card() {
		return front_card;
	}

	public void setFront_card(File front_card) {
		this.front_card = front_card;
	}

	public File getBack_card() {
		return back_card;
	}

	public void setBack_card(File back_card) {
		this.back_card = back_card;
	}

	public File getCopy_license() {
		return copy_license;
	}

	public void setCopy_license(File copy_license) {
		this.copy_license = copy_license;
	}

	public File getCopy_org() {
		return copy_org;
	}

	public void setCopy_org(File copy_org) {
		this.copy_org = copy_org;
	}

	public File getBank_openlicense() {
		return bank_openlicense;
	}

	public void setBank_openlicense(File bank_openlicense) {
		this.bank_openlicense = bank_openlicense;
	}

}
