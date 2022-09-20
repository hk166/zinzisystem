package com.example.zinzisystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zinzisystem.auth.AuthenticatedUser;
import com.example.zinzisystem.form.UserSearchForm;
import com.example.zinzisystem.repository.CodeRepository;
import com.example.zinzisystem.repository.UserRepository;

@Service
public class UserSearchService {
	
	@Autowired
	private CodeRepository codeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public UserSearchForm initializeForm() {
		
		UserSearchForm form = new UserSearchForm();
		
		form.setDeptOptions(codeRepository.getDepertmentCd());
		form.setPosOptions(codeRepository.getPositionCd());
		
		return form;
		
	}
	
	
	public List<AuthenticatedUser> loadUserList(UserSearchForm form) {
		
		form.setDeptOptions(codeRepository.getDepertmentCd());
		form.setPosOptions(codeRepository.getPositionCd());
		
		return userRepository.loadUserList(form);
		
	}

}
