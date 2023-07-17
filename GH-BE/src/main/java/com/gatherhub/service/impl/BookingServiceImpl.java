package com.gatherhub.service.impl;

import com.gatherhub.dao.CompanyDao;
import com.gatherhub.dao.MeetingRoomOrderDao;
import com.gatherhub.dao.MemberDao;
import com.gatherhub.entity.Company;
import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.entity.Member;
import com.gatherhub.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private MeetingRoomOrderDao meetingRoomOrderDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CompanyDao companyDao;

    //預約功能
    @Override
    public String saveMeetingRoomOrder(MeetingRoomOrder meetingRoomOrder) {
        String merchantTradeNo = meetingRoomOrder.getTradeNo();

        if (merchantTradeNo == null || merchantTradeNo.isEmpty()) {
            return "付款失敗，訂單編號無效";
        }

        MeetingRoomOrder existingOrder = meetingRoomOrderDao.getByTradeNo(merchantTradeNo);
        if (existingOrder != null) {
            return "付款失敗，訂單編號重複";
        }

        meetingRoomOrderDao.save(meetingRoomOrder);
        return "預約成功，訂單編號：" + merchantTradeNo;
    }



    @Override
    public Member getMemberByPhone(String memberPhone) {
        //使用會員手機查詢會員基本資料
        return memberDao.findByMemberPhone(memberPhone);
    }
    public Company getCompanyByTaxID(String companyTaxID) {
        // 实现根据公司统一社会信用代码或税号获取公司信息的逻辑
        return companyDao.findByCompanyTaxId(companyTaxID);
    }




    //查詢訂單詳細資料
    @Override
    public MeetingRoomOrder findOrderWithCompanyAndMember(String tradeNo) {
        return meetingRoomOrderDao.findOrderWithCompanyAndMember(tradeNo);
    }
}

