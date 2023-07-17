package com.gatherhub.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meetingroom")
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    String meetingId;

    @Column(name = "rental")
    Double rental;
}
