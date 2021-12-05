package com.onlinesweetshopapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotBlank(message = "userId is required")
	@Size(min = 5, max = 10 , message ="Size must be between 5 to 10 characters")
	@Column(unique = true,updatable = false)
	private String userId;
	@NotBlank(message = "userName is required")
	private String name;
	@NotBlank(message = "password is required")
	private String password;
	@NotBlank(message = "email is required")
	private String email;
	private int isloggedIn;
	public Admin() {
		super();
	
	}
	
	
	public Admin(
			@NotBlank(message = "userId is required") @Size(min = 5, max = 10, message = "Size must be between 5 to 10 characters") String userId,
			@NotBlank(message = "userName is required") String name,
			@NotBlank(message = "password is required") String password,
			@NotBlank(message = "email is required") String email) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsloggedIn() {
		return isloggedIn;
	}
	public void setIsloggedIn(int isloggedIn) {
		this.isloggedIn = isloggedIn;
	}
	
	

}
