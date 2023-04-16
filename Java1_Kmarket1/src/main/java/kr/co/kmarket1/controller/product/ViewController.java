package kr.co.kmarket1.controller.product;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.CartDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.dao.ProductDao;
import kr.co.kmarket1.service.ProductService;
import kr.co.kmarket1.vo.CartVO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;
import kr.co.kmarket1.vo.ReviewVO;

@WebServlet("/product/view.do")
public class ViewController extends HttpServlet {
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
		
		// 상품 출력
		ProductDao PD = ProductDao.getInstance();
		ProductVO product = PD.selectProduct(prodNo);
		
		// 리뷰 페이징 처리
		int currentPage = service.getCurrentPage2(pg); // 현재 페이지 번호
		int total = 0; // 전체 게시물 갯수
		total = service.selectCountTotalReview(prodNo);
		
		int lastPageNum = service.getLastPageNum2(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum2(currentPage, lastPageNum); // 페이지 그룹번호
		int pageStartNum = service.getPageStartNum2(total, currentPage); // 페이지 시작번호
		int start = service.getStartNum2(currentPage); // 시작 인덱스
		
		List<ReviewVO> reviews = PD.selectReview(prodNo, start);
		
		req.setAttribute("product", product);
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("reviews", reviews);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calendar cCal = Calendar.getInstance();
		cCal.add(Calendar.DATE, 3);
		
		// 카트 삽입
		String uid = req.getParameter("uid");
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		String price = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point = req.getParameter("point");
		String delivery = req.getParameter("delivery");
		String thumb1 = req.getParameter("thumb1");
		String total = req.getParameter("total");
		
		CartVO cart = new CartVO();
		cart.setUid(uid);
		cart.setProdNo(prodNo);
		cart.setCount(count);
		cart.setPrice(price);
		cart.setDiscount(discount);
		cart.setPoint(point);
		cart.setDelivery(delivery);
		cart.setThumb1(thumb1);
		cart.setTotal(total);

		String cartNo = req.getParameter("cartNo");
		
		// 중복일 시 수량 +
		int result = CartDao.getInstance().selectCart(prodNo, uid);

		if(result == 1) {
			CartDao.getInstance().updateCart(count, cartNo);
		}else {
			CartDao.getInstance().insertCart(cart);
		}
		
		// JSON 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}
