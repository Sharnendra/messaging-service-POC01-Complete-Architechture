package com.app.messagingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.app.messagingservice.modal.UserDetails;
import com.app.messagingservice.repository.OTP_intefarce;
import com.app.messagingservice.request.UserDetailsInfo;
import com.app.messagingservice.service.UserService;

@RestController
public class UserController implements OTP_intefarce{
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/inser-user",consumes = MediaType.APPLICATION_JSON_VALUE)
	String insertUser(@RequestBody UserDetailsInfo userDetailsInfo)
	{
		System.err.println(userDetailsInfo.getName());
		UserDetails userDetails=new UserDetails();
		userDetails.setName(userDetailsInfo.getName());
		userDetails.setEmailId(userDetailsInfo.getEmailId());
		userDetails.setEmailOTP(String.valueOf(getOpt()));
		userDetails.setPhoneNumber(userDetailsInfo.getPhoneNumber());
		userDetails.setPhoneOTP(String.valueOf(getOpt()));
		userService.insertUser(userDetails);
		return "Success";
	}
	
	@GetMapping("/get-user")
	UserDetails getUserDetails(@RequestHeader(value="username") String username)
	{
		return userService.getUserDetails(username);
	}

}
