package kr.co.kmarket1.controller.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket1.dao.ArticleDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.vo.ArticleVO;
import kr.co.kmarket1.vo.Cate2VO;

@WebServlet("/cs/qna/write.do")
public class QnaWriteController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("cate");
		
		req.setAttribute("cate", cate);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String uid = req.getParameter("uid");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		ArticleVO vo = new ArticleVO();
		vo.setUid(uid);
		vo.setGroup(group);
		vo.setCate(cate);
		vo.setCate2(cate2);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRegip(regip);
		
		// 게시물 작성하기
		ArticleDao.getInstance().insertArticle(vo);
		// 
		resp.sendRedirect("/Java1_Kmarket1/cs/qna/list.do?&cate="+cate);
	}
}
