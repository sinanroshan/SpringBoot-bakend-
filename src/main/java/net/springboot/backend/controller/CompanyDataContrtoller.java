package net.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.backend.model.CompanyData;
import net.springboot.backend.repository.CompanyDataRrepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CompanyDataContrtoller {

    @Autowired
    private CompanyDataRrepository companyDataRrepository;

    @GetMapping("/company")
	public CompanyData
			GetCompany(){
		return companyDataRrepository.getCompany();
	}
    
}
