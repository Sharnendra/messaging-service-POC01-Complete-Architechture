package com.app.messagingservice.service;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messagingservice.config.MessagingConfig;

@Service
public class MessagingService {
	
	@Autowired
	private MessagingConfig smsConfig;
	
	public String sendSMSOnPhone(String phonenumber) {
		try {
			// Send data
			return "http://api.textlocal.in/send/?" 
			+ "apikey=" + URLEncoder.encode(smsConfig.getApiKey(), "UTF-8") 
			+ "&numbers=" + URLEncoder.encode(phonenumber, "UTF-8") 
			+ "&message=" + URLEncoder.encode(smsConfig.getMessage(), "UTF-8");
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	

}
