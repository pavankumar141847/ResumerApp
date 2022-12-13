package org.ResumerApp.api.Login;

import org.ResumerApp.api.Register.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<RegisterEntity, Long>{

}
