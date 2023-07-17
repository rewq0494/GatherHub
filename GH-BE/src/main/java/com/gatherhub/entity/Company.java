package com.gatherhub.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name ="company")
public class Company {

    @Id
    @Column(name = "company_taxid")
    String companyTaxId;

    @Column(name ="company_name")
    String companyName;

    @Column(name="company_membername")
    String companymemberName;

    @Column(name ="company_address")
    String Address;

    @Column(name ="company_phone")
    String companyPhone;

}
