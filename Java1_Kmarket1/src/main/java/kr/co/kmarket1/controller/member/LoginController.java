package kr.co.kmarket1.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket1.dao.MemberDao;
import kr.co.kmarket1.service.MemberService;
import kr.co.kmarket1.vo.MemberVO;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.instance;
	
	
	@Override
	public void init() throws ServletException {
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터 수신
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		// 데이터베이스 처리
		MemberVO vo = service.selectMember(uid, pass);
		
		// 로그인 처리
		if(vo != null) {
			// 회원 맞음
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", vo);
			
			resp.sendRedirect("/Java1_Kmarket1/index.do");
		
		}else {
			// 회원 아님
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('아이디 비밀번호가 틀립니다.'); location.href='/Java1_Kmarket1/member/login.do?success=100';</script>");
			out.flush();
		}
		
		
	}
	
	
	
}
