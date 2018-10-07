package com.mideadc.component.wechat.pay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletRequest;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mideadc.commons.domain.utils.SignUtil;

public class WeChatPayResult {
	private static final Logger LOG = LoggerFactory.getLogger(WeChatPayResult.class);

	public static String doHandler(ServletRequest request, WeChatPayTradeHandler weChatPayTradeHandler) {
		try {
			String requestBody = IOUtils.toString(request.getInputStream());
			LOG.debug("微信支付结果通知：\r\n{}", requestBody);
			if (StringUtils.isNotBlank(requestBody)) {
//				PayResult payResult = JaxbUtil.converyToJavaBean(requestBody, PayResult.class);
//				Map<String, String> payResult = JaxbUtil.converyToJavaBean(requestBody, HashMap.class);
				Map<String, String> payResult = xmlStr2Map(requestBody);
				String mch_id = payResult.get("mch_id");
				String sign = payResult.get("sign");
				String signed = SignUtil.sign(payResult, "&key=" + weChatPayTradeHandler.getWeChatKey(mch_id));
                if (signed.equalsIgnoreCase(sign)) {
					String out_trade_no = payResult.get("out_trade_no");
					String trade_no = payResult.get("transaction_id");
					String total_fee = payResult.get("total_fee");
					if (payResult.get("result_code").equals("SUCCESS")) {
						weChatPayTradeHandler.success(mch_id, out_trade_no, trade_no, total_fee);
						return buildResponseXml(true, null);
					} else {
						weChatPayTradeHandler.fail(out_trade_no, trade_no);
					}
				} else {
					LOG.warn("处理微信支付结果通知签名验证失败！");
				}
			}
		} catch (Exception e) {
			LOG.error("处理微信支付结果通知时出现异常", e);
		}
		return null;
	}

	private static String buildResponseXml(boolean success, String msg) {
		String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
		return xml;
	}

    public static Map<String, String> xmlStr2Map(String xmlStr) {
        Map<String, String> map = new HashMap<String, String>();
        Document doc;
        try {
            doc = DocumentHelper.parseText(xmlStr);
            Element root = doc.getRootElement();
            List children = root.elements();
            if (children != null && children.size() > 0) {
                for (int i = 0; i < children.size(); i++) {
                    Element child = (Element) children.get(i);
                    map.put(child.getName(), child.getTextTrim());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }
}
