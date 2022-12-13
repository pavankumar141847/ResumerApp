package org.ResumerApp.api.Skills;

import org.ResumerApp.api.PersonalDetails.PersonalDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillsServicesImpl implements SkillsService{

	@Autowired
	private SkillsRepo skillsRepo;
	
	@Autowired
	private PersonalDetailsRepo personalDetailsRepo;
	
	
	@Override
	public boolean saveSkills(SkillsEntity skillsEntity) {
		SkillsEntity skills = new SkillsEntity();
		long count = 0;
		if(skillsRepo.findBySkill(skillsEntity.getSkill())!=null)
		{
			if(skillsRepo.findBySkill(skillsEntity.getSkill()).getPerson().getId() == personalDetailsRepo.findById(skillsEntity.getPerson().getId()).get().getId())
			{
				count++;
			}
			if(count<1)
			{
				skills.setSkill(skillsEntity.getSkill());
				skills.setPerson(skillsEntity.getPerson());
				skillsRepo.save(skills);
				return true;
			}
		}
		else {
			skills.setSkill(skillsEntity.getSkill());
			skills.setPerson(skillsEntity.getPerson());
			skillsRepo.save(skills);
			return true;
		}
		
		return false;
	}

}
