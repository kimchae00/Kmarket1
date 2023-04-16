package kr.co.kmarket1.dao;



import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;
import kr.co.kmarket1.vo.ProductVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
public class AdminProductListDao extends DBHelper{
	private static AdminProductListDao instance = new AdminProductListDao();
	public static AdminProductListDao getInstance () {
		return instance;
	}
 
	private AdminProductListDao () {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
  
	public void selectProduct () {}
	
	
	
	
	
	public void updateProduct () {}
	public void deleteProduct () {}
	
	
	
	// List 상품출력
	public List<ProductVO> selectAdminProductList(int start) {
		logger.info("selectAdminProductList...");
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("상품 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ADMIN_PRODUCT_LIST);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	// List 상품출력 - 판매자용
	public List<ProductVO> selectAdminProductList(String seller, int start) {
		logger.info("selectAdminProductList...");
		List<ProductVO> products = new ArrayList<>();
		
		try {
			logger.info("상품 리스트");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ADMIN_PRODUCT_LIST_SELLER);
			psmt.setString(1, seller);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	public List<ProductVO> searchProductList(String type, String search) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트 검색 : " + type + search);
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `"+type+"` LIKE ? ORDER BY `prodNo` DESC LIMIT 10");
			//psmt.setString(1, type);
			psmt.setString(1, "%"+search+"%");
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("상품 리스트 검색 : " + products.size());
		return products;
	}
	public List<ProductVO> searchProductList(String seller, String type, String search) {
		List<ProductVO> products = new ArrayList<>();
		try {
			logger.info("상품 리스트 검색 : " + type + search);
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE `seller`=? AND `"+type+"` LIKE ? ORDER BY `prodNo` DESC LIMIT 10");
			//psmt.setString(1, type);
			psmt.setString(1, seller);
			psmt.setString(2, "%"+search+"%");
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("상품 리스트 검색 : " + products.size());
		return products;
	}
	
	//페이지 리스트
	public int selectCountTotal() {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.COUNT_LIST_TOTAL);
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	//페이지 리스트 - 판매자용
	public int selectCountTotalSeller(String seller) {
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.COUNT_LIST_TOTAL_SELLER);
			psmt.setString(1, seller);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	// 상품 삭제
	public void deleteAdminList(String prodNo) {
		logger.info("상품삭제 : " + prodNo);
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_ADMIN_LIST);
			psmt.setString(1, prodNo);
			psmt.executeUpdate();
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	// admin list 상품수정버튼	if = 참이면 실행 / while = 참이면 계속 실행(거짓이 될때까지)
	public ProductVO ModifyAdminProduct(String prodNo) {
			logger.info("상품수정");
			
			ProductVO vo = new ProductVO(); 
			
		try {
			
			conn = getConnection();
			PreparedStatement psmt = conn.prepareStatement(SQL.MODIFY_ADMIN_PRODUCT);
			psmt.setString(1, prodNo);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18)); 
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				vo.setDisPrice(vo.getPrice() / 100 * vo.getDiscount());
			}
			
			close();
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return vo;
	}
	
	// 선택삭제
	public int selectdelete(String prodNo) {
		int result = 0;
		
		try {
			logger.info("선택삭제");
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.SELECT_DELETE);
			psmt.setString(1, prodNo);
			result = psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	
}



















