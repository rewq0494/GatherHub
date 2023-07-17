package com.gatherhub.controller;

import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.service.BookingService;
import com.gatherhub.service.EcPayService;
import com.gatherhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class EcPayController {
    @Autowired
    EcPayService ecPayService;
    @Autowired
    BookingController bookingController;
    @Autowired
    BookingService bookingService;
    @Autowired
    OrderService orderService;

    @PostMapping("/ecpay")
    public String ecpayCheckout(@RequestBody Map<String, Object> requestPayload) {
        String meetingroomId = (String) requestPayload.get("meetingroomId");
        String memberPhone = (String) requestPayload.get("memberPhone");

        // 產生訂單編號
        String tradeNo = "GH" + System.currentTimeMillis();

        String createOrderResult = orderService.createOrder(memberPhone, meetingroomId, tradeNo);
        System.out.println(createOrderResult);

        String aioCheckOutALLForm = ecPayService.ecpayCheckout(meetingroomId, tradeNo);

        return aioCheckOutALLForm;
    }


    @PostMapping("/callback")
    public String ecpayReturn(HttpServletRequest request) {
        // 解析綠界回傳的參數
//        String merchantID = request.getParameter("MerchantID");
        String merchantTradeNo = request.getParameter("MerchantTradeNo");
        String rtnCode = request.getParameter("RtnCode");

        System.out.println("rtnCode = " + rtnCode);

        if (rtnCode.equals("1")) {
            System.out.println("merchantTradeNo = " + merchantTradeNo);
            System.out.println("付款完成!");
            return "1|OK";
        } else {
            System.out.println("付款失敗!");
            // 返回给綠界的回應，例如 "0|Fail"
            return "0|Fail";
        }
    }

    //OrderResultURL實現跳轉頁面
    @PostMapping("/redirectPost")
    public void redirect(HttpServletResponse response) throws Exception {
        response.sendRedirect("/ecpay.html");
    }

    // 更新預約訂單
    @PutMapping("/update/{tradeNo}")
    public ResponseEntity<String> update(@PathVariable String tradeNo, @RequestBody MeetingRoomOrder meetingRoomOrder) {
        String response = orderService.update(tradeNo, meetingRoomOrder);
        if (response.startsWith("成功預約會議室")) {
            return ResponseEntity.ok(response);
        } else if (response.equals("預約失敗, 請聯絡客服")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
