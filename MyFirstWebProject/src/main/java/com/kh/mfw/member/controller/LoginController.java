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


@WebServlet("/sign-in")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
        
    }
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 절차
		// 1) GET /POST인가 확인 > POST라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청값이 있나? 없나? 확인 > 있다면 값을 뽑아서 가공
		// request.getParameter("input요소의 name 속성값");
		//     --> 무조건 input요소의 name 속성 값을 적는 것은 아님
		
		// memberId / memberPw
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		//System.out.printf("입력한 아이디 : %s \n 입력한 비밀번호 : %s",memberId,memberPw);
		
		// 3) 값이 두 개 이상일 경우 어딘가에 예쁘게 담기
		MemberDTO member = new MemberDTO();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		
		MemberDTO loginMember = new MemberService().login(member);
		// case 1. 아이디와 비밀번호값이 일치했다면
		//			필드값에 회원정보가 담겨있는 MemberDTO 객체의 주소값 반환
		
		// case 2. 유효성 검증에 통과하지 못했거나, 아이디 또는 비밀번호가 일치하지 않았다면
		//			null값 반환
		System.out.println(loginMember);
		
		// 4) 응답 화면 만들기
		// request.setAttribute("loginMember", loginMember);
		
		/* 로그인에 성공했다면,
		 * 로그인 한 회원의 정보를
		 * 로그아웃 요청이 들어오거나, 브라우저를 종료하기 전까지는
		 * 계속 사용할 수 있어야 하기 때문에,
		 * Session이라는 저장소에 값을 담아둘 것 
		 */
		
		// Session의 자료형 : HttpSession
		HttpSession session = request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		// forwarding 방식
		/* index.jsp에서 응답을 처리하려고 포워딩했을 때 파일 이름이 바뀔경우 문제가 발생
		 * servlet은 로그인 담당인데 파일이름 바뀐것에 대한 책임을 져야함 -> 단일 책임 원칙 위배
		 */
		//request.getRequestDispatcher("index.jsp").forward(request,response);
		
		
		// sendRedirect 방식 : 클라이언트에게 재용청할 URL을 알려줏어서
		// 					  클라이언트가 다시 요청을 보내게 만듦
		// response.sendRedirect("/mfw");
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
