package com.gatherhub.service.impl;

import com.gatherhub.dao.CompanyDao;
import com.gatherhub.dao.MeetingRoomOrderDao;
import com.gatherhub.dao.MemberDao;
import com.gatherhub.entity.Company;
import com.gatherhub.entity.MeetingRoomOrder;
import com.gatherhub.entity.Member;
import com.gatherhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MeetingRoomOrderDao meetingRoomOrderDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CompanyDao companyDao;

    // 新增訂單
    public String insert(MeetingRoomOrder meetingRoomOrder) {
        // 驗證必填欄位
        StringBuilder errorMessage = new StringBuilder();

        if (meetingRoomOrder.getRentalDate() == null) {
            errorMessage.append("出租日期為必填欄位\n");
        }

        if (meetingRoomOrder.getMeetingroomId() == null || meetingRoomOrder.getMeetingroomId().isEmpty()) {
            errorMessage.append("會議室名稱為必填欄位\n");
        }

        if (meetingRoomOrder.getRentalTime() == null) {
            errorMessage.append("會議室編號為必填欄位\n");
        }

        // 檢查是否有錯誤信息
        if (errorMessage.length() > 0) {
            return errorMessage.toString();
        }

        // 設置預設值
        if (meetingRoomOrder.getCompanyTaxid() == null || meetingRoomOrder.getCompanyTaxid().isEmpty()) {
            meetingRoomOrder.setCompanyTaxid("無");
        }
        // 如為 null 或為空字串則設置為 "無"
        if (meetingRoomOrder.getRemark() == null || meetingRoomOrder.getRemark().isEmpty()) {
            meetingRoomOrder.setRemark("無");
        }

        // 驗證公司資訊
        if (!validateCompany(meetingRoomOrder.getCompanyTaxid())) {
            return "核對公司資料失敗";
        }

        // 驗證會員資訊
        if (!validateMember(meetingRoomOrder.getMemberPhone())) {
            return "核對會員資料失敗";
        }

        // 執行新增訂單
        meetingRoomOrderDao.save(meetingRoomOrder);
        return "成功新增訂單";
    }

    // 更新訂單
    @Transactional
    @Override
    public String update(String tradeNo, MeetingRoomOrder meetingRoomOrder) {
        // Remark 為 null 或為空字串則設置為 "無"
        if (meetingRoomOrder.getRemark() == null || meetingRoomOrder.getRemark().isEmpty()) {
            meetingRoomOrder.setRemark("無");
        }

        MeetingRoomOrder existingOrder = meetingRoomOrderDao.getByTradeNo(tradeNo);

        if (existingOrder != null) {
            // 驗證公司資訊
            if (!validateCompany(meetingRoomOrder.getCompanyTaxid())) {
                return "核對公司資料失敗";
            }

            // 驗證會員資訊
            if (!validateMember(meetingRoomOrder.getMemberPhone())) {
                return "核對會員資料失敗";
            }

            // 更新订单信息
            existingOrder.setRentalDate(meetingRoomOrder.getRentalDate());
            existingOrder.setRentalTime(meetingRoomOrder.getRentalTime());
            existingOrder.setMeetingroomId(meetingRoomOrder.getMeetingroomId());
            existingOrder.setActivityName(meetingRoomOrder.getActivityName());
            existingOrder.setRemark(meetingRoomOrder.getRemark());
            existingOrder.setTotalAmount(meetingRoomOrder.getTotalAmount());
            existingOrder.setCompanyTaxid(meetingRoomOrder.getCompanyTaxid());
            existingOrder.setMeetingroomId(meetingRoomOrder.getMeetingroomId());
            meetingRoomOrderDao.save(existingOrder);
            meetingRoomOrderDao.flush();
            return "成功更新訂單";
        } else {
            return "訂單不存在";
        }
    }


    // 刪除訂單
    public String delete(String tradeNo) {
        MeetingRoomOrder existingOrder = meetingRoomOrderDao.getByTradeNo(tradeNo);
        if (existingOrder != null) {
            meetingRoomOrderDao.delete(existingOrder);
            return "成功刪除訂單";
        } else {
            return "訂單不存在";
        }
    }

    // 查詢訂單
    @Override
    public MeetingRoomOrder read(String tradeNo) {
        return meetingRoomOrderDao.getByTradeNo(tradeNo);
    }

    //查詢全部訂單
    @Override
    public List<MeetingRoomOrder> getAllOrders() {
        return meetingRoomOrderDao.findAll();
    }

    // 根據關鍵字搜索訂單
    @Override
    public List<MeetingRoomOrder> searchKeyword(String keyword) {
        return meetingRoomOrderDao.findByKeyword(keyword);
    }

    // 根據公司和會員查詢訂單
    @Override
    public MeetingRoomOrder findOrderWithCompanyAndMember(String tradeNo) {
        return meetingRoomOrderDao.findOrderWithCompanyAndMember(tradeNo);
    }

    // 驗證公司資訊
    private boolean validateCompany(String companyTaxId) {
        Company company = companyDao.findByCompanyTaxId(companyTaxId);
        return company != null;
    }

    // 驗證會員資訊
    private boolean validateMember(String memberPhone) {
        Member member = memberDao.findByMemberPhone(memberPhone);
        return member != null;
    }

    //新增綠界ecpay訂單
    @Override
    public String createOrder(String memberPhone, String meetingRoomId, String tradeNo) {
        MeetingRoomOrder meetingRoomOrder = new MeetingRoomOrder();
        meetingRoomOrder.setMemberPhone(memberPhone);
        meetingRoomOrder.setMeetingroomId(meetingRoomId);
        meetingRoomOrder.setTradeNo(tradeNo);

        meetingRoomOrderDao.save(meetingRoomOrder);
        return "新增付款訂單";
    }
}
