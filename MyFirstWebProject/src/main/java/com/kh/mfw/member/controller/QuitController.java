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


@WebServlet("/quit")
public class QuitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QuitController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
		
		String memberId = member.getMemberId();
		String memberPw = member.getMemberPw();
		String inputPw  = request.getParameter("userPw");
		
		int result = new MemberService().quit(memberId,memberPw,inputPw);
		
		if(result>0) {
			session.removeAttribute("loginMember");
		}
		
		
		String path = request.getContextPath();
		response.sendRedirect(result > 0 ? path : path+"/myPage");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
