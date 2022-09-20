package com.example.zinzisystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.zinzisystem.auth.AuthenticatedUser;
import com.example.zinzisystem.auth.User;
import com.example.zinzisystem.form.UserRegistraitonForm;
import com.example.zinzisystem.form.UserSearchForm;
import com.example.zinzisystem.service.UserRegistrationService;
import com.example.zinzisystem.service.UserSearchService;

@Controller
public class KanriController {
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
	private PasswordEncoder psswordEncoder;
	
	@Autowired
	private UserSearchService userSearchService;
	
	@GetMapping("/syaintouroku")
	public String syaintouroku(Model model) {
		
		model.addAttribute("userRegistraitonForm", new UserRegistraitonForm());
		
		return "syaintouroku";
	}
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute UserRegistraitonForm form,
			                BindingResult bindingResult,
			                Model model) {
		
		if (bindingResult.hasErrors()) {
			return "syaintouroku";
			
		}
		
		User user = new User();
		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPassword(psswordEncoder.encode(form.getPassword()));
		
		userRegistrationService.register(user);
		
		return "syaintouroku";
	}
	
	@GetMapping("/kanri/syainitiran")
	public String syainitiran(Model model) {
		
		model.addAttribute("userSearchForm", userSearchService.initializeForm());
		
		return "syainitiran";
		
	}
	
	
	@GetMapping("/kanri/userSerach")
	public String SearchUserList(@ModelAttribute UserSearchForm form, Model model) {
		
		List<AuthenticatedUser> userlist = userSearchService.loadUserList(form);
		model.addAttribute("userlist", userlist);
		model.addAttribute("userSearchForm", form);
		
		return "syainitiran";
		
		
		
	}
	
	
	
	
	
	
	

}
