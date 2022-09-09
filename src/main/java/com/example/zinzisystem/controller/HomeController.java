package com.example.zinzisystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		return "home";
		
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/kanrigamen")
	public String kanri(){
		return "kanri";
	}
	
	
	@GetMapping("/syainitiran")
	public String syain(){
		return "syainitiran";
	}
	
	
	@GetMapping("/passwordhenko")
	public String passwordhenko(){
		return "passwordhenko";
	}
	
	
	
	

}
