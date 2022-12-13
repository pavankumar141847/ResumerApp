package org.ResumerApp.api.Register;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

public interface RegisterService{
	String registerUser(RegisterEntity registerEntity , String siteURL) throws UnsupportedEncodingException, MessagingException;
	String SendVerificationCode(RegisterEntity registerEntity , String siteURL) throws UnsupportedEncodingException, MessagingException;
	String VerifyUser(String code , String siteUrl) throws UnsupportedEncodingException, MessagingException;
	boolean reSendcode(String code , String siteURL) throws UnsupportedEncodingException, MessagingException;
	long timeDifference(LocalDateTime localDateTime);
}
