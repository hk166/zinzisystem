package com.example.zinzisystem.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.zinzisystem.common.Option;

@Mapper
public interface CodeRepository {
	
	public List<Option> getDepertmentCd();
	
	public List<Option> getPositionCd();

}
