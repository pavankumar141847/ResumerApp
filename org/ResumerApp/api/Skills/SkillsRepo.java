package org.ResumerApp.api.Skills;

import org.ResumerApp.api.PersonalDetails.PersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepo extends JpaRepository<SkillsEntity, Long>{

	SkillsEntity findBySkill(String skill);
}
