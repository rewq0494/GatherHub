package com.gatherhub.service;

import com.gatherhub.entity.Company;
import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.entity.Member;

public interface BookingService {
    String saveMeetingRoomOrder(MeetingRoomOrder meetingRoomOrder);

    Member getMemberByPhone(String memberPhone);

    MeetingRoomOrder findOrderWithCompanyAndMember(String tradeNo);

    Company getCompanyByTaxID(String companyTaxID);
}
