package com.kh.ins.member.model.service;

import com.kh.ins.member.model.dao.UserDAO;
import com.kh.ins.member.model.dto.UserDTO;

public class UserService {

	public UserDTO login(UserDTO user) {
		
		UserDTO loginUser = new UserDAO().login(user);
		return loginUser;
	}
	
	public void signUp(UserDTO user) {
		
		new UserDAO().signUp(user);
		
	}
}
