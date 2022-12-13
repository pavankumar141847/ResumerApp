package org.ResumerApp.api.ProfileImage;

import java.io.IOException;

import javax.mail.Multipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileImageServiceImpl implements ProfileImageService{

	@Autowired
	private ProfileImageRepo profileImageRepo;
	
	
	@Override
	public String uploadImage(MultipartFile file) throws IOException {
		if(!file.isEmpty())
		{
			ProfileImageEntity image = new ProfileImageEntity();
			image.setName(file.getOriginalFilename());
			image.setType(file.getContentType());
			image.setImageData(file.getBytes());
			profileImageRepo.save(image);
			return "success";
		}
		return "failure";
	}

}
