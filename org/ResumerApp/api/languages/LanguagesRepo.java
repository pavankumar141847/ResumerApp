package org.ResumerApp.api.languages;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesRepo extends JpaRepository<LanguagesEntity, Long>{

	LanguagesEntity findByLanguage(String language);
}
