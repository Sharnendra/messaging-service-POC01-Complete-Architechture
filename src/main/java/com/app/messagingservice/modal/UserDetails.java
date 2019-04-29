package com.app.messagingservice.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id; 
	private String name;
	private String phoneNumber;
	private String phoneOTP;
	private String emailId;
	private String emailOTP;
	
	public String getPhoneOTP() {
		return phoneOTP;
	}
	public void setPhoneOTP(String phoneOTP) {
		this.phoneOTP = phoneOTP;
	}
	public String getEmailOTP() {
		return emailOTP;
	}
	public void setEmailOTP(String emailOTP) {
		this.emailOTP = emailOTP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
