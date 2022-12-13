package org.ResumerApp.api.PersonalDetails;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalEntity, Long>{

}
