package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.CartVO;

public class CartDao extends DBHelper{
	private static CartDao instance = new CartDao();
	public static CartDao getInstance () {
		return instance;
	}
	public CartDao () {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void insertCart(CartVO cart) {
		
		try {
			logger.info("insertCart start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_CART);
			psmt.setString(1, cart.getUid());
			psmt.setInt(2, cart.getProdNo());
			psmt.setInt(3, cart.getCount());
			psmt.setInt(4, cart.getPrice());
			psmt.setInt(5, cart.getDiscount());
			psmt.setInt(6, cart.getPoint());
			psmt.setInt(7, cart.getDelivery());
			psmt.setInt(8, cart.getTotal());
			psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// 장바구니 상품 중복체크
	public int selectCart(String prodNo, String uid) {
		int result = 0;
		try {
			logger.info("selectCart start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CART);
			psmt.setString(1, prodNo);
			psmt.setString(2, uid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
				CartVO cart = new CartVO();
				cart.setCartNo(rs.getInt(1));
				cart.setUid(rs.getString(2));
				cart.setProdNo(rs.getInt(3));
				cart.setCount(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setDiscount(rs.getInt(6));
				cart.setPoint(rs.getInt(7));
				cart.setDelivery(rs.getInt(8));
				cart.setTotal(rs.getInt(9));
				cart.setRdate(rs.getString(10));
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	// uid로 장바구니 목록 불러오기
	public List<CartVO> selectCartsByUid(String uid) {
		
		List<CartVO> carts = new ArrayList<>();
		
		try {
			logger.info("selectCartsByUid start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_CARTS_BY_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setCartNo(rs.getInt(1));
				cart.setUid(rs.getString(2));
				cart.setProdNo(rs.getInt(3));
				cart.setCount(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setDiscount(rs.getInt(6));
				cart.setPoint(rs.getInt(7));
				cart.setDelivery(rs.getInt(8));
				cart.setTotal(rs.getInt(9));
				cart.setRdate(rs.getString(10));
				cart.setProdName(rs.getString(11));
				cart.setThumb1(rs.getString(12));
				cart.setDescript(rs.getString(13));
				cart.setProdCate1(rs.getInt(14));
				cart.setProdCate2(rs.getInt(15));
				
				carts.add(cart);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	// 장바구니 번호로 불러오기
	public List<CartVO> selectCartsByCartNo(String cartNo) {
		
		List<CartVO> carts = new ArrayList<>();
		
		try {
			logger.info("selectCartsByCartNo start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT a.*, b.`prodName`, b.`thumb1`, b.`descript`, b.`prodCate1`, b.`prodCate2` FROM `km_product_cart` AS a "
					+"JOIN `km_product` as b ON a.prodNo = b.prodNo where `cartNo` in ("+cartNo+")");
			//psmt.setString(1, cartNo);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setCartNo(rs.getInt(1));
				cart.setUid(rs.getString(2));
				cart.setProdNo(rs.getInt(3));
				cart.setCount(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setDiscount(rs.getInt(6));
				cart.setPoint(rs.getInt(7));
				cart.setDelivery(rs.getInt(8));
				cart.setTotal(rs.getInt(9));
				cart.setRdate(rs.getString(10));
				cart.setProdName(rs.getString(11));
				cart.setThumb1(rs.getString(12));
				cart.setDescript(rs.getString(13));
				cart.setProdCate1(rs.getInt(14));
				cart.setProdCate2(rs.getInt(15));
				
				carts.add(cart);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	
	// 장바구니에서 선택한 상품
	public List<CartVO> selectCartByChk(String chks) {
		
		List<CartVO> carts = new ArrayList<>();
		try {
			logger.info("selectCartByChk start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_product_cart` where `cartNo` in ("+chks+")");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CartVO cart = new CartVO();
				cart.setCartNo(rs.getInt(1));
				cart.setUid(rs.getString(2));
				cart.setProdNo(rs.getInt(3));
				cart.setCount(rs.getInt(4));
				cart.setPrice(rs.getInt(5));
				cart.setDiscount(rs.getInt(6));
				cart.setPoint(rs.getInt(7));
				cart.setDelivery(rs.getInt(8));
				cart.setTotal(rs.getInt(9));
				cart.setRdate(rs.getString(10));
				
				carts.add(cart);
			}
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return carts;
	}
	
	public void updateCart(String count, String cartNo) {
		try {
			logger.info("updateCart start");
			conn = getConnection();
			psmt = conn.prepareStatement("update `km_product_cart` set `count=`count`+ ? where `cartNo`=?");
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	public int deleteCartByChk(String chks) {
		int result = 0;
		try {
			logger.info("deleteCartByChk start...");
			conn = getConnection();
			psmt = conn.prepareStatement("delete from `km_product_cart` where `cartNo` in ("+chks+")");
			result = psmt.executeUpdate();
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}
