package org.ResumerApp.api.Work;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;

@Entity
public class WorkEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double experience;
	
	private String company;
	
	private String role;
	
	private String project;

	@ManyToOne(fetch = FetchType.LAZY)
	private PersonalEntity person;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	public PersonalEntity getPerson() {
		return person;
	}

	public void setPerson(PersonalEntity person) {
		this.person = person;
	}

	public WorkEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
