package com.gatherhub.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Integer employeeId;

    @Column(name = "employee_name")
    String employeeName;

    @Column(name = "employee_password")
    String employeePassword;

    @Column(name = "employee_email")
    String employeeEmail;

    @Column(name = "position")
    String Position;
}
