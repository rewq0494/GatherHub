package com.gatherhub.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatherhub.service.impl.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    public ManagementService managementService;

    @GetMapping("/officeUsage")
    public List<List<? extends Number>> getAllData() throws JsonProcessingException {
        List<List<? extends Number>> officeUsage = managementService.getAllChartData();
        return officeUsage;
    }

    @GetMapping("/lineChartData")
    public List<List<? extends Number>> getLineChartData() throws JsonProcessingException {
        List<List<? extends Number>> lineChartData = managementService.getLineChartData();
        return lineChartData;
    }

    @GetMapping("/barChartData")
    public List<Double> getBarChartData() {
        List<Double> barChartData = managementService.getBarChartData();
        return barChartData;
    }

    @GetMapping("/someData")
    public List<Double> getSomeData() {
        List<Double> someData = managementService.getSomeData();
        return someData;
    }


}