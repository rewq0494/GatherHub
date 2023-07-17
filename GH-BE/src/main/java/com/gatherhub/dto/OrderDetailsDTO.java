package com.gatherhub.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class OrderDetailsDTO {

    private Date rentalDate;
    private Time rentalTime;
    private String meetingroomId;
    private String activityName;
    private String companyName;
    private String companyTaxId;
    private String memberName;
    private String memberPhone;
    private String memberEmail;

    public OrderDetailsDTO() {
        // 空的預設建構函式
    }

    public OrderDetailsDTO(Date rentalDate, Time rentalTime, String meetingroomId, String activityName, String companyName, String companyTaxId, String memberName, String memberPhone, String memberEmail) {
        this.rentalDate = rentalDate;
        this.rentalTime = rentalTime;
        this.meetingroomId = meetingroomId;
        this.activityName = activityName;
        this.companyName = companyName;
        this.companyTaxId = companyTaxId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberEmail = memberEmail;
    }
}
