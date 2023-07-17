package com.gatherhub.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    Integer contractId;

    @Column(name = "member_phone")
    String memberPhone;

    @Column(name = "office_id")
    String officeId;

    @Column(name = "company_taxid")
    String companyTaxid;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @Column(name = "payment_status")
    Boolean paymentStatus;

    @Column(name = "payment_method")
    String paymentMethod;

    @Column(name = "remark")
    String remark;

    @Column(name = "contract_pdf")
    String contractPDF;
}