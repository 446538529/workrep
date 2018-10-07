package com.mideadc.component.api;

import java.util.HashMap;
import java.util.Map;
import com.mideadc.commons.domain.JsonPage;
import com.mideadc.commons.domain.utils.HttpUtil;
import com.mideadc.commons.domain.utils.JsonUtil;

public class VerifyRealName {
  private static final String VERIFY_REAL_NAME_URL = "https://mobile3elements.shumaidata.com/mobile/verify_real_name";
  private static final String VERIFY_REAL_NAME_APPCODE = "xxx";

  /**
   * 验证三要素
   * 
   * @param name 姓名
   * @param idCardNo 身份证号码
   * @param mobile 手机号
   * @return
   */
  @SuppressWarnings("rawtypes")
  public static JsonPage verifyRealName(String name, String idCardNo, String mobile) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("name", name);
    params.put("idcard", idCardNo);
    params.put("mobile", mobile);
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("Authorization", "APPCODE " + VERIFY_REAL_NAME_APPCODE);
    headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    String resp = HttpUtil.post(VERIFY_REAL_NAME_URL, params, headers);
    System.err.println(resp);
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
    String name = "xxx";
    String idCardNo = "xxx";
    String mobile = "xxx";
    JsonPage jp = VerifyRealName.verifyRealName(name, idCardNo, mobile);
    System.err.println(jp);
  }
}
