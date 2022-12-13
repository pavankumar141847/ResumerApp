package org.ResumerApp.api.languages;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;

@Entity
public class LanguagesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private  String language;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PersonalEntity personal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public PersonalEntity getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalEntity personal) {
		this.personal = personal;
	}

	public LanguagesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
