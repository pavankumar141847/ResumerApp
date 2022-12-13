package org.ResumerApp.api.Education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {

	
	@Autowired
	private EducationService educationService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/education")
	public ResponseEntity<Boolean> saveEducation(@RequestBody EducationDetails educationDetails)
	{
		return new ResponseEntity<Boolean>(educationService.saveEducation(educationDetails),HttpStatus.OK);
	}
}
