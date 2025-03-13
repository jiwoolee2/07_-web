package com.kh.mfw.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;


@WebServlet("/np")
public class NewPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewPasswordController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember"); 
		String memberId = member.getMemberId();
		String changePw = request.getParameter("changePw");
		String userPw = request.getParameter("userPw");
	
			
		int result = new MemberService().newPassword(memberId,changePw,userPw);
		
		String path = request.getContextPath();
		System.out.println(result);
		if(result>0) {
			member.setMemberPw(changePw);
		}
		response.sendRedirect( result > 0  ? path : path+"/myPage");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
