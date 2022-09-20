package com.example.zinzisystem.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.zinzisystem.auth.AuthenticatedUser;
import com.example.zinzisystem.auth.User;
import com.example.zinzisystem.form.UserSearchForm;

@Mapper
public interface UserRepository {
	
	public AuthenticatedUser getUser(String username);
	
	public int registrationUser(User user);
	
	public int registrationAuthorities(User user);
	
	public List<AuthenticatedUser> loadUserList(UserSearchForm from);

}
