package com.Entities.freelancer.crud;

import org.springframework.data.repository.CrudRepository;
import com.Entities.freelancer.model.Freelancer;

public interface FreelancerCRUD extends CrudRepository<Freelancer, Long> {

	void deleteFreelancerById(Long freId);

	Freelancer findFreelancerById(Long id);

	
}
