package org.ResumerApp.api.ProfileImage;


import java.io.IOException;


import org.springframework.web.multipart.MultipartFile;

public interface ProfileImageService {
	String uploadImage(MultipartFile file) throws IOException;
}
