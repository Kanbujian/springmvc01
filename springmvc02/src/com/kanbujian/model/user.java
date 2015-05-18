package com.kanbujian.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;



public class user {
      String username;
      String password;
      String email;
    
  	public user() {
		
  	}  
    @NotEmpty(message="Please input usename !")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Size(min=5,max=20,message="密码必须超过5个字符")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Email(message="Email information has wrong!")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public user(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
      
}
