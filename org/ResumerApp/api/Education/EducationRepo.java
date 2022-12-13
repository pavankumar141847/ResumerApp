package org.ResumerApp.api.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepo extends JpaRepository<EducationDetails, Long>{

	EducationDetails findByDegree(String degree);
}
