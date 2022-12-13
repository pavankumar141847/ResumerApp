package org.ResumerApp.api.ProfileImage;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;


@Entity
public class ProfileImageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String type;
	
	@Lob
	private byte[] imageData;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	private PersonalEntity person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public PersonalEntity getPerson() {
		return person;
	}

	public void setPerson(PersonalEntity person) {
		this.person = person;
	}

	public ProfileImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
