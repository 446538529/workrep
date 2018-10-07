package com.mideadc.component.api;

import java.util.HashMap;
import java.util.Map;
import com.mideadc.commons.domain.JsonPage;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;

public class BankCardVerify {
  private static final String VERIFY_URL = "https://bankcard3.shumaidata.com/bank_card3/verify";
  private static final String VERIFY_APPCODE = "xxx";

  /**
   * 银行卡三要素验证
   * 
   * @param name 姓名
   * @param idCardNo 身份证号码
   * @param bankCard 银行卡
   * @return
   */
  public static JsonPage verify(String name, String idCardNo, String bankCard) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("name", name);
    params.put("idcard", idCardNo);
    params.put("bankcard", bankCard);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", "APPCODE " + VERIFY_APPCODE);
    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    String resp = HttpUtil.post(VERIFY_URL, params, headers);
    if (resp != null) {
      @SuppressWarnings("unchecked")
      Map<String, ?> resultMap = JsonUtil.fromJson(resp, HashMap.class);
      String code = (String) resultMap.get("code");
      if ("0".equals(code)) {
        @SuppressWarnings("unchecked")
        Map<String, ?> result = (Map) resultMap.get("result");
        String message = (String) result.get("description");
        String res = (String) result.get("res");
        return JsonPage.createMsg(res.equals("1"), message);
      } else {
        return JsonPage.createErrorMsg((String) resultMap.get("message"));
      }
    }
    return JsonPage.createErrorMsg("验证不通过");
  }

  public static void main(String[] args) {
    String name = "xx";
    String idCardNo = "xxx";
    String bankCard = "xxxxx";
    JsonPage jp = BankCardVerify.verify(name, idCardNo, bankCard);
    System.err.println(jp);
  }
}
