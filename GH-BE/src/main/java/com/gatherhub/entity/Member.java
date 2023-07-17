package com.gatherhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_phone")
    String  memberPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_taxid", referencedColumnName = "company_taxid")
    Company company;

//    @Column(name = "company_taxid")
//    String companyId;

    @Column(name = "member_name")
    String memberName;

    @Column(name = "email")
    String memberEmail;

    @Column(name = "member_account")
    String memberAccount;

    @Column(name = "member_password")
    String memberPassword;
}
