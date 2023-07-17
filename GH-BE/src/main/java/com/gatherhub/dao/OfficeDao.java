package com.gatherhub.dao;

import com.gatherhub.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeDao extends JpaRepository<Office, String> {
    Office findByOfficeID(String officeId);
}
