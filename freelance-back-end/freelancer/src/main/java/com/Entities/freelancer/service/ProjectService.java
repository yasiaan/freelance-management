package com.Entities.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entities.freelancer.crud.FreelancerCRUD;
import com.Entities.freelancer.crud.ProjectCRUD;
import com.Entities.freelancer.model.Freelancer;
import com.Entities.freelancer.model.Project;

@Service
public class ProjectService {
	private final ProjectCRUD p;
	
	@Autowired
	public ProjectService(ProjectCRUD p) {
		this.p=p;
	}
	
	public Project createProject(String title, String description,String projectCode) {
		Project project = new Project();
		project.setTitle(title);
		project.setDescription(description);
		project.setProjectCode(projectCode);
			
		return p.save(project);
	}
	
	public Project createProject(Project project) {
        return p.save(project);
    }
	
	public Project updateProject(Project project) {
        return p.save(project);
    }
	
	public Project findProjectById(Long id) {
		return p.findProjectById(id);
	}
	
	public List<Project> findAllProjects(){
		return (List<Project>) p.findAll();
	}
	
	public void deleteProject(Long prjId) {
		p.deleteProjectById(prjId);
	}
	
}
