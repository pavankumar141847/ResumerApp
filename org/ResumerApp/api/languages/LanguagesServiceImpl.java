package org.ResumerApp.api.languages;


import java.util.List;
import java.util.Optional;

import org.ResumerApp.api.PersonalDetails.PersonalDetailsRepo;
import org.ResumerApp.api.PersonalDetails.PersonalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguagesServiceImpl implements LanguagesService{

	@Autowired
	private LanguagesRepo languagesRepo;
	
	@Autowired
	private PersonalDetailsRepo personalRepo;
	
	@Override
	public boolean SaveLanguages(LanguagesEntity languagesEntity) {
		LanguagesEntity languages= new LanguagesEntity();
		long count = 0;
		if(languagesRepo.findByLanguage(languagesEntity.getLanguage())!=null)
		{
			if(languagesRepo.findByLanguage(languagesEntity.getLanguage()).getPersonal().getId() == personalRepo.findById(languagesEntity.getPersonal().getId()).get().getId())
			{
				count++;
			}
			if(count<1)
			{
				languages.setLanguage(languagesEntity.getLanguage());
				languages.setPersonal(languagesEntity.getPersonal());
				languagesRepo.save(languages);
				return true;
			}
		}
		else {
			languages.setLanguage(languagesEntity.getLanguage());
			languages.setPersonal(languagesEntity.getPersonal());
			languagesRepo.save(languages);
			return true;
		}
		return false;
	}
	
	public Optional<LanguagesEntity> getLanguages(PersonalEntity personalEntity)
	{
		if(personalRepo.findById(personalEntity.getId()) != null)
		{
			
		}
		return null;
	}
}
