package org.ResumerApp.api.ProfileImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepo extends JpaRepository<ProfileImageEntity, Long>{

}
