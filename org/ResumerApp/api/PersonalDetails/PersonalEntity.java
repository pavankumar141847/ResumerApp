package org.ResumerApp.api.PersonalDetails;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.ResumerApp.api.Education.EducationDetails;
import org.ResumerApp.api.ProfileImage.ProfileImageEntity;
import org.ResumerApp.api.Skills.SkillsEntity;
import org.ResumerApp.api.languages.LanguagesEntity;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
public class PersonalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String location;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String name;
	
	private String linkedIn;
	
	@NotNull
	private String About;
	
	@OneToMany(targetEntity = SkillsEntity.class , cascade = CascadeType.ALL , mappedBy = "person" , fetch = FetchType.LAZY)
	private List<SkillsEntity> skillsEntity;
	
	@OneToMany(targetEntity = LanguagesEntity.class , cascade = CascadeType.ALL , mappedBy = "personal" , fetch = FetchType.LAZY)
	private List<LanguagesEntity> languagesEntities;
	
	@OneToMany(targetEntity = EducationDetails.class , cascade = CascadeType.ALL , mappedBy = "person" , fetch = FetchType.LAZY)
	private List<EducationDetails> educationDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}

	public List<SkillsEntity> getSkillsEntity() {
		return skillsEntity;
	}

	public void setSkillsEntity(List<SkillsEntity> skillsEntity) {
		this.skillsEntity = skillsEntity;
	}
	

	public List<LanguagesEntity> getLanguagesEntities() {
		return languagesEntities;
	}

	public void setLanguagesEntities(List<LanguagesEntity> languagesEntities) {
		this.languagesEntities = languagesEntities;
	}

	public List<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(List<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public PersonalEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
		
}
