package kr.co.kmarket1.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.MemberDao;
import kr.co.kmarket1.service.MemberService;
import kr.co.kmarket1.vo.MemberVO;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.instance;
	
	@Override
	public void init() throws ServletException {
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locationTerms = req.getParameter("locationTerms");
		req.setAttribute("locationTerms", locationTerms);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String type = req.getParameter("type");
		String level = req.getParameter("level");
		String hp = req.getParameter("hp");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String regip = req.getRemoteAddr();
		String locationTerms = req.getParameter("locationTerms");
		
		MemberVO vo = new MemberVO();
		vo.setUid(uid);
		vo.setPass(pass1);
		vo.setName(name);
		vo.setGender(gender);
		vo.setEmail(email);
		vo.setType(type);
		vo.setLevel(level);
		vo.setHp(hp);
		vo.setZip(zip);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setRegip(regip);
		vo.setLocationTerms(locationTerms);
		
		MemberDao.getInstance().insertMember(vo);
		
		// 회원가입 완료
		if(vo != null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='/Java1_Kmarket1/member/login.do';</script>");
			out.flush();
		
		}
		
	}
	
	
	
}
