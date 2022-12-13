package org.ResumerApp.api.Education;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;

@Entity
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String degree;
	
	private long years;
	
	private String stream;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PersonalEntity person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public long getYears() {
		return years;
	}

	public void setYears(long years) {
		this.years = years;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public PersonalEntity getPerson() {
		return person;
	}

	public void setPerson(PersonalEntity person) {
		this.person = person;
	}

	public EducationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
