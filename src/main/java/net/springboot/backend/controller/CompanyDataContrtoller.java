package net.springboot.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(path = "EditProduct/",method = RequestMethod.POST)
	public String EditProduct(@RequestBody CompanyData data) {
			companyDataRrepository.updateData(data.getName(),data.getAddress1(),data.getAddres2(),data.getPhone(),data.getEmail(),data.getWebsite(),data.getGstNo(),data.getCity(),data.getState(),data.getCountry(),data.getBank(),data.getBankBranch(),data.getBankIfce(),data.getBankAccNO(),data.getLogo());
			return "Updated";
			}	
    
}
