package org.ResumerApp.api.word;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestController
public class wordController {

	@Autowired
	private helper helper;
	
	@GetMapping(value = "/word", 
            produces = "application/vnd.openxmlformats-"
                    + "officedocument.wordprocessingml.document")
	public ResponseEntity<InputStreamResource> word() throws IOException, InvalidFormatException
	{
		ByteArrayInputStream bis = helper.generateWord();
		return ResponseEntity.ok().body(new InputStreamResource(bis));
	}
	
}
