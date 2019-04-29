package com.app.messagingservice.request;

public class UserDetailsInfo {

	@Override
	public String toString() {
		return "UserDetailsInfo [name=" + name + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	private String name;
	private String phoneNumber;
	private String emailId;
	
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
