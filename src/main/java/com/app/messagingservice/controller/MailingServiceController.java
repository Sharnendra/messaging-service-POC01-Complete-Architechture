package com.app.messagingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.app.messagingservice.modal.UserDetails;
import com.app.messagingservice.service.MailingService;
import com.app.messagingservice.service.UserService;

@Controller
public class MailingServiceController {

	@Autowired
	private MailingService mailingService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/sendMail")
    public String sendMail(@RequestHeader(value="username") String username) {
		mailingService.sendMail(getUserDetails(username).getEmailId());
        return "Success";
    }
	
	private UserDetails getUserDetails(String username)
	{
		return userService.getUserDetails(username);
	}
	
}
