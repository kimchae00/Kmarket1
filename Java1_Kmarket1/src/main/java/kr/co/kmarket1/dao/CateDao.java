package kr.co.kmarket1.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.vo.Cate1VO;
import kr.co.kmarket1.vo.Cate2VO;

public class CateDao extends DBHelper{
	private static CateDao instance = new CateDao();
	public static CateDao getInstance () {
		return instance;
	}
	private CateDao (){}
	
	// logger
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void selectCate() {}
	// cate1 리스트 불러오기 - 구홍모 12/09
	public List<Cate1VO> selectCates_1() {
		List<Cate1VO> cate1s = new ArrayList<>();
		try {
			logger.info("selectCate_1 start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `km_product_cate1`");
			while(rs.next()) {
				Cate1VO cate1 = new Cate1VO();
				cate1.setCate1(rs.getInt(1));
				cate1.setC1Name(rs.getString(2));
				
				cate1s.add(cate1);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate1s;
	}
	// cate1에 해당하는 cate2 리스트 불러오기 - 구홍모 12/09
	public List<Cate2VO> selectCates_2() {
		List<Cate2VO> cate2s = new ArrayList<>();
		try {
			logger.info("selectCate_2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_product_cate2`");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
	// cate1에 해당하는 cate2 리스트 불러오기 - 구홍모 12/09
	public List<Cate2VO> selectCates_2(String cate1) {
		List<Cate2VO> cate2s = new ArrayList<>();
		try {
			logger.info("selectCate_2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_product_cate2` where `cate1`=?");
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setCate1(rs.getInt(1));
				cate2.setCate2(rs.getInt(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
	public void insertCate() {}
	public void updateCate() {}
	public void deleteCate() {}
	// 게시물 카테 리스트 불러오기
	public List<Cate2VO> selectArtiCates_2(String cate) {
		List<Cate2VO> cate2s = new ArrayList<>();
		try {
			logger.info("selectArtiCates_2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article_cate` where `cate`=?");
			psmt.setString(1, cate);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setArtiCate2(rs.getString(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
	// 게시물 카테 모든 리스트 불러오기
	public List<Cate2VO> selectArtiCates_2() {
		List<Cate2VO> cate2s = new ArrayList<>();
		try {
			logger.info("selectArtiCates_2 start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from `km_article_cate`");
			while(rs.next()) {
				Cate2VO cate2 = new Cate2VO();
				cate2.setArtiCate(rs.getString(1));
				cate2.setArtiCate2(rs.getString(2));
				cate2.setC2Name(rs.getString(3));
				
				cate2s.add(cate2);
			}
			close();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return cate2s;
	}
}
