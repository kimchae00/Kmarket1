package kr.co.kmarket1.controller.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.ArticleDao;

@WebServlet("/admin/cs/delete.do")
public class CSDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String group = req.getParameter("group");
		
		ArticleDao.getInstance().deleteArticle(no);
		
		resp.sendRedirect("/Java1_Kmarket1/admin/cs/list.do?group="+group);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
