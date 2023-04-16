package kr.co.kmarket1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.dao.ProductDao;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/index.do")
public class IndexContoller extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// cate1,2 리스트 불러오기 - 구홍모 12/11
		CateDao CD = CateDao.getInstance();
		List<Cate1VO> cate1s = CD.selectCates_1();
		List<Cate2VO> cate2s = CD.selectCates_2();
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("cate2s", cate2s);
		
		// 상품 불러오기
		ProductDao PD = ProductDao.getInstance();
		List<ProductVO> bests = PD.selectProductsSold();		 // 베스트 상품 리스트
		List<ProductVO> hits = PD.selectProductsHit();			 // 히트 상품 리스트
		List<ProductVO> scores = PD.selectProductsScore();		 // 추천 상품 리스트
		List<ProductVO> lates = PD.selectProductsLates();		 // 최신 상품 리스트
		List<ProductVO> discounts = PD.selectProductsDiscount();	 // 할인 상품 리스트
		
		req.setAttribute("bests", bests);
		req.setAttribute("hits", hits);
		req.setAttribute("scores", scores);
		req.setAttribute("lates", lates);
		req.setAttribute("discounts", discounts);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
