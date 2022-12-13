package org.ResumerApp.api.Education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService{

	@Autowired
	private EducationRepo educationRepo;

	@Override
	public boolean saveEducation(EducationDetails educationDetails) {
		EducationDetails eduDetails = new EducationDetails();
		if(educationDetails!=null )
		{
			eduDetails.setDegree(educationDetails.getDegree());
			eduDetails.setYears(educationDetails.getYears());
			eduDetails.setStream(educationDetails.getStream());
			eduDetails.setPerson(educationDetails.getPerson());
			educationRepo.save(eduDetails);
			return true;
		}
		return false;
	}
	
}
