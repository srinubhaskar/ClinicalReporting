package com.vijayadurga.clinic.vo;

import java.io.Serializable;

public class UserAuthVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1364722309932989172L;
	public UserAuthVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String gender;
	private ContactVO contact;
	
	
	
	
	public UserAuthVO(String username, String password, String firstname, String lastname, String gender,
			ContactVO contact) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.contact = contact;
	}
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ContactVO getContact() {
		return contact;
	}
	public void setContact(ContactVO contact) {
		this.contact = contact;
	}

}
