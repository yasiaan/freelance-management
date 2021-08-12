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

import com.Entities.freelancer.model.Project;
import com.Entities.freelancer.service.ProjectService;

@Transactional
@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	private final ProjectService f;
	
	public ProjectController(ProjectService Fs) {
		this.f=Fs;
	}
	
	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ResponseEntity<Project> addProject(@RequestParam("title") String title, @RequestParam("description") String description, 
			@RequestParam("projectCode") String projectCode) {
	
		Project project =f.createProject(title, description,projectCode);
		return new ResponseEntity<>(project, HttpStatus.CREATED);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
	    	Project newproject = f.createProject(project);
	    	System.out.print("projet Ajouté");
	        return new ResponseEntity<>(newproject, HttpStatus.CREATED);
	 }
	 
	@GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProject () {
        List<Project> projects = f.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

	@RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<Project> getEmployeeById (@RequestParam("id") Long id) {
    	Project project = f.findProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateEmployee(@RequestBody Project project) {
    	Project uproject = f.updateProject(project);
        return new ResponseEntity<>(uproject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        f.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
