package com.kh.ins.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.ins.member.model.dto.UserDTO;
import com.kh.ins.member.model.service.UserService;


@WebServlet("/login")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginCon() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		
		UserDTO loginUser = new UserService().login(user);
		
		System.out.println(loginUser);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
