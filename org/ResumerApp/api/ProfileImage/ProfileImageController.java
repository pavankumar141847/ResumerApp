package org.ResumerApp.api.ProfileImage;

import java.io.IOException;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProfileImageController {
	
	@Autowired
	private ProfileImageService profileImageService;
	
	@CrossOrigin(origins = "*")
	@PostMapping("api/v1/Image")
	public ResponseEntity<String> UploadImage(@RequestParam("Image") MultipartFile file) throws IOException
	{
		return new ResponseEntity<>(profileImageService.uploadImage(file),HttpStatus.OK);
	}
}
