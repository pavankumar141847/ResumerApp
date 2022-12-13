package org.ResumerApp.api.Register;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.tree.AbstractLayoutCache;

import org.apache.naming.java.javaURLContextFactory;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.oauth2.sdk.util.date.SimpleDate;

import net.bytebuddy.utility.RandomString;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	@Override
	public String registerUser(RegisterEntity registerEntity , String siteUrl) throws UnsupportedEncodingException, MessagingException {
		RegisterEntity register = new RegisterEntity();
		register.setEmail(registerEntity.getEmail());
		register.setFirstName(registerEntity.getFirstName());
		String encodedPassword = passwordEncoder.encode(registerEntity.getPassword());
	    registerEntity.setPassword(encodedPassword);
	    register.setPassword(registerEntity.getPassword());
		String randomCode = RandomString.make(64);
		registerEntity.setVerificationToken(randomCode);
		register.setVerificationToken(registerEntity.getVerificationToken());
		LocalDateTime localDateTime = LocalDateTime.now();
		registerEntity.setDate(localDateTime);
		register.setDate(registerEntity.getDate());
		registerEntity.setEnabled(true);
		register.setEnabled(registerEntity.isEnabled());
		if(registerRepository.findByEmail(registerEntity.getEmail())==null)
		{
			if(passwordEncoder.matches(registerEntity.getConfirm(), register.getPassword()))
			{
				encodedPassword = passwordEncoder.encode(registerEntity.getConfirm());
			    registerEntity.setConfirm(encodedPassword);
			    register.setConfirm(registerEntity.getConfirm());
				SendVerificationCode(register, siteUrl);
				registerRepository.save(registerEntity);
				return "success";
			}
			else
			{
				return "password doesn't match";
			}
		}
		return "Email already exists";
	}

	@Override
	public String SendVerificationCode(RegisterEntity registerEntity, String siteURL) throws UnsupportedEncodingException, MessagingException {
		
		String toAddress = registerEntity.getEmail();
		String fromAddress = "pavankumar141847@gmail.com";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>"
		            + "Please click the link below to verify your registration:<br>"
		            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
		            + "Thank you,<br>"
		            + "Pavan";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(fromAddress , "Resumer");
		helper.setTo(toAddress);
		helper.setSubject(subject);
		content = content.replace("[[name]]", registerEntity.getFirstName());
		String verifyUrl = siteURL + "/verify?code=" + registerEntity.getVerificationToken();
		content = content.replace("[[URL]]", verifyUrl);
		helper.setText(content , true);
		mailSender.send(message);
		return "Mail sent";
	}

	@Override
	public String VerifyUser(String code , String siteUrl) throws UnsupportedEncodingException, MessagingException {
		RegisterEntity register = new RegisterEntity();
		register =	registerRepository.findByVerificationToken(code);
		long val = timeDifference(register.getDate());
		if(register.isEnabled()==true && val<=3)
		{
			if(registerRepository.findByVerificationToken(code)==null)
			{
				return "Email is not registered";
			}
			else
			{
				register.setEnabled(false);
				registerRepository.save(register);
				return "Your Email is successfully Verified.";
			}
		}
		else
		{
			reSendcode(code , siteUrl);
			return "your Verification link is expired, we have sent you the link again to your mail, please check and confirm";
		}
		
	}

	@Override
	public boolean reSendcode(String code, String siteUrl) throws UnsupportedEncodingException, MessagingException {
		RegisterEntity register = new RegisterEntity();
		register =	registerRepository.findByVerificationToken(code);
		if(timeDifference(register.getDate())>1 && (register.isEnabled() == true))
		{
			LocalDateTime localDateTime = LocalDateTime.now();
			register.setDate(localDateTime);
			String random = RandomString.make(64);
			register.setVerificationToken(random);
			SendVerificationCode(register, siteUrl);
			registerRepository.save(register);
			return true;
		}
		return false;
	}
	
	@Override
	public long timeDifference(LocalDateTime localDateTime)
	{
		return ChronoUnit.MINUTES.between(localDateTime,LocalDateTime.now());	
	}

}

