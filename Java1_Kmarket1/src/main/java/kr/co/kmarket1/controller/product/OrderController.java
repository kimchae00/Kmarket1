package kr.co.kmarket1.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import kr.co.kmarket1.dao.CartDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.dao.OrderDao;
import kr.co.kmarket1.dao.OrderItemDao;
import kr.co.kmarket1.dao.PointDao;
import kr.co.kmarket1.dao.ProductDao;
import kr.co.kmarket1.vo.CartVO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;

import kr.co.kmarket1.vo.MemberVO;

import kr.co.kmarket1.vo.OrderItemVO;
import kr.co.kmarket1.vo.OrderVO;
import kr.co.kmarket1.vo.ProductVO;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 세션에서 아이디 불러오기
		HttpSession session = req.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("sessUser");
		String uid = vo.getUid();
		
		// cate1,2 리스트 불러오기 - 구홍모 12/11
		CateDao CD = CateDao.getInstance();
		List<Cate1VO> cate1s = CD.selectCates_1();
		List<Cate2VO> cate2s = CD.selectCates_2();
		req.setAttribute("cate1s", cate1s);
		req.setAttribute("cate2s", cate2s);
		
		// 상품번호 수신 - 구홍모 //
		String cartNo = req.getParameter("cartNo");
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		
		List<CartVO> cartList = null;
		ProductVO product = null;
		if(prodNo == null) {
			cartList = CartDao.getInstance().selectCartsByCartNo(cartNo);
		}else {
			product = ProductDao.getInstance().selectProduct(prodNo);
		}
		
		req.setAttribute("cartList", cartList);
		req.setAttribute("product", product);
		req.setAttribute("count", count);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// order 주문 등록을 위한 수신
		String cartNo = req.getParameter("cartNo");
		String recipName = req.getParameter("recipName");
		String recipHp = req.getParameter("recipHp");
		String recipZip = req.getParameter("recipZip");
		String recipAddr1 = req.getParameter("recipAddr1");
		String recipAddr2 = req.getParameter("recipAddr2");
		String ordUid = req.getParameter("ordUid");
		String ordCount = req.getParameter("ordCount");
		String ordPrice = req.getParameter("ordPrice");
		String ordDiscount = req.getParameter("ordDiscount");
		String ordDelivery = req.getParameter("ordDelivery");
		String savePoint = req.getParameter("savePoint");
		String usedPoint = req.getParameter("usedPoint");
		String ordTotPrice = req.getParameter("ordTotPrice");
		String ordPayment = req.getParameter("ordPayment");
		
		OrderVO vo = new OrderVO();
		vo.setRecipName(recipName);
		vo.setRecipHP(recipHp);
		vo.setRecipZip(recipZip);
		vo.setRecipAddr1(recipAddr1);
		vo.setRecipAddr2(recipAddr2);
		vo.setOrdUid(ordUid);
		vo.setOrdCount(ordCount);
		vo.setOrdPrice(ordPrice);
		vo.setOrdDiscount(ordDiscount);
		vo.setOrdDelivery(ordDelivery);
		vo.setSavePoint(savePoint);
		vo.setUsedPoint(usedPoint);
		vo.setOrdTotPrice(ordTotPrice);
		vo.setOrdPayment(ordPayment);
		if(Integer.parseInt(ordPayment) != 4) {
			vo.setOrdComplete(1);
		}else {
			vo.setOrdComplete(0);
		}
		
		int ordNo = OrderDao.getInstance().insertOrder(vo);
		
		if(ordNo > 0) {
			CartDao.getInstance().deleteCartByChk(cartNo);
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("result", ordNo);
		String jsonData = json.toString();
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);

	}
}
