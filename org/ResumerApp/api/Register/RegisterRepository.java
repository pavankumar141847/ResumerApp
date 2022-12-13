package org.ResumerApp.api.Register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Long>{
	RegisterEntity findByEmail(String email);
	RegisterEntity findByVerificationToken(String token);
}
