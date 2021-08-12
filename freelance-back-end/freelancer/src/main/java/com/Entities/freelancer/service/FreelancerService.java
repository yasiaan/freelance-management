package com.Entities.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entities.freelancer.crud.FreelancerCRUD;
import com.Entities.freelancer.model.Freelancer;

@Service
public class FreelancerService {
	private final FreelancerCRUD f;
	
	@Autowired
	public FreelancerService(FreelancerCRUD f) {
		this.f=f;
	}
	
	public Freelancer createFreelancer(String nom, String prenom, String email, String phone, String imgurl,String freelancerCode) {
		Freelancer freelancer = new Freelancer();
		freelancer.setNom(nom);
		freelancer.setPrenom(prenom);
		freelancer.setEmail(email);
		freelancer.setPhone(phone);
		freelancer.setImgurl(imgurl);
		freelancer.setFreelancerCode(freelancerCode);
		freelancer.setBids(10);

	
		return f.save(freelancer);
	}
	
	public Freelancer createFreelancer(Freelancer freelancer) {
        return f.save(freelancer);
    }
	
	public Freelancer updateFreelancer(Freelancer freelancer) {
        return f.save(freelancer);
    }
	
	public Freelancer findFreelancerById(Long id) {
		return f.findFreelancerById(id);
	}
	
	public List<Freelancer> findAllFreelancers(){
		return (List<Freelancer>) f.findAll();
	}
	
	public void deleteFreelancer(Long freId) {
		f.deleteFreelancerById(freId);
	}
	
}
