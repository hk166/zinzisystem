package com.example.zinzisystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.zinzisystem.auth.User;
import com.example.zinzisystem.repository.UserRepository;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userrepository;
	
	@Transactional
	public void register(User user) {
		int resurt = 0;
		
		resurt += userrepository.registrationUser(user);
		resurt += userrepository.registrationAuthorities(user);
		
		if (resurt != 2) {
			
			throw new RuntimeException();
			
		}
		
		
		
	}

}
