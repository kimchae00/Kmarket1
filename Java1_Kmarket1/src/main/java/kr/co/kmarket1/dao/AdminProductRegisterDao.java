package kr.co.kmarket1.dao;



import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AdminProductRegisterDao extends DBHelper{
	private static AdminProductRegisterDao instance = new AdminProductRegisterDao();
	public static AdminProductRegisterDao getInstance () {
		return instance;
	}
 
	private AdminProductRegisterDao () {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
  
	public void selectProduct () {}
	

	
	// 베스트 상품 리스트 TOP5
	public List<ProductVO> selectProductsSold () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsSold start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1` FROM `km_product` ORDER BY `sold` DESC LIMIT 5");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	// 히트 상품 리스트 TOP8
	public List<ProductVO> selectProductsHit () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsHit start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` ORDER BY `hit` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	// 추천 상품 리스트 TOP8
	public List<ProductVO> selectProductsScore () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsScore start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` ORDER BY `score` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	// 최신 상품 리스트 TOP8
	public List<ProductVO> selectProductsLates () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsLates start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` ORDER BY `prodNo` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	// 할인 상품 리스트 TOP8
	public List<ProductVO> selectProductsDiscount () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsDiscount start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery` FROM `km_product` ORDER BY `discount` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				
				products.add(product);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	// 메인 상품 리스트 작업 ////////////// 끝 - 홍모
	
	
	// RegisterController doPost데이터베이스
	public int insertProduct (ProductVO vo) {
		int result = 0;
		try {
			logger.info("insertProduct...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_PRODUCT);
			psmt.setInt(1, vo.getProdCate1());
			psmt.setInt(2, vo.getProdCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setString(6, vo.getSeller());
			psmt.setInt(7, vo.getPrice());
			psmt.setInt(8, vo.getDiscount());
			psmt.setInt(9, vo.getPoint());
			psmt.setInt(10, vo.getStock());
			psmt.setInt(11, vo.getDelivery());
			psmt.setString(12, vo.getThumb1());
			psmt.setString(13, vo.getThumb2());
			psmt.setString(14, vo.getThumb3());
			psmt.setString(15, vo.getDetail());
			psmt.setString(16, vo.getStatus());
			psmt.setString(17, vo.getDuty());
			psmt.setString(18, vo.getReceipt());
			psmt.setString(19, vo.getBizType());
			psmt.setString(20, vo.getOrigin());
			psmt.setString(21, vo.getIp());
			result = psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	
	public void updateProduct (String prodName, String descript, String company, String seller, String price, String discount, String point, String stock, String delivery, String thumb1, String thumb2, String thumb3, String detail, String prodNo) {
		try {
			logger.info("상품내용 수정 : " + prodNo);
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_ADMIN_PRODUCT);
			psmt.setString(1, prodName);
			psmt.setString(2, descript);
			psmt.setString(3, company);
			psmt.setString(4, seller);
			psmt.setString(5, price);
			psmt.setString(6, discount);
			psmt.setString(7, point);
			psmt.setString(8, stock);
			psmt.setString(9, delivery);
			psmt.setString(10, thumb1);
			psmt.setString(11, thumb2);
			psmt.setString(12, thumb3);
			psmt.setString(13, detail);
			psmt.setString(14, prodNo);
			psmt.executeUpdate();
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	public void deleteProduct () {}
	
	
	
	
	
	
	
	
	
}


















