package org.ResumerApp.api.Skills;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;

@Entity
public class SkillsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String skill;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PersonalEntity person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public PersonalEntity getPerson() {
		return person;
	}

	public void setPerson(PersonalEntity person) {
		this.person = person;
	}

	public SkillsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
