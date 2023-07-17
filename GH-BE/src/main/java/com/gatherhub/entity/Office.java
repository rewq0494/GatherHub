package com.gatherhub.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    String officeID;

    @Column(name = "rent")
    Double rent;
}
