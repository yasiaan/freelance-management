package com.Entities.freelancer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, updatable=false)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private String imgurl;
	@Column(nullable=false, updatable=false)
	private String employerCode;
	@OneToMany(mappedBy = "employer", cascade = {CascadeType.ALL})
	private List < Project > porojets;






public String getEmployerCode() {
		return employerCode;
	}


	public void setEmployerCode(String employerCode) {
		this.employerCode = employerCode;
	}


public Employer(String nom, String prenom, String email, String phone, String imgurl, String employerCode) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
		this.imgurl = imgurl;
		this.employerCode = employerCode;
	}


public Employer() {
	
}


public Long getId() {
	return this.id;
	}
	public void setId(Long id) {
	this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getFreelancerCode() {
		return employerCode;
	}

	public void setFreelancerCode(String employerCode) {
		this.employerCode = employerCode;
	}


	@Override
	public String toString() {
		return "Freelancer [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", phone=" + phone
				+ ", imgurl=" + imgurl + ", EmployerCode=" + employerCode + "]";
	}
	
}
