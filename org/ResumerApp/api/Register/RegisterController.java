package org.ResumerApp.api.Register;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/api/v1/signup")
	public ResponseEntity<String> saveUser(@RequestBody @Valid RegisterEntity registerEntity , HttpServletRequest request) throws UnsupportedEncodingException, MessagingException
	{
		return new ResponseEntity<>(registerService.registerUser(registerEntity , getSiteUrl(request)),HttpStatus.CREATED);	
	}
	
	@GetMapping("/verify")
	public ResponseEntity<String> verifyUser(@Param("code") String code , HttpServletRequest request) throws UnsupportedEncodingException, MessagingException
	{
		if(registerService.VerifyUser(code, getSiteUrl(request)).equals("Your Email is successfully Verified."))
		{
			return new ResponseEntity<>("successful",HttpStatus.ACCEPTED);
		}
		else if(registerService.VerifyUser(code, getSiteUrl(request)).equals("Email is not registered"))
		{
			return new ResponseEntity<>("Email not registered",HttpStatus.FORBIDDEN);
		}
		else
		{
			return new ResponseEntity<>("verification link sent again",HttpStatus.FORBIDDEN);
		}
	}	
	
	private String getSiteUrl(HttpServletRequest request)
	{
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}
}
