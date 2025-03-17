package com.kh.ins.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.ins.member.model.dto.UserDTO;
import com.kh.ins.member.model.service.UserService;


@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignUpController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int    userNo   = Integer.valueOf(request.getParameter("userNo"));
		String userId   = request.getParameter("userId");
		String userPw   = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		
		UserDTO user = new UserDTO(userNo,userId,userPw,userName,null);
		int result = new UserService().signUp(user);
		
		response.sendRedirect(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
