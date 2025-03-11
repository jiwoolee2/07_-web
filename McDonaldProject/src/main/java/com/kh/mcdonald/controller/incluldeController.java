package com.kh.mcdonald.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "IncluldeController", urlPatterns = { "/include" })
public class incluldeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public incluldeController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청이 온거를 include.jsp에서 처리하게 보냄
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/include/include.jsp");
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
