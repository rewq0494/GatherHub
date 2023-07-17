package com.gatherhub.controller;

import com.gatherhub.entity.Company;
import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.entity.Member;
import com.gatherhub.service.BookingService;
import com.gatherhub.service.EcPayService;
import com.gatherhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class BookingController {

//測試用
//    @Autowired
//    public void setBookingService(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }

    private EcPayController ecPayController;

    @Autowired
    BookingService bookingService;

    @Autowired
    EcPayService ecPayService;

    @Autowired
    OrderService orderService;

    // 抓取個人基本資料
    @GetMapping("/booking/profile/{memberPhone}")
    public ResponseEntity<Member> getMemberProfile(@PathVariable String memberPhone) {
        Member member = bookingService.getMemberByPhone(memberPhone);

        if (member != null) {
            String companyTaxID = member.getCompany().getCompanyTaxId();
            Company company = bookingService.getCompanyByTaxID(companyTaxID);
            member.setCompany(company);


            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

//    // 儲存預約訂單
//    @PostMapping("/booking/save/{merchantTradeNo}")
//    public ResponseEntity<String> saveBooking(@PathVariable String merchantTradeNo, @RequestBody MeetingRoomOrder meetingRoomOrder) {
//
//        String response = bookingService.saveMeetingRoomOrder(merchantTradeNo, meetingRoomOrder);
//        if (response.startsWith("預約成功")) {
//            return ResponseEntity.ok(response);
//        } else {
//            return ResponseEntity.badRequest().body(response);
//        }
//    }


    //顯示訂單詳細內容

}

