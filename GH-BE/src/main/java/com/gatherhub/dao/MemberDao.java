package com.gatherhub.dao;

import com.gatherhub.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberDao extends JpaRepository<Member, String> {
    boolean existsByMemberAccount(String memberAccount);

    Member findByMemberPhone(String memberPhone);
    Member findByMemberAccount(String memberAccount);

    @Query("SELECT COUNT(*) AS totalMember FROM Member")
    Double getTotalMember();

}
