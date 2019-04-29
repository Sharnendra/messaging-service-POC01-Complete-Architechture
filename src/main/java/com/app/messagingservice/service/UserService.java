package com.app.messagingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.messagingservice.modal.UserDetails;
import com.app.messagingservice.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void insertUser(UserDetails userDetails)
	{
		userRepository.save(userDetails);
	}
	
	public UserDetails getUserDetails(String username)
	{
		return userRepository.findUserByName(username);
	}

}
