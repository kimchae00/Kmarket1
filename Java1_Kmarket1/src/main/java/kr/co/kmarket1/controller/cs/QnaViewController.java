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

@WebServlet("/cs/qna/view.do")
public class QnaViewController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수신
		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		
		ArticleDao ad = ArticleDao.getInstance();
		// 조회수 업데이트
		ad.updateArticleHit(no);
		ArticleVO article = ad.selectArticle(no);
		ArticleVO reply = ad.selectReply(no);
		
		req.setAttribute("cate", cate);
		req.setAttribute("article", article);
		req.setAttribute("reply", reply);
		
		RequestDispatcher Dispatcher = req.getRequestDispatcher("/cs/qna/view.jsp");
		Dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
