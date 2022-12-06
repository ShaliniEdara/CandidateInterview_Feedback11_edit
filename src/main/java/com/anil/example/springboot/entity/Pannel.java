package com.anil.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Pannel {
	
	
	
	@Id
	@NotBlank(message = "Username is mandatory")
    @Column(name = "username")
	private String username;
	
	 @NotBlank(message = "password is mandatory")
	 @Column(name = "password")
	 private String password;
	 
	 @NotBlank(message = "pannel is mandatory")
	 @Column(name = "pannel")
	 private String pannel;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPannel() {
		return pannel;
	}
	public void setPannel(String pannel) {
		this.pannel = pannel;
	}
	
	
	@Override
	public String toString() {
		return "Pannel [ username=" + username + ", password=" + password + ", pannel=" + pannel + "]";
	}
	
	
	
	}
	

