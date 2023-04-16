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

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.ArticleDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.vo.ArticleVO;
import kr.co.kmarket1.vo.Cate2VO;

@WebServlet("/admin/cs/list.do")
public class CSListController extends HttpServlet{
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
		if(group == null) {
			group = "notice";
		}
		String cate = req.getParameter("cate");
		String cate2 = req.getParameter("cate2");
		String pg = req.getParameter("pg");
		
		List<Cate2VO> artiCate2s = null;
		
		int start = 0;
		int currentPage = 1;
		int currentPageGroup = 1;
		int total = 0;
		int pageStartNum = 0;
		int lastPageNum = 0;
		if(pg!=null){
			currentPage = Integer.parseInt(pg);
		}
		
		start = (currentPage - 1) * 10;
		ArticleDao AD = ArticleDao.getInstance();
		// 전체 게시물 갯수
		if(group.equals("notice")) {
			if(cate==null) {
				total = AD.selectCountTotal(group);
			}else {
				total = AD.selectCountTotal(cate, group);
			}
		}else if(group.equals("faq")) {
			artiCate2s = CateDao.getInstance().selectArtiCates_2();
			if(cate == null) {
				cate = "member";
			}
			if(cate2 == null) {
				cate2 = "reg";
			}
			total = AD.selectCountTotal(cate, group);
		}else if(group.equals("qna")) {
			artiCate2s = CateDao.getInstance().selectArtiCates_2();
			if(cate == null) {
				cate = "member";
			}
			if(cate2 == null) {
				cate2 = "reg";
			}
			total = AD.selectCountTotal(cate, cate2, group);
		}
		
		// 시작 페이지 번호
		pageStartNum = total - start;
		
		// 마지막 페이지 번호
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		
		// 페이지 그룹 start, end 번호
		currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		int[] result = {pageGroupStart, pageGroupEnd};
		
		List<ArticleVO> articles = null;
		
		
		if(group.equals("notice")) {
			if(cate==null) {
				articles = AD.selectArticlesByGroup(group, start);
			}else {
				articles = AD.selectArticlesByCateN(group, cate, start);
			}
		}else if(group.equals("faq")) {
			artiCate2s = CateDao.getInstance().selectArtiCates_2();
			if(cate == null) {
				cate = "member";
			}
			if(cate2 == null) {
				cate2 = "reg";
			}
			articles = AD.selectArticlesByCate2(group, cate, cate2, start);
		}else if(group.equals("qna")) {
			artiCate2s = CateDao.getInstance().selectArtiCates_2();
			if(cate == null) {
				cate = "member";
			}
			if(cate2 == null) {
				cate2 = "reg";
			}
			articles = AD.selectArticlesByCate2(group, cate, cate2, start);
		}
		
		req.setAttribute("cate", cate);
		req.setAttribute("cate2", cate2);
		req.setAttribute("pg", pg);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("currentPageGroup", currentPageGroup);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("artiCate2s", artiCate2s);
		req.setAttribute("articles", articles);
		req.setAttribute("group", group);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String chks = req.getParameter("chks");
		
		int result = ArticleDao.getInstance().deleteArticleByChk(chks);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		String jsonData = json.toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
}
