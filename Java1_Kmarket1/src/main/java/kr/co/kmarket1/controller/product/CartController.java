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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket1.dao.CartDao;
import kr.co.kmarket1.dao.CateDao;
import kr.co.kmarket1.dao.OrderDao;
import kr.co.kmarket1.dao.OrderItemDao;
import kr.co.kmarket1.vo.CartVO;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.MemberVO;
import kr.co.kmarket1.vo.OrderItemVO;

@WebServlet("/product/cart.do")
public class CartController extends HttpServlet {
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
		
		String prodCate1 = req.getParameter("prodCate1");
		String prodCate2 = req.getParameter("prodCate2");
		String prodNo = req.getParameter("prodNo");
		String cartNo = req.getParameter("cartNo");
		
		// 장바구니 출력
		CartDao Cartdao = CartDao.getInstance();
		List<CartVO> carts = null;
		carts = Cartdao.selectCartsByUid(uid); // 해당 uid를 가진 회원의 장바구니 가져오기
		
		req.setAttribute("prodCate1", prodCate1);
		req.setAttribute("prodCate2", prodCate2);
		req.setAttribute("prodNo", prodNo);
		req.setAttribute("cartNo", cartNo);
		req.setAttribute("carts", carts);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 선택 삭제
		String chks = req.getParameter("chks");
		
		CartDao dao = CartDao.getInstance();
		int result = dao.deleteCartByChk(chks);
		
		// JSON 출력
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		String jsonData = json.toString();
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}
}
