package com.Entities.freelancer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, updatable=false)
	private Long id;
	private String title;
	private String description;
	@Column(nullable=false, updatable=false)
	private String projectCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id")
	private Freelancer freelancer;


	@OneToMany(mappedBy = "project", cascade = {
	        CascadeType.ALL
	    })
	private List < Proposal > proposals;

public Project(String title, String description, String projectCode) {
		this.title = title;
		this.description = description;
		this.projectCode = projectCode;
	}


public Project() {
	
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getProjectCode() {
	return projectCode;
}


public void setProjectCode(String projectCode) {
	this.projectCode = projectCode;
}

@Override
public String toString() {
	return "Project [id=" + id + ", title=" + title + ", Description=" + description + ", projectCode=" + projectCode
			+ "]";
}

}


