package com.Entities.freelancer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposal implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, updatable=false)
	private Long id;
	private String description;
	private Date dateAjout;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "freelancer_id")
	private Freelancer freelancer;




public Proposal(String description, Date dateAjout) {
		this.setDescription(description);
		this.setDateAjout(dateAjout);
	}


public Proposal() {
	
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Date getDateAjout() {
	return dateAjout;
}


public void setDateAjout(Date dateAjout) {
	this.dateAjout = dateAjout;
}

@Override
public String toString() {
	return "Proposal [id=" + id + ", description=" + description + ", dateAjout=" + dateAjout + ", project="
			+ project + ", freelancer=" + freelancer + "]";
}

}


