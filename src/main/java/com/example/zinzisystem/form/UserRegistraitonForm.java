package com.example.zinzisystem.form;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistraitonForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String username;
	
	@Size(max = 128)
	@Email
	private String email;
	
	@Size(max = 128)
	@Email
	private String emailconfirm;
	
	@Size(min = 8, max = 20)
	private String password;
	
	@Size(min = 8, max = 20)
	private String passwordconfirm;
	
	@AssertTrue
	public boolean isEmailconfirmed() {
		
		if (email == null && emailconfirm == null) {
			return true;
			
		}
		
		return email.equals(emailconfirm);
	}
	
	@AssertTrue
	private boolean isPasswordconfirmed() {
		
		if (password == null && passwordconfirm == null) {
			return true;
			
		}
		
		return password.equals(passwordconfirm);

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailconfirm() {
		return emailconfirm;
	}

	public void setEmailconfirm(String emailconfirm) {
		this.emailconfirm = emailconfirm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordconfirm() {
		return passwordconfirm;
	}

	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}
	
	

}
