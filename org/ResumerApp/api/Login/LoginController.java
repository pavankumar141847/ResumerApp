package org.ResumerApp.api.Login;

import org.ResumerApp.api.Register.RegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.Payload.Origin;

@RestController
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/login")
	public ResponseEntity<String> Login(@RequestBody RegisterEntity registerEntity)
	{
		return new ResponseEntity<>(loginService.Login(registerEntity),HttpStatus.ACCEPTED);
	}
}

