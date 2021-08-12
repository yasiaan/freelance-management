package com.Entities.freelancer.crud;

import org.springframework.data.repository.CrudRepository;

import com.Entities.freelancer.model.Employer;
import com.Entities.freelancer.model.Freelancer;
import com.Entities.freelancer.model.Project;

public interface ProjectCRUD extends CrudRepository<Project, Long>{

	Project findProjectById(Long id);

	void deleteProjectById(Long prjId);

}
