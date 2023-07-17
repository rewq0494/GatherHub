package com.gatherhub.dao;

import com.gatherhub.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomDao extends JpaRepository<MeetingRoom, String> {
    MeetingRoom getByMeetingId(String meetingId);
}
