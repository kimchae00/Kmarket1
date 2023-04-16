package kr.co.kmarket1.controller.cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.ArticleDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.vo.ArticleVO;
import kr.co.kmarket1.vo.Cate2VO;

@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String group = "faq";
		String cate = req.getParameter("cate");
		if(cate == null) {
			cate = "member";
		}
		List<Cate2VO> artiCate2s = CateDao.getInstance().selectArtiCates_2(cate);
		List<List<ArticleVO>> articlesList = new ArrayList<>(); // 게시물 리스트의 리스트를 만든다.
		for(Cate2VO aCate2 : artiCate2s) {
		List<ArticleVO> articles = ArticleDao.getInstance().selectArticlesByCate2(group, cate, aCate2.getArtiCate2(), 1);
		articlesList.add(articles);
		}
		
		req.setAttribute("cate", cate);
		req.setAttribute("artiCate2s", artiCate2s);
		req.setAttribute("articlesList", articlesList); // 게시물의 리스트의 리스트를 foreach 문 2번 돌려서 게시물 리스트를 꺼낸다.
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
