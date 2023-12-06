package com.rays.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.OrsResponse;
import com.rays.dao.UserDaoInt;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UsersServiceImpl<T extends UserDTO, D extends UserDaoInt> implements UserServiceInt {

	@Autowired
	D userdao;

	@Override
	@Transactional(readOnly = false)
	public UserDTO register(UserDTO dto) {

		userdao.add(dto);
		return dto;
	}

	@Override
	public long add(UserDTO dto) {

		return userdao.addt(dto);
	}

	@Override
	public void update(UserDTO dto) {
		userdao.update(dto);

	}

	@Override
	public UserDTO findById(long pk) {

		return userdao.finbByPk(pk);
	}

	@Override
	public UserDTO delete(long id) {
		OrsResponse ors = new OrsResponse();

		UserDTO dto = findById(id);

		if (dto == null) {
			ors.addMessage("user is not found userservie");

		} else {
			userdao.delete(dto);
			ors.addMessage("user has been deleted userservie");
		}
		return dto;

	}

	@Override
	// @Transactional(readOnly = true)
	public UserDTO findByLoginId(String loginid) {

		return userdao.findByUniqueKey("loginId", loginid);
	}

	@Override
	public List search(UserDTO dto) {

		return userdao.search(dto);
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		UserDTO dto = findByLoginId(login);
		
		if (dto!=null) {
			if (password.equals(dto.getPassword())) {
				return dto;
				
			}
			
		}
		return null;
	}

}
