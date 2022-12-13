package org.ResumerApp.api.PersonalDetails;

import java.util.Optional;

public interface PersonalDetailsService {
	
	
	String savePersonalData(PersonalEntity personalEntity);

	String getPersonalDetails(Long id);
}
