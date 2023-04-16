package kr.co.kmarket1.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.TermsDao;
import kr.co.kmarket1.vo.TermsVO;

@WebServlet("/member/signup.do")
public class SignupController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		
		TermsVO vo = null;
		
		if(type.equals("normal")) {
			vo = TermsDao.getInstance().selectTermsNormal();
		}else {
			vo = TermsDao.getInstance().selectTermsSeller();
		}
		
		req.setAttribute("vo", vo);
		req.setAttribute("type", type);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/signup.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	
}
