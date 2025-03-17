package com.kh.ins.member.model.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;
import org.apache.ibatis.session.SqlSession;

import com.kh.ins.member.model.dto.UserDTO;

public class UserDAO {
	

	
	public UserDTO login(SqlSession sqlSession, UserDTO user) {
		
		return sqlSession.selectOne("userMapper.login",user);
	}
	
	
	
	public int checkId(SqlSession sqlSession, UserDTO user) {
		
		return (Integer)sqlSession.selectOne("userMapper.checkid",user);
	}
	
	
	public int signUp(SqlSession sqlSession, UserDTO user) {
		
		return sqlSession.insert("userMapper.signup",user);
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











































