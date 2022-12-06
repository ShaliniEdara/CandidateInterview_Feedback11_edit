package com.anil.example.springboot.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Admin {
	@Id
	
    @Column(name = "username")
	private String username;
	
	
    @Column(name = "password")
	private String password;
	
	
	
//	public Admin() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public Admin(String username, String password) {
//		super();
//		this.username = username;
//		this.password = password;
//	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		byte[] pass = Base64.getDecoder().decode(password);
		String pass1 = new String(pass);
		return pass1;
	}
	public void setPassword(String password) {
		String pass = Base64.getEncoder().encodeToString(password.getBytes());
		this.password = pass;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
}
