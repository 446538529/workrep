package com.mideadc.component.llwallet.wallet.bean;

import java.io.File;

/**
 * 连连钱包
 * 3.4 钱包上传身份证接口
 *
 * Created by zhaoxz on 2018/1/30.
 */
public class UploadCardPhotoReq extends BaseParamsReq {

    private static final long serialVersionUID = 1L;

    private String user_id;

    private String notify_url;

    private File front_card;

    private File back_card;

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
}
