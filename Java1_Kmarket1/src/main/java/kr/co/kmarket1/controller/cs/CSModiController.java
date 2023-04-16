package kr.co.kmarket1.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.ArticleDao;
import kr.co.kmarket1.vo.ArticleVO;

@WebServlet("/admin/cs/modify.do")
public class CSModiController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = req.getParameter("group");
		String no = req.getParameter("no");
		
		ArticleVO article = ArticleDao.getInstance().selectArticle(no);
		
		req.setAttribute("article", article);
		req.setAttribute("group", group);
		req.setAttribute("no", no);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		ArticleVO vo = new ArticleVO();
		vo.setCate(cate);
		vo.setCate2(cate2);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		// 공지사항 수정하기
		ArticleDao.getInstance().updateArticle(vo);
		
		// 글보기로 돌아가기 
		resp.sendRedirect("/Java1_Kmarket1/admin/cs/view.do?&group="+group+"&no="+no);
	}
}
