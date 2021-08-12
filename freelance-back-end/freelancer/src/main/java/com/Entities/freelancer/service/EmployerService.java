package com.Entities.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.Entities.freelancer.crud.EmployerCrud;
import com.Entities.freelancer.model.Employer;
import com.Entities.freelancer.model.Freelancer;

@Service
public class EmployerService  {
	private final EmployerCrud e;
	
	@Autowired
	public EmployerService(EmployerCrud e) {
		this.e=e;
	}
	
	public Employer createEmployer(String nom, String prenom, String email, String phone, String imgurl,String employerCode) {
		Employer employer = new Employer();
		employer.setNom(nom);
		employer.setPrenom(prenom);
		employer.setEmail(email);
		employer.setPhone(phone);
		employer.setImgurl(imgurl);
		employer.setEmployerCode(employerCode);

	
		return e.save(employer);
	}
	
	public Employer createEmployer(Employer employer) {
        return e.save(employer);
    }
	
	public Employer updateEmployer(Employer employer) {
        return e.save(employer);
    }
	
	public Employer findEmployerById(Long id) {
		return e.findEmployerById(id);
	}
	
	public List<Employer> findAllEmployers(){
		return (List<Employer>) e.findAll();
	}
	
	public void deleteEmployer(Long empId) {
		e.deleteEmployerById(empId);
	}
	
}
