package com.gatherhub.dao;

import com.gatherhub.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.List;

public interface CompanyDao extends JpaRepository<Company, String> {
    List<Company> findByCompanyNameContaining(String keyword);
    //Company findByCompanyTaxId(String companyTaxId);

    Company findByCompanyTaxId(String companyTaxId);

}
