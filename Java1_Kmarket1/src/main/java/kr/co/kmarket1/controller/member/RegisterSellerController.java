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
import kr.co.kmarket1.vo.MemberVO;

@WebServlet("/member/registerSeller.do")
public class RegisterSellerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locationTerms = req.getParameter("locationTerms");
		req.setAttribute("locationTerms", locationTerms);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/registerSeller.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String pass1 = req.getParameter("pass1");
		String pass2 = req.getParameter("pass2");
		String kms_company = req.getParameter("kms_company");
		String kms_ceo = req.getParameter("kms_ceo");
		String kms_corp_reg = req.getParameter("kms_corp_reg");
		String kms_online_reg = req.getParameter("kms_online_reg");
		String kms_tel = req.getParameter("kms_tel");
		String kms_fax = req.getParameter("kms_fax");
		String kms_email = req.getParameter("kms_email");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String type = req.getParameter("type");
		String level = req.getParameter("level");
		String regip = req.getRemoteAddr();
		
		
		MemberVO vo = new MemberVO();
		vo.setUid(uid);
		vo.setPass(pass1);
		vo.setHp(kms_tel);
		vo.setCompany(kms_company);
		vo.setCeo(kms_ceo);
		vo.setBizRegNum(kms_corp_reg);
		vo.setComRegNum(kms_online_reg);
		vo.setTel(kms_tel);
		vo.setFax(kms_fax);
		vo.setEmail(kms_email);
		vo.setZip(zip);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setType(type);
		vo.setLevel(level);
		vo.setRegip(regip);
		
		MemberDao.getInstance().insertSellerMember(vo);
		
		// 회원가입 완료
		if(vo != null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='/Java1_Kmarket1/member/login.do';</script>");
			out.flush();
		
		}
		}
		
	}
	