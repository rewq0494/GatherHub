package com.gatherhub.controller;

import com.gatherhub.dao.CompanyDao;
import com.gatherhub.dao.ContractDao;
import com.gatherhub.dao.OfficeDao;
import com.gatherhub.entity.Company;
import com.gatherhub.entity.Contract;
import com.gatherhub.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UseConditionController {

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private CompanyDao companyDao;


    //把OFFICE表單的RENT也帶進來了
    @GetMapping("/contract")
    public List<ContractDto> getAllContract() {
        List<Contract> contracts = (List<Contract>) contractDao.findAll();
        List<ContractDto> contractDtos = new ArrayList<>();

        for (Contract contract : contracts) {
            ContractDto contractDto = new ContractDto();
            contractDto.setOfficeId(contract.getOfficeId());
            contractDto.setStartDate(contract.getStartDate());
            contractDto.setEndDate(contract.getEndDate());
            contractDto.setCompanyTaxId(contract.getCompanyTaxid());
            contractDto.setPaymentStatus(contract.getPaymentStatus());

            Company company = companyDao.findByCompanyTaxId(contract.getCompanyTaxid());
            if (company != null) {
                contractDto.setCompanyName(company.getCompanyName());
            }

            Office office = officeDao.findByOfficeID(contract.getOfficeId());
            if (office != null) {
                contractDto.setRent(office.getRent());
            }

            contractDtos.add(contractDto);
        }

        return contractDtos;
    }

    public static class ContractDto {
        private String companyName;
        private String officeId;
        private LocalDate startDate;
        private LocalDate endDate;
        private String companyTaxId;
        private Boolean paymentStatus;
        private Double rent;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOfficeId() {
            return officeId;
        }

        public void setOfficeId(String officeId) {
            this.officeId = officeId;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getCompanyTaxId() {
            return companyTaxId;
        }

        public void setCompanyTaxId(String companyTaxId) {
            this.companyTaxId = companyTaxId;
        }

        public Boolean getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(Boolean paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public Double getRent() {
            return rent;
        }

        public void setRent(Double rent) {
            this.rent = rent;
        }
    }

     // "companyName": "GHI科技股份有限公司",
    //"startDate": "2023-06-28",
    //"endDate": "2023-12-31",
    //"companyTaxId": "333",
    //"paymentStatus": true
    //要先去office新增辦公室的號碼跟租金
    //然後在contract裡必須新增對應的辦公室號碼 才能在頁面按下修改
    //要新增的辦公室的公司統編要存在在company裡以及companyname需要對應才能新增
    //companyname可以不用輸入 輸入統編他會自動偵測並顯示companyname
    @PutMapping("/contract/{officeId}")
    public String updateContract(@PathVariable String officeId, @RequestBody ContractRequest contractRequest) {
        // Check if office exists
        Office office = officeDao.findByOfficeID(officeId);
        if (office == null) {
            throw new IllegalArgumentException("Invalid office ID: " + officeId);
        }

        // Find the existing contract by officeId
        Contract existingContract = contractDao.findByOfficeId(officeId);
        if (existingContract == null) {
            throw new IllegalArgumentException("Contract not found for office ID: " + officeId);
        }

        // Check if company exists
        Company company = companyDao.findByCompanyTaxId(contractRequest.getCompanyTaxId());
        if (company == null) {
            throw new IllegalArgumentException("Company not found for company tax ID: " + contractRequest.getCompanyTaxId());
        }

        // Update the contract object with new data

        existingContract.setRemark("Company Name: " + company.getCompanyName());
        existingContract.setStartDate(contractRequest.getStartDate());
        existingContract.setEndDate(contractRequest.getEndDate());
        existingContract.setCompanyTaxid(contractRequest.getCompanyTaxId());
        existingContract.setPaymentStatus(contractRequest.getPaymentStatus());

        // Save the updated contract object to the database
        Contract updatedContract = contractDao.save(existingContract);

        // Create a contract DTO object and return it

        return "更改成功";
    }

    public static class ContractRequest {
        private String companyName;
        private String officeId;
        private LocalDate startDate;
        private LocalDate endDate;
        private String companyTaxId;
        private Boolean paymentStatus;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getOfficeId() {
            return officeId;
        }

        public void setOfficeId(String officeId) {
            this.officeId = officeId;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getCompanyTaxId() {
            return companyTaxId;
        }

        public void setCompanyTaxId(String companyTaxId) {
            this.companyTaxId = companyTaxId;
        }

        public Boolean getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(Boolean paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        // Getters and setters

        // ...
    }
}