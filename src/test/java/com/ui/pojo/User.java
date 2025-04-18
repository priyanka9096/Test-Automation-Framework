package com.ui.pojo;

public class User {
	private String emailAddres;
	private String password;
	

	public User(String emailAddres, String password) {
		super();
		this.emailAddres = emailAddres;
		this.password = password;
	}

	public String getEmailAddres() {
		return emailAddres;
	}

	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [emailAddres=" + emailAddres + ", password=" + password + "]";
	}
	
	

}
