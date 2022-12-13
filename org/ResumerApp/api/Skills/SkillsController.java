package org.ResumerApp.api.Skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillsController 
{
	@Autowired
	private SkillsService skillsService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/skills")
	public ResponseEntity<Boolean> saveSkills(@RequestBody SkillsEntity skillsEntity)
	{
		return new ResponseEntity<Boolean>(skillsService.saveSkills(skillsEntity),HttpStatus.OK);
	}
}
