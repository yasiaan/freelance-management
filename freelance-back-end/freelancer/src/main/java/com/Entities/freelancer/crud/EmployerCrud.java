package com.Entities.freelancer.crud;

import org.springframework.data.repository.CrudRepository;

import com.Entities.freelancer.model.Employer;

public interface EmployerCrud extends CrudRepository<Employer, Long>{

	Employer findEmployerById(Long id);

	void deleteEmployerById(Long EmpId);

}
