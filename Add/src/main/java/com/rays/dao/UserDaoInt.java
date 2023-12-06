package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDaoInt <D extends UserDTO> {
	
	public long add(UserDTO dto);
	
	public long addt(UserDTO dto);
	
	public void update (UserDTO dto);
	
	public UserDTO finbByPk(long pk);
	
	public void delete(UserDTO id);
	
	public UserDTO findByUniqueKey(String attribute,Object value);
	
	public List search(UserDTO dto);

	

}
