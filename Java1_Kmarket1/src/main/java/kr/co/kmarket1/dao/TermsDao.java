package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.TermsVO;

public class TermsDao extends DBHelper{
	private static TermsDao instance = new TermsDao();
	public static TermsDao getInstance () {
		return instance;
	}
	private TermsDao () {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public TermsVO selectTermsNormal () {
		TermsVO vo = null;
		
		try {
			logger.info("selectTermsNormal start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);
			
			if(rs.next()) {
				vo = new TermsVO();
				vo.setTerms(rs.getString(1));
				vo.setPrivacy(rs.getString(2));
				vo.setLocation(rs.getString(3));
				vo.setFinance(rs.getString(4));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	
	public TermsVO selectTermsSeller () {
		TermsVO vo = null;
		
		try {
			logger.info("selectTermsSeller start...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_TERMS);
			
			if(rs.next()) {
				vo = new TermsVO();
				vo.setPrivacy(rs.getString(2));
				vo.setLocation(rs.getString(3));
				vo.setFinance(rs.getString(4));
				vo.setTax(rs.getString(5));
			}
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	public void insertTerms () {}
	public void updateTerms () {}
	public void deleteTerms () {}
}
