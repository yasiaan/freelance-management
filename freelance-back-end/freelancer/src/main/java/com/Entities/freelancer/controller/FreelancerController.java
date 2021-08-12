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

import com.Entities.freelancer.model.Freelancer;
import com.Entities.freelancer.service.FreelancerService;

@Transactional
@RestController
@RequestMapping("/Freelancer")
public class FreelancerController {
	
	private final FreelancerService f;
	
	public FreelancerController(FreelancerService Fs) {
		this.f=Fs;
	}
	
	@RequestMapping(value = "/addFreelancer", method = RequestMethod.GET)
	public ResponseEntity<Freelancer> addFreelancer(@RequestParam("nom") String name, @RequestParam("prenom") String prenom, 
			@RequestParam("email") String email,  @RequestParam("phone") String phone, @RequestParam("imgurl") String imgurl,
			@RequestParam("freelancerCode") String freelancerCode) {
	
		Freelancer freelancer =f.createFreelancer(name, prenom, email, phone, imgurl, freelancerCode);
		return new ResponseEntity<>(freelancer, HttpStatus.CREATED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Freelancer> addFreelancer(@RequestBody Freelancer freelancer) {
	    	Freelancer newfreelancer = f.createFreelancer(freelancer);
	    	System.out.print("Ajouté");
	        return new ResponseEntity<>(newfreelancer, HttpStatus.CREATED);
	 }
	 
	@GetMapping("/freelancers")
    public ResponseEntity<List<Freelancer>> getAllFreelancer () {
        List<Freelancer> freelancers = f.findAllFreelancers();
        return new ResponseEntity<>(freelancers, HttpStatus.OK);
    }

	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<Freelancer> getEmployeeById (@RequestParam("id") Long id) {
    	Freelancer freelancer = f.findFreelancerById(id);
        return new ResponseEntity<>(freelancer, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Freelancer> updateEmployee(@RequestBody Freelancer freelancer) {
    	Freelancer ufreelancer = f.updateFreelancer(freelancer);
        return new ResponseEntity<>(ufreelancer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        f.deleteFreelancer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
