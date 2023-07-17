package com.gatherhub.dao;


import com.gatherhub.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
