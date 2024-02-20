package com.placement.company;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@CrossOrigin
public class CompanyController {
	@Autowired
	CompanyRepository CompanyRep;
	
	@PostMapping("/company")
	public Company addCompany(@RequestBody Company company) {
		return CompanyRep.save(company);
	    // Your implementation here
	}
	
	@GetMapping("/company")
	public List<Company>getCompany(){
		return CompanyRep.findAll();
	}
	
	@DeleteMapping("/company/{companyId}")
	public void deleteCompany(@PathVariable Long companyId) {
		CompanyRep.deleteById(companyId);
	}
	

	@PutMapping("/company/{companyId}")
	public Company updateCompany(@PathVariable Long companyId,@RequestBody Company company) {
		company.setCompanyId(companyId);
		return CompanyRep.save(company);
	}
}
