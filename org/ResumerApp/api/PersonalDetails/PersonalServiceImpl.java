package org.ResumerApp.api.PersonalDetails;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalDetailsService{

	
	@Autowired
	private PersonalDetailsRepo personalDetailsRepo;
	
	
	@Override
	public String savePersonalData(PersonalEntity personalEntity) {
		PersonalEntity personObject = new PersonalEntity();
		if(personalEntity!=null)
		{
			personObject.setEmail(personalEntity.getEmail());
			personObject.setPhoneNumber(personalEntity.getPhoneNumber());
			personObject.setName(personalEntity.getName());
			personObject.setLocation(personalEntity.getLocation());
			personObject.setLinkedIn(personalEntity.getLinkedIn());
			personObject.setAbout(personalEntity.getAbout());
			personalDetailsRepo.save(personObject);
			return "success";
		}
		return "Please fill the values";
	}
	
	@Override
	public String getPersonalDetails(Long id)
	{
		return personalDetailsRepo.findById(id).get().getEmail();
	}

}
