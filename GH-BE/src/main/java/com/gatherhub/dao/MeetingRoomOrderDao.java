package com.gatherhub.dao;

import com.gatherhub.dto.OrderDetailsDTO;
import com.gatherhub.entity.MeetingRoomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface MeetingRoomOrderDao extends JpaRepository<MeetingRoomOrder, Integer> {
    //模糊搜尋功能
    @Query
            ("SELECT order FROM MeetingRoomOrder order WHERE order.activityName LIKE %:keyword% OR order.companyTaxid LIKE %:keyword% OR order.tradeNo LIKE %:keyword%")
    List<MeetingRoomOrder> findByKeyword(@Param("keyword") String keyword);

    //多表查詢
    @Query("SELECT meeting FROM MeetingRoomOrder meeting JOIN FETCH meeting.company JOIN FETCH meeting.member WHERE meeting.tradeNo = :tradeNo")
    MeetingRoomOrder findOrderWithCompanyAndMember(@Param("tradeNo") String tradeNo);

    MeetingRoomOrder getByTradeNo(String tradeNo);




    @Query("SELECT rentalDate, sum(totalAmount) " +
            "FROM MeetingRoomOrder " +
            "group by month(rentalDate) ")
    List<Object[]> getMeetingRoomMonthRent();


}
