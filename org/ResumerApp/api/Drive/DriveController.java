package org.ResumerApp.api.Drive;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientId;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import antlr.Token;

import java.security.Principal;
import java.util.Arrays;
 
import javax.servlet.http.HttpServletRequest;



@RestController
public class DriveController {

	@Autowired
	upload upload;
	
	@Autowired
	OAuth2AuthorizedClientService clientService;
	
	@GetMapping("/api/v1/upload")
	public String getToken()
    {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String accessToken = null;
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
		String ClientRegId = oauthToken.getAuthorizedClientRegistrationId();
		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(ClientRegId, oauthToken.getName());
		accessToken = client.getAccessToken().getTokenValue();
		String refreshToken = client.getRefreshToken().getTokenValue();
		System.out.println("access Token - " + accessToken);
		System.out.println("refresh Token - " + refreshToken);
		//OAuth2AuthorizedClient auth2AuthorizedClient = new OAuth2AuthorizedClient(null, null, null);
		//RestTemplate restTemplate = new RestTemplate();
		upload.uploadDoc(accessToken);
		

		return accessToken;
	}
	
}
