package com.gatherhub.controller;

import com.gatherhub.dao.CompanyDao;
import com.gatherhub.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class MemberController {

    @Autowired
    private CompanyDao companyDao;

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return (List<Company>) companyDao.findAll();
    }

    @PostMapping("/company")
    public String Insert(@RequestBody Company company) {
        companyDao.save(company);
        return "新增成功囉";
    }


    //taxid不能修改
    @CrossOrigin(origins = "*")
    @PutMapping("/company/{companyTaxId}")
    public String updateCompany(@PathVariable String companyTaxId, @RequestBody Company updatedCompany) {
        // 根据 companyId 从数据库中获取要修改的公司记录
        Optional<Company> optionalCompany = companyDao.findById(companyTaxId);

        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();

            // 更新要修改的字段

            company.setCompanyName(updatedCompany.getCompanyName());
            company.setAddress(updatedCompany.getAddress());
            company.setCompanyPhone(updatedCompany.getCompanyPhone());
            company.setCompanymemberName(updatedCompany.getCompanymemberName());


            companyDao.save(company);

            return "成功更新";
        } else {
            return "找不到公司";
        }
    }
    // 用/company/search?keyword=
    @GetMapping("/company/search")
    public List<Company> searchCompany(@RequestParam("keyword") String keyword) {
        List<Company> companies = companyDao.findByCompanyNameContaining(keyword);
        return companies;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/company/{companyTaxId}")
    public ResponseEntity<?> deleteCompany(@PathVariable("companyTaxId") String companyTaxId) {
        Optional<Company> optionalCompany = companyDao.findById(companyTaxId);

        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            companyDao.delete(company);
            return ResponseEntity.ok("已刪除");
        } else {
            return ResponseEntity.badRequest().body("找不到此筆資料");
        }
    }


}
