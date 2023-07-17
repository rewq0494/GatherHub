package com.gatherhub.dao;

import com.gatherhub.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


    // 只選出name
    @Query("SELECT employeeName FROM Employee")
    List<String> findByOnlyName();

//    @Query("SELECT employeeName, employeeEmail FROM Employee")
//    List<Object[]> findNameANDEmail();
}
