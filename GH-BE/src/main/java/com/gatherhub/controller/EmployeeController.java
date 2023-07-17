package com.gatherhub.controller;

import com.gatherhub.dao.EmployeeRepository;
import com.gatherhub.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public String insert(@RequestBody Employee employee){

        employeeRepository.save(employee);

        return "Do Create";
    }

    @PutMapping("/employees/{employeeId}")
    public String update(@PathVariable Integer employeeId,
                         @RequestBody Employee employee){

        Employee employeeFindById = employeeRepository.findById(employeeId).orElse(null);

        if (employeeFindById!=null){
            employeeFindById.setEmployeeName(employee.getEmployeeName());
            employeeFindById.setEmployeePassword(employee.getEmployeePassword());
            employeeFindById.setEmployeeEmail(employee.getEmployeeEmail());
            employeeFindById.setPosition(employee.getPosition());
            employeeRepository.save(employeeFindById);

            return "執行資料庫的 Update 操作";

        } else {
            return "Update 失敗，數據不存在";
        }

    }

    @DeleteMapping("/employees/{employeeId}")
    public String delete(@PathVariable Integer employeeId){

        employeeRepository.deleteById(employeeId);

        return "執行資料庫的 Delete 操作";
    }

    @GetMapping("/employees/{employeeId}")
    public Employee read(@PathVariable Integer employeeId){

        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        return employee;
    }


    // get all employees with json type
    @GetMapping("/employees")
    public List<Employee> findAll(Employee employee){
        List<Employee> list = (List<Employee>) employeeRepository.findAll();
        return list;
    }



}
