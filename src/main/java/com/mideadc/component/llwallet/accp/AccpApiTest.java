package com.mideadc.component.llwallet.accp;

import com.mideadc.commons.domain.utils.DateUtil;
import com.mideadc.component.llwallet.accp.AccpApi;
import com.mideadc.component.llwallet.accp.bean.OrderInfo;
import com.mideadc.component.llwallet.accp.bean.PayeeInfo;
import com.mideadc.component.llwallet.accp.bean.TradeCreateReq;
import com.mideadc.component.llwallet.accp.bean.TradeCreateResp;
import org.junit.Test;

import java.util.Date;

public class AccpApiTest {
    @Test
    public void testCreateTrade(){
        TradeCreateReq req=new TradeCreateReq();
        req.setTimestamp(new Date());
        req.setTxn_type("USER_TOPUP");
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setTxn_seqno("1234567");
        orderInfo.setTxn_time(new Date());
        orderInfo.setTotal_amount(20.0);
        PayeeInfo payeeInfo=new PayeeInfo();
        payeeInfo.setPayee_id("120");
        payeeInfo.setPayee_type("USER");
        payeeInfo.setPayee_amount(20.0);
        req.setOrderInfo(orderInfo);
        PayeeInfo[] payeeInfos={payeeInfo};
        req.setPayeeInfo(payeeInfos);
        TradeCreateResp createResp = AccpApi.createTrade(req);
        System.out.println(createResp);
    }
}
