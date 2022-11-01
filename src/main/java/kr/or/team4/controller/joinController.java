package kr.or.team4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.team4.dao.joinDao;
import kr.or.team4.dto.MemberDto;

//@WebServlet({ "/joinController", "/join" })
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public joinController() {
        super();
        // TODO Auto-generated constructor stub
    }
	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();	
		
		System.out.println("joinController 진입...유저가 회원가입 시도 중");
		
		//필드값 지정
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd"); 
		String name = request.getParameter("mname"); 
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender"); 
		String email = request.getParameter("email"); 
		String ip = request.getRemoteAddr();
		
		MemberDto dto = new MemberDto(id, pwd, name, age, gender, email, ip);
		joinDao dao = new joinDao();
		int result = dao.insertMember(dto);
		
		if(result!=0) { //INSERT성공시
			//뷰 지정
			System.out.println("회원가입 성공");
			RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
			dispatch.forward(request, response);
		}else {
			System.out.println("회원가입 실패");
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
