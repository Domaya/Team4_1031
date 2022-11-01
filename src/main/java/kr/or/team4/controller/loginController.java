package kr.or.team4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.team4.dao.MemberListDao;
import kr.or.team4.dao.joinDao;
import kr.or.team4.dao.loginDao;
import kr.or.team4.dto.MemberDto;

@WebServlet("*.do" )
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
    	//1.한글처리
    	//2.데이터 받기
    	//3.요청 판단
    	//4.처리
    	//5.뷰 지정
    	///Team4_1031/login.jsp
    	//Team4_1031/common/login.jsp
    	 String requestURI = request.getRequestURI();
    	 //root 경로 + 파일의 실행된 폴더의 폴더 경로까지
    	 // requestURI = Team4_1031/login.do
    	 /// requestURI = Team4_1031/common/login.do
    	 // common폴더 내의 jsp에서 루트를 쓸 때 ../를 사용하여 상위폴더를 지정하도록 해야
    	 // substring시 내가 원하는 경로를 얻을 수 있다
    	 
		 String contextPath = request.getContextPath();
		 //root 경로 
		 //Team4_1031
		 
		 String urlcommand = requestURI.substring(contextPath.length());
		 // login.do
		 // /common/login.do
		 
		 String viewpage="";

		System.out.println("loginController 서블릿 진입...사용자가 로그인 시도 중");
    	
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 if(urlcommand.equals("/main.do")) {
			 
			 viewpage="/main.jsp";
			 
		 } else if(urlcommand.equals("/login.do")) {
				
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				
				loginDao dao = new loginDao();
				boolean loginCheck = dao.loginCheck(id, pwd);
				
				if(loginCheck == true) {//로그인 정보가 같으면
					System.out.println("로그인 성공");
					
//					if(id="admin") {
//						 viewpage = "/WEB-INF/views/register/register.jsp";
//					}else {
//						
//					}
					
					
					//session 생성
					  HttpSession session = request.getSession();    //세션 객체 만들기
		              session.setAttribute("userid", id);
					

					//loginok.jsp로 forward
					request.setAttribute("id", id);
					request.setAttribute("pwd", pwd);
					viewpage = "/loginok.jsp";
					
					
				}else {
					System.out.println("로그인 실패");
				}
			 
		 }else if(urlcommand.equals("/logout.do")) {
			
			 viewpage="logout.jsp";
			 
		 }else if(urlcommand.equals("/join.do")) {
			 
			 request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				
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
//					RequestDispatcher dispatch = request.getRequestDispatcher("/login.jsp");
//					dispatch.forward(request, response);
					viewpage = "/login.jsp";
				}else {
					System.out.println("회원가입 실패");
				}
			 
		 }else if(urlcommand.equals("/admin.do")) {
			 
			 //데이터처리
			 //meberlist를 받아와서
			 MemberListDao dao = new MemberListDao();
			 List<MemberDto> memberlist = dao.allMemberList();
			 //request.setAttribute("memberlist", memberlist)와 같이 넣고
			 request.setAttribute("memberlist", memberlist);
			 
			 //forward...
			 //뷰에서 forEach로 테이블 출력			 
			 viewpage = "/Admin.jsp";
			 
		 }else if(urlcommand.equals("/memberSearch.do")) {
			 //search창에 입력된 회원이름값으로 LIKE검색
			 System.out.println("서블릿 진입...memberSearch 분기");
			 
			 String inputValue = request.getParameter("search");
			 
			MemberListDao dao = new MemberListDao();
			List<MemberDto> searchMemberlist = dao.searchMember(inputValue);
			request.setAttribute("searchMemberlist", searchMemberlist);
			request.setAttribute("searchvalue", inputValue);
			
			System.out.println("MemberDTO : " + searchMemberlist);
			viewpage = "/MemberSearch.jsp";
			
		 }else if(urlcommand.equals("/memberDelete.do")) {
			 //선택된 회원값 제거
			 //name을 받아서
			 //해당 이름인 회원을 제거
			 System.out.println("memberDelete 분기 진입");
			 String id = request.getParameter("id");
			 
			 //dao에서 해당 회원 객체 삭제
			 MemberListDao dao = new MemberListDao();
			 int resultrow = dao.delUser(id);
			 if(resultrow > 0) {
				 //삭제성공
				 System.out.println("삭제 성공");
			 }else {
				 //삭제실패
				 System.out.println("삭제 실패");
			 }
			 
			 //삭제 성공시 memberlist가 있는 어드민.jsp를 보여주고싶은데
			 //그러면 다시 admin.do를 요청해야될것같음
			 //서블릿에서 서블릿을 부르는 방법?
			 //viewpage = "/Admin.jsp";
			 
			 //이렇게 부르면 됨
			 viewpage = "/admin.do";
			 
		 }else if(urlcommand.equals("/memberUpdateForm.do")) {
			 //멤버 수정 form에 데이터를 보내주고
			 //수정된 데이터를 받아서 처리해야하는데
			 //이걸 서블릿 두개로 나눠서 해야할까? jsp에서 데이터를 보내주는 것보다 그게 나을까?
			 System.out.println("memberUpdate 분기 진입");
			 
			 String id = request.getParameter("id");
			 MemberListDao dao = new MemberListDao();
			 MemberDto member = dao.getIdUser(id); //접근하려는 유저 객체
			 
			 request.setAttribute("member", member);
			 viewpage = "memberUpdate.jsp";
			 
		 }else if(urlcommand.equals("/memberUpdate.do")) {
			 //멤버수정form에 작성된 값을 받는 부분
			 //수정 가능한 부분은 이름, 나이, 성별, 이메일
			 System.out.println("서블릿 memberUpdate분기 진입");
			 
			 String id = request.getParameter("id"); //테이블에 접근해 수정하기 위한 회원 아이디값
			 
			 //수정할 값들
			 String name = request.getParameter("name");
			 int age = Integer.parseInt(request.getParameter("age"));
			 String gender = request.getParameter("gender");
			 String email = request.getParameter("email");
			 System.out.println("유저수정값: "+ name + " " + age + " " + gender + " " + email);
			 
			 //이제 위에 받은 값으로 dao에서 멤버 업데이트
			 MemberListDao dao = new MemberListDao();
			 int result = dao.memberUpdate(id, name, age, gender, email);
			 if(result > 0) {
				 //업데이트 성공시
				 System.out.println("회원정보 수정 성공");
			 }else {
				 System.out.println("회원정보 수정 실패");
			 }
			 viewpage = "admin.do";
		 }
		 
		 RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		 
		 //6. View forward
		 dis.forward(request, response);
    	
    	
    	
    	
    
		
		
		
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
