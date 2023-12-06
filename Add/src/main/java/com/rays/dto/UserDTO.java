package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "st_user")
public class UserDTO {
	

	@Id
	@GeneratedValue(generator = "npk")
	@GenericGenerator(name = "npk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	

	public long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "FIRSTNAME", length = 50)
	private String firstName;

	@Column(name = "LASTNAME", length = 50)
	private String lastName;

	@Column(name = "loginId", length = 50)
	private String loginId;

	@Column(name = "password", length = 50)
		private String password;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
