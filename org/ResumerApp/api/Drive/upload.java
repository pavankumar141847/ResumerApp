package org.ResumerApp.api.Drive;

import java.net.URI;

import javax.mail.internet.MimeBodyPart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.nimbusds.common.contenttype.ContentType;

@Component
public class upload {
	
	public void uploadDoc(String token)
	{
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+ token);
		headers.setContentType(MediaType.TEXT_PLAIN);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		String resourceUrl = "https://www.googleapis.com/upload/drive/v3/files?uploadType=media";
		String request = "C:\\Users\\Word";
		
		ResponseEntity<String> response = restTemplate.exchange(resourceUrl, HttpMethod.POST, requestEntity, String.class);
		}
}
