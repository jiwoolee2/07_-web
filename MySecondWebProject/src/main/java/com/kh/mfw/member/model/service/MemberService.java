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
		return null;
	}
}
