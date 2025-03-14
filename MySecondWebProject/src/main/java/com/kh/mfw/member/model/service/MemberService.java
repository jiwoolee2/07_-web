package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Template.getSqlSession;  
import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		/* JDBCUtil 클래스로부터
		 * static Method로 구현해놓은
		 * getConnection 메서드를 호출하여
		 * Connection 객체를 반환받읍...
		 */
		// Connection 객체 역할을 하는객체를 얻어옴
		// Connection 객체를 생성할 때마다 Template.getSqlSession()을 해야하기 번거로워서 
		// import 할 때 static과 메서드명 getSqlSession을 추가해서 
		// 그냥 getSqlSession()을 바로 쓸 수 있게 함.
		SqlSession sqlSession = getSqlSession();
		
		// 유효성 검증은 패스(원래 해야함)
		MemberDTO loginMember = new MemberDAO().login(sqlSession, member);
		
		// 자원반납
		sqlSession.close();
		
		return loginMember;
	}
	
	
	// 의사 결정 코드
	public int signUp(MemberDTO member) {
		// 3차 유효성 검증 (java)
		// 4차 데이터무결성을 위한 제약조건 (DBMS)
		// 아이디 중복검사
		
		SqlSession sqlSession = getSqlSession();
		//boolean result = new MemberDAO().checkId(sqlSession,member.getMemberId());
		
		if(new MemberDAO().checkId(sqlSession,member.getMemberId())) {
			sqlSession.close();
			return 0;
		}
		
		int result = new MemberDAO().signUp(sqlSession,member);
		sqlSession.commit();
		sqlSession.close();
		
		return result;
	}
	
	
	
}
