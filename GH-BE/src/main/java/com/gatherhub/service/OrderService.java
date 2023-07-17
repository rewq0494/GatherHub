package com.gatherhub.service;

import com.gatherhub.entity.MeetingRoomOrder;

import java.util.List;

public interface OrderService {
    //新增
    String insert(MeetingRoomOrder meetingRoomOrder);

    //更新
    String update(String tradeNo, MeetingRoomOrder meetingRoomOrder);

    //刪除
    String delete(String tradeNo);

    //查詢單一
    MeetingRoomOrder read(String tradeNo);

    //查詢全部
    List<MeetingRoomOrder> getAllOrders();

    //模糊查詢
    List<MeetingRoomOrder> searchKeyword(String keyword);

    //多表查詢
    MeetingRoomOrder findOrderWithCompanyAndMember(String tradeNo);

    //新增綠界訂單
    String createOrder(String memberPhone, String meetingroomId, String tradeNo);
}
