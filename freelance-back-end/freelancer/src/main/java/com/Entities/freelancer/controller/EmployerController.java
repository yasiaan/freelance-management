package com.Entities.freelancer.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entities.freelancer.model.Employer;
import com.Entities.freelancer.model.Freelancer;
import com.Entities.freelancer.service.EmployerService;
import com.Entities.freelancer.service.FreelancerService;

@Transactional
@RestController
@RequestMapping("/Employer")
public class EmployerController {
	
	private final EmployerService f;
	
	public EmployerController(EmployerService Fs) {
		this.f=Fs;
	}
	
	@RequestMapping(value = "/addEmployer", method = RequestMethod.GET)
	public ResponseEntity<Employer> addEmployer(@RequestParam("nom") String name, @RequestParam("prenom") String prenom, 
			@RequestParam("email") String email,  @RequestParam("phone") String phone, @RequestParam("imgurl") String imgurl,
			@RequestParam("employerCode") String employerCode) {
	
		Employer employer =f.createEmployer(name, prenom, email, phone, imgurl, employerCode);
		return new ResponseEntity<>(employer, HttpStatus.CREATED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
			Employer newemployer  = f.createEmployer(employer);
	    	System.out.print("Ajouté");
	        return new ResponseEntity<>(newemployer, HttpStatus.CREATED);
	 }
	 
	@GetMapping("/employers")
    public ResponseEntity<List<Employer>> getAllEmployers () {
        List<Employer> employers = f.findAllEmployers();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }

	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<Employer> getEmployeeById (@RequestParam("id") Long id) {
    	Employer employer = f.findEmployerById(id);
        return new ResponseEntity<>(employer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Employer> updateEmployee(@RequestBody Employer employer) {
    	Employer uemployer = f.updateEmployer(employer);
        return new ResponseEntity<>(uemployer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        f.deleteEmployer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
