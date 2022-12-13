package org.ResumerApp.api.Register;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class RegisterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Email is Required")
	@Email(message = "invalid email")
	private String email;
	
	@NotNull(message = "FirstName is required")
	private String firstName;
	
	@NotNull(message = "password is required")
	private String password;
	
	@NotNull(message = "confirm password is required")
	private String confirm;
	
	private boolean isEnabled;
	
	private String verificationToken;
	
	private LocalDateTime date;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public String getVerificationToken() {
		return verificationToken;
	}
	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime localDateTime) {
		this.date = localDateTime;
	}
	public RegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
