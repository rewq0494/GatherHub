package com.gatherhub.dao;

import com.gatherhub.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractDao extends JpaRepository<Contract, Integer> {
    @Query("SELECT contractId, startDate, endDate FROM Contract")
    List<Object[]> getOfficeUsageData();

    @Query("SELECT c.startDate, c.endDate, o.rent " +
            "FROM Contract c " +
            "JOIN Office o ON c.officeId = o.officeID")
    List<Object[]> getContractDateWithRent();


    @Query("SELECT c FROM Contract c WHERE MONTH(c.startDate) = MONTH(CURRENT_DATE)")
    List<Contract> findContractsForCurrentMonth();
    Contract findByOfficeId(String officeId);

}
