package com.kh.ins.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.ins.common.Template.getSqlSession;
import com.kh.ins.member.model.dao.UserDAO;
import com.kh.ins.member.model.dto.UserDTO;

public class UserService {

	public UserDTO login(UserDTO user) {
		
		SqlSession sqlSession = getSqlSession();
		UserDTO loginUser = new UserDAO().login(sqlSession,user);
		
		sqlSession.close();
		return loginUser;
	}
	
	public void signUp(UserDTO user) {
		
		new UserDAO().signUp(user);
		
	}
}
