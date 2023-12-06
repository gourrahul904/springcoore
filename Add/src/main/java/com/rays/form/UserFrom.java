package com.rays.form;

import javax.validation.constraints.NotEmpty;

public class UserFrom {
	
	@NotEmpty(message = "FirstName Is Required")
	private String firstName;

	@NotEmpty(message = "LastName Is Required")
	private String lastName;

	@NotEmpty(message = "Loginid Is Required")
	private String loginId;
	
	@NotEmpty(message = "Password Is Required")
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

	public String getPassword() {
		return password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
