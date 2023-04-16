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

@WebServlet("/admin/cs/view.do")
public class CSViewController extends HttpServlet{
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
		
		List<Cate2VO> artiCate2s = CateDao.getInstance().selectArtiCates_2();
		
		ArticleDao ad = ArticleDao.getInstance();
		
		// 게시글 가져오기
		ArticleVO article = ad.selectArticle(no);
		// 답변 가져오기
		ArticleVO reply = ad.selectReply(no);
		
		req.setAttribute("artiCate2s", artiCate2s);
		req.setAttribute("article", article);
		req.setAttribute("group", group);
		req.setAttribute("reply", reply);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String uid = req.getParameter("uid");
		String content = req.getParameter("reply");
		String regip = req.getRemoteAddr();
		
		ArticleVO vo = new ArticleVO();
		vo.setNo(no);
		vo.setUid(uid);
		vo.setContent(content);
		vo.setRegip(regip);
		
		int result = ArticleDao.getInstance().insertReply(vo);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		String jsonData = json.toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
}
