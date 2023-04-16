package kr.co.kmarket1.controller.product;

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
import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = ProductService.instance;
	
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
		
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		String prodNo = req.getParameter("prodNo");
		String pg = req.getParameter("pg");
		String type = req.getParameter("type");
		
		ProductDao PD = ProductDao.getInstance();
		
		// 페이징 처리
		int currentPage = service.getCurrentPage(pg); // 현재 페이지 번호
		int total = 0; // 전체 게시물 갯수
		total = service.selectCountTotal(prodCate1, prodCate2);
		
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum); // 페이지 그룹번호
		int pageStartNum = service.getPageStartNum(total, currentPage); // 페이지 시작번호
		int start = service.getStartNum(currentPage); // 시작 인덱스
		
		// 카테고리별 리스트 불러오기
		// 상품 정렬
		List<ProductVO> products = null;
		if(type == null || type.equals("sold")) {
			products = PD.selectProductsBySold(prodCate1, prodCate2, start);
		}else if(type.equals("lowPrice")) {
			products = PD.selectProductsByLowPrice(prodCate1, prodCate2, start);
		}else if(type.equals("highPrice")) {
			products = PD.selectProductsByHighPrice(prodCate1, prodCate2, start);
		}else if(type.equals("score")) {
			products = PD.selectProductsByScore(prodCate1, prodCate2, start);
		}else if(type.equals("review")) {
			products = PD.selectProductsByReview(prodCate1, prodCate2, start);
		}else if(type.equals("new")) {
			products = PD.selectProductsByNew(prodCate1, prodCate2, start);
		}
		
		req.setAttribute("products", products);
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("type", type);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}
