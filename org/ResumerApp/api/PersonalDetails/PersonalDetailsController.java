package org.ResumerApp.api.PersonalDetails;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalDetailsController {

	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/PersonalDetails")
	public ResponseEntity<String> SavePersonalData(@RequestBody @Valid PersonalEntity personalEntity)
	{
		return new ResponseEntity<>(personalDetailsService.savePersonalData(personalEntity),HttpStatus.OK);
	}	
}
