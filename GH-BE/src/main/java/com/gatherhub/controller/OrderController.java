package com.gatherhub.controller;

import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.service.OrderService;
import com.gatherhub.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/meetings")
public class OrderController {

    @Autowired
    private OrderService orderService;



    // 新增訂單
    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody MeetingRoomOrder meetingRoomOrder) {

        String response = orderService.insert(meetingRoomOrder);
        if (response.startsWith("成功新增訂單")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // 更新訂單
        @PutMapping("/update/{tradeNo}")
    public ResponseEntity<String> update(@PathVariable String tradeNo, @RequestBody MeetingRoomOrder meetingRoomOrder) {
        String response = orderService.update(tradeNo, meetingRoomOrder);
        if (response.startsWith("成功更新")) {
            return ResponseEntity.ok(response);
        } else if (response.equals("更新失敗, 數據不存在")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // 刪除訂單
    @DeleteMapping("/delete/{tradeNo}")
    public ResponseEntity<String> delete(@PathVariable String tradeNo) {
        String response = orderService.delete(tradeNo);
        if (response.startsWith("成功刪除訂單")) {
            return ResponseEntity.ok(response);
        } else if (response.equals("刪除失敗, 訂單不存在")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 查詢單一訂單
    @GetMapping("/{tradeNo}")
    public ResponseEntity<MeetingRoomOrder> read(@PathVariable String tradeNo) {
        MeetingRoomOrder order = orderService.read(tradeNo);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 查詢全部訂單
    @GetMapping
    public ResponseEntity<List<MeetingRoomOrder>> getAllOrders() {
        List<MeetingRoomOrder> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 搜尋訂單功能
    @GetMapping("/search")
    public ResponseEntity<List<MeetingRoomOrder>> searchOrders(@RequestParam("keyword") String keyword) {
        List<MeetingRoomOrder> orders = orderService.searchKeyword(keyword);
        return ResponseEntity.ok(orders);
    }

    // 查詢詳細資料
    @GetMapping("/details/{tradeNo}")
    public ResponseEntity<MeetingRoomOrder> orderDetails(@PathVariable String tradeNo) {

        MeetingRoomOrder order = orderService.findOrderWithCompanyAndMember(tradeNo);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
