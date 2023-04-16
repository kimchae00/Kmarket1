package kr.co.kmarket1.controller.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.vo.Cate2VO;

@WebServlet("/cs/qna/artiCate2list.do")
public class ArtiCate2Controller extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 게시물 카테고리2 옵션 리스트 불러오기
		String cate = req.getParameter("cate");
		List<Cate2VO> artiCate2s = CateDao.getInstance().selectArtiCates_2(cate);
		
		// cate2 GSON 출력 - 리스트는 gson , 단순String은 json
		Gson gson = new Gson();
		String jsonData = gson.toJson(artiCate2s);
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
}
