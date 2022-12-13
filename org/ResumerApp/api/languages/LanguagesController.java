package org.ResumerApp.api.languages;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

	@Autowired
	private LanguagesService languageService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/languages")
	public ResponseEntity<Boolean> SaveLanguage(@RequestBody LanguagesEntity languagesEntity)
	{
		return new ResponseEntity<Boolean>(languageService.SaveLanguages(languagesEntity),HttpStatus.OK);
	}
}
