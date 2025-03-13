package com.kh.mfw.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

import oracle.jdbc.internal.OracleConnection.XSSessionSetOperationCode;


@WebServlet("/md")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModifyController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		
		// Session에 담긴 loginMember객체 그대로 가져오기  
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		System.out.println();
		
		// 정보수정페이지에서 바꾼 정보를 member에 담기
		String memberName  = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		member.setMemberName(memberName);
		member.setEmail(memberEmail);
		
		new MemberService().modify(member);
		
		response.sendRedirect(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
