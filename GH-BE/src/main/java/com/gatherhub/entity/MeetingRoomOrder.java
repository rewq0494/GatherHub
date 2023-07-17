    package com.gatherhub.entity;


    import lombok.Data;

    import javax.persistence.*;
    import java.sql.Time;
    import java.util.Date;

    @Data
    @Entity
    @Table(name = "meetingroomorder")
    public class MeetingRoomOrder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        //訂單編號
        @Column(name = "order_id")
        Integer orderId;

        //統編
        @Column(name = "company_taxid")
        String companyTaxid;

        //公司關聯
        @ManyToOne
        @JoinColumn(name = "company_taxid", referencedColumnName = "company_taxid", insertable = false, updatable = false)
        Company company;

        //會員ID
        @Column(name = "member_phone")
        String memberPhone ;

        //會員關聯
        @ManyToOne
        @JoinColumn(name = "member_phone", referencedColumnName = "member_phone", insertable = false, updatable = false)
        Member member;

        //出租日期
        @Column(name = "rental_date")
        Date rentalDate;

        //出租時間
        @Column(name = "rental_time")
        String rentalTime;

        //會議室編號
        @Column(name = "meetingroom_id")
        String meetingroomId;

        //活動名稱
        @Column(name = "activity_name")
        String activityName;

        //總額
        @Column(name = "total_amount")
        Double totalAmount;

        //備註
        @Column(name = "remark")
        String remark;

        //綠界交易序號
        @Column(name = "trade_no")
        String tradeNo;


    }
