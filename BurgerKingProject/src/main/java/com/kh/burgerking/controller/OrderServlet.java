package com.kh.burgerking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 버전관리 하려고//
       
	// 기본 생성자
    public OrderServlet() {
        super();
    }

	/* Tomcat(서버의 역할을 하는 프로그램)이 알아서 서블릿을 객체로 올림
	 * 객체생성을 따로 하지 않아도 객체로 올리기 때문에 메서드가 호출됨
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("/bk/order doGet메서드 호출됨");
		
		// 사용자가 입력한 수량 X 500을 해야됨
		
		// Controller역할 : 데이터를 받아 가공해서 Service로 넘겨주는 역할
		// 				   응답받은 데이터를 View로 받아라~
		/*
		 * View 에서 GET 방식으로 요청 시 doGet()메서드가 호출됨!!!
		 * 두 개의 매개변수 존재함 -> 매개변수에는 객체의 주소값이 담김. 
		 * 
		 * 첫 번쨰 매개변수 HttpServletRequest => 요청 시 전달된 내용들이 담김
		 * => 요청 전송방식(GET), 사용자의 IP 주소, 어떤 URL을 통해서 왔는지, 사용자가 입력한 값 등등..
		 * 
		 * 두 번째 매개변수 HttpServletResponse => 요청 처리 후 응답할 때 사용
		 * 
		 * 
		 */
		
//		String queryString = request.getQueryString();
//		System.out.println(queryString);

		// requestURL = num=1231232&product-name=222
		int num = Integer.parseInt(request.getParameter("num")); // key를 뽑아서 확인
		System.out.println(num);
		
		String productName = request.getParameter("product-name");
		System.out.println(productName);
		
		/* 자주보는 문제상황
		 * 
		 * 404 : 파일이나 요청을 받아주는 서블릿을 찾지 못했을 때 발생
		 * 		-> 오타일 확률이 높음
		 * 		
		 * 
		 * 505 : 자바 소스 코드상의 오류(예외발생) 
		 */
		
		// DB에서 Insert해서 잘 갔다 옴
		/* 요청처리 (Service의 메서드를 호출해서 DB와의 상호작용까지 끝난 상태)
		 */
		
		int totalPrice = num*500;
		
		/*
		 * XXX(사용자가 입력한 제품명)의 총 가격은 XXX(총 결제해야하는 금액)원 입니다.
		 */
		
		// 1단계 ) 응답 데이터 형식 지정 -> 문서 형태의 HTML / 인코딩방식 UTF-8 
		response.setContentType("text/html; charset=UTF-8 ");
		
		// 2단계 ) 출력 스트림 생성
		PrintWriter writer = response.getWriter();
		
		// 3단계 ) 스트림을 통해 HTML 출력
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>ahahahah get 방식 응답</title>");
		writer.println("</head>");
		
		writer.println("<script>");
		writer.println("alert('축하해~~')");
		
		writer.println("</script>");
		
		writer.printf("%s의 총 가격은 %d입니다.",productName,totalPrice);
		writer.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/bk/order doPost메서드 호출됨!");
	}

}
