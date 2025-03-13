package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;


@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignUpController() {
        super();
  
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 설정 (POST 방식일 경우)
		request.setCharacterEncoding("UTF-8");
		
		// 요청처리 -> 사용자가 입력한 값들을 저 멀리있는 DB서버의 KH_MEMBER 테이블에 한 행 insert
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO(memberId,memberPw,memberName,email,null);
		int result = new MemberService().signUp(member);
		
		String path = request.getContextPath();
		
		/*
		 * if(result != 0) { // 실패했을 경우 => 회원가입 페이지로 이동 //
		 * request.getRequestDispatcher("/WEB-INF/views/member/enroll_form.jsp") //
		 * response.sendRedirect(request.getContextPath()+"/join"); // 유지보수 용이해짐
		 * 
		 * } else { // 성공했을 경우 => 웰컴페이지로 이동 //
		 * response.sendRedirect(request.getContextPath());
		 * 
		 * }
		 */
		
		
		response.sendRedirect(result !=0 ? path+ "/join" : path);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
