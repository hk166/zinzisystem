package com.example.zinzisystem.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.zinzisystem.auth.AuthenticatedUser;

@Mapper
public interface UserRepository {
	
	public AuthenticatedUser getUser(String username);

}
