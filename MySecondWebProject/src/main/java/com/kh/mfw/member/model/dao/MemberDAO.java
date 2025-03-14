package com.kh.mfw.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {
	

	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		
		
		// SqlSession이 제공하는 메서드를 통해 SQL문을 찾아서 실행하고 결과를 받을 수 있음
		// sqlSession.sql문 종류에 맞는 메서드("mapper파일의 namespace.SQL문의id속성값)
		return sqlSession.selectOne("memberMapper.login", member);
		
		// 조회 결과가 있으면 MemberDTO반환 , 없으면  null값 반환
	}
	
	
	
	public boolean checkId(SqlSession sqlSession, String memberId) {
		/*
		 * int result = sqlSession.selectOne("memberMapper.checkId",memberId);
		 * 
		 * if(result>0) { return true; } else { return false; }
		 */
		
		return (Integer)sqlSession.selectOne("memberMapper.checkId",memberId)>0 ? true : false;	
	}
	

	
	
	public int signUp(SqlSession sqlSession,MemberDTO member) {
		
		return sqlSession.insert("memberMapper.signUp",member);
	}
	
}