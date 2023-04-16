package kr.co.kmarket1.dao;



import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;
import kr.co.kmarket1.vo.ReviewVO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ProductDao extends DBHelper{
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance () {
		return instance;
	}
 
	private ProductDao () {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
  
	public ProductVO selectProduct (String prodNo) {
		
		ProductVO product = null;
		
		try {
			logger.info("selectProduct start...");
			conn = getConnection(); 
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage()); 
		}
		logger.info("price :"+product.getPrice());
		return product;
	}
	// 주문상품 불러오기
	public List<ProductVO> selectProducts (String prodNo) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProducts start...");
			conn = getConnection(); 
			psmt = conn.prepareStatement("select * from `km_product` where `prodNo` in ("+prodNo+")");
			//psmt.setString(1, prodNo);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage()); 
		}
		logger.info("사이즈 : "+products.size());
		return products;
	}
	
	// 메인 상품 리스트 작업 ////////////// 시작 12/13 - 홍모
	// 상품 정렬
	public List<ProductVO> selectProductsBySold(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsBySold start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_SOLD);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
			
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public List<ProductVO> selectProductsByLowPrice(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsByLowPrice start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_LOW_PRICE);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public List<ProductVO> selectProductsByHighPrice(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsByHighPrice start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_HIGH_PRICE);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public List<ProductVO> selectProductsByScore(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsByScore start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_SCORE);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public List<ProductVO> selectProductsByReview(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsByReview start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_REVIEW);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	public List<ProductVO> selectProductsByNew(String prodCate1, String prodCate2, int start) {
		
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("selectProductsByNew start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS_BY_NEW);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdCate1(rs.getString(2));
				product.setProdCate2(rs.getString(3));
				product.setProdName(rs.getString(4));
				product.setDescript(rs.getString(5));
				product.setCompany(rs.getString(6));
				product.setSeller(rs.getString(7));
				product.setPrice(rs.getInt(8));
				product.setDiscount(rs.getInt(9));
				product.setPoint(rs.getInt(10));
				product.setStock(rs.getInt(11));
				product.setSold(rs.getInt(12));
				product.setDelivery(rs.getInt(13));
				product.setHit(rs.getInt(14));
				product.setScore(rs.getInt(15));
				product.setReview(rs.getInt(16));
				product.setThumb1(rs.getString(17));
				product.setThumb2(rs.getString(18));
				product.setThumb3(rs.getString(19));
				product.setDetail(rs.getString(20));
				product.setStatus(rs.getString(21));
				product.setDuty(rs.getString(22));
				product.setReceipt(rs.getString(23));
				product.setBizType(rs.getString(24));
				product.setOrigin(rs.getString(25));
				product.setIp(rs.getString(26));
				
				products.add(product);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return products;
	}
	
	// 리뷰
	public List<ReviewVO> selectReview(String prodNo,int start) {
		
		List<ReviewVO> reviews = new ArrayList<>();
		
		try {
			logger.info("selectReview start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_REVIEW);
			psmt.setString(1, prodNo);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ReviewVO review = new ReviewVO();
				review.setRevNo(rs.getInt(1));
				review.setProdNo(rs.getInt(2));
				review.setContent(rs.getString(3));
				review.setUid(rs.getString(4));
				review.setRating(rs.getInt(5));
				review.setRegip(rs.getString(6));
				review.setRdate(rs.getString(7).substring(0, 10));
				review.setProdName(rs.getString(8));
				
				reviews.add(review);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return reviews;
	}
	
	// 전체 상품 카운트(리스트)
	public int selectCountTotal(String prodCate1, String prodCate2) {
		
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL);
			psmt.setString(1, prodCate1);
			psmt.setString(2, prodCate2);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;		
	}
	// 전체 리뷰 카운트(뷰)
	public int selectCountTotalReview(String prodNo) {
		
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_TOTAL_REVIEW);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;		
	}
	
	// 베스트 상품 리스트 TOP5
	public List<ProductVO> selectProductsSold () {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("selectProductsSold start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`prodCate1`,`prodCate2` FROM `km_product` ORDER BY `sold` DESC LIMIT 5");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setProdCate1(rs.getInt(6));
				product.setProdCate2(rs.getInt(7));
				
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
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery`,`prodCate1`,`prodCate2` FROM `km_product` ORDER BY `hit` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				product.setProdCate1(rs.getInt(7));
				product.setProdCate2(rs.getInt(8));
				
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
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery`,`prodCate1`,`prodCate2` FROM `km_product` ORDER BY `score` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				product.setProdCate1(rs.getInt(7));
				product.setProdCate2(rs.getInt(8));
				
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
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery`,`prodCate1`,`prodCate2` FROM `km_product` ORDER BY `prodNo` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				product.setProdCate1(rs.getInt(7));
				product.setProdCate2(rs.getInt(8));
				
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
			rs = stmt.executeQuery("SELECT `prodNo`,`prodName`,`price`,`discount`,`thumb1`,`delivery`,`prodCate1`,`prodCate2` FROM `km_product` ORDER BY `discount` DESC LIMIT 8");
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProdNo(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setDiscount(rs.getInt(4));
				product.setThumb1(rs.getString(5));
				product.setDelivery(rs.getInt(6));
				product.setProdCate1(rs.getInt(7));
				product.setProdCate2(rs.getInt(8));
				
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
	public void updateProduct () {}
	public void deleteProduct () {}
	
	
	
	
	
	
	
	
}



















