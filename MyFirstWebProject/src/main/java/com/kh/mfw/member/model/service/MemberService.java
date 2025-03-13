package com.kh.mfw.member.model.service;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		/* 로그인을 하는건데 로그인은 DB에 가서 SELECT절에다가
		 * 사용자가 입력한 아이디 값과 비밀번호 값을 조건절을 사용해서 조회를 하는 절차를 의미
		 * 
		 * ID나 비밀번호가 틀려서 로그인에 실패할 수 있는 가능성이 있음
		 * 
		 * member.getMemberId().length() > 10이라면 
		 * member.getMemberId().equals("") 이라면
		 * 즉, 로그인이 성립할 수 없는 값이 입력되었다면
		 * DB에 갈 필요가 없는거 아님???
		 * 
		 * 따라서 DB에 갈 자격이 있는지 없는지를 검증하는 과정이 필요 (유효성 검사 = Validation)
		 * --> 이걸 Service에서 한다!!!!!!!!
		 */
		
		MemberDTO loginMember = new MemberDAO().login(member);
		return loginMember;
	}
	
	public int signUp(MemberDTO member) {
		
		// UNIQUE가 적용된 memberId 중복 검사
		
		int result = new MemberDAO().checkId(member.getMemberId());
		
		if(result > 0) {
			return result;
		} 
		
		new MemberDAO().signUp(member);
		return result;
	}
	
	
	
	
	public void modify(MemberDTO member) {
		
		new MemberDAO().modify(member);
	}
	
	
	
	
	public int newPassword(String memberId, String changePw , String userPw) {
		
		int result = new MemberDAO().newPassword(memberId,changePw,userPw);
		
		return result;
	}
	
	
	
	public int quit(String memberId, String memberPw,String inputPw) {
		
		int result = 0;
		
		if(memberPw.equals(inputPw)) {
			result = new MemberDAO().quit(memberId);
			return result;
		} else {
			return result;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}























