package org.ResumerApp.api.Work;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepo extends JpaRepository<WorkEntity, Long>{

}
