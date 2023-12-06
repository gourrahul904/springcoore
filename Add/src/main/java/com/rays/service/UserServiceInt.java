package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public UserDTO register(UserDTO dto);

	// public UserDTO
	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public UserDTO findById(long pk);

	public UserDTO delete(long id);
	
	public UserDTO findByLoginId(String login);
	
	public List search(UserDTO dto);
	
	public UserDTO authenticate(String login,String password);
	
	

}
