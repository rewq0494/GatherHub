package com.gatherhub.service.impl;

import com.gatherhub.dao.MeetingRoomDao;
import com.gatherhub.dao.MeetingRoomOrderDao;
import com.gatherhub.ecpay.payment.integration.AllInOne;
import com.gatherhub.ecpay.payment.integration.domain.AioCheckOutOneTime;
import com.gatherhub.entity.MeetingRoom;
import com.gatherhub.service.EcPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EcPayServiceImpl implements EcPayService {

    @Autowired
    MeetingRoomOrderDao meetingRoomOrderDao;

    @Autowired
    MeetingRoomDao meetingRoomDao;
    @Override
    public String ecpayCheckout(String meetingRoomId, String tradeNo) {

        AllInOne all = new AllInOne("");

        MeetingRoom meetingRoom = meetingRoomDao.getByMeetingId(meetingRoomId);

        AioCheckOutOneTime obj = new AioCheckOutOneTime();
        obj.setMerchantTradeNo(tradeNo);
        obj.setMerchantTradeDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        obj.setTotalAmount(String.valueOf(Math.round(meetingRoom.getRental())));
        obj.setTradeDesc("Thank you");
        obj.setItemName(meetingRoom.getMeetingId());
        obj.setReturnURL("https://48fd-118-163-218-100.ngrok-free.app/callback");//接收交易成功的json資料RtnCode=1
        obj.setOrderResultURL("http://localhost:8080/redirectPost");// 跳轉成功頁面
        obj.setNeedExtraPaidInfo("N");

        String form = all.aioCheckOut(obj, null);

        return form;
    }
}

