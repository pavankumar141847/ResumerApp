package org.ResumerApp.api.Work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	public ResponseEntity<Boolean> saveWork(@RequestBody WorkEntity workEntity)
	{
		return new ResponseEntity<Boolean>(workService.SaveWork(workEntity),HttpStatus.OK);
	}
}
