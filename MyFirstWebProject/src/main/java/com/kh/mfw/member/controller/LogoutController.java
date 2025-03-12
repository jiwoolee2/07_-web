package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public LogoutController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Session 로그인 방식에서의 로그아웃이란?
		// Sessiong에서 loginMember의 value를 지우면 된다.		
		request.getSession().removeAttribute("loginMember");
		//request.getSession().invalidate(); // -> 무효화 시킴 (Session안에 들어있는거 싹 다 날림)
		
		// 기본 페이지로 이동 (172.0.0.1/mfw/) => request.getContextPath() 
		// 위에서 Session에서 loginMember의 value를 지움 -> 
		response.sendRedirect(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
