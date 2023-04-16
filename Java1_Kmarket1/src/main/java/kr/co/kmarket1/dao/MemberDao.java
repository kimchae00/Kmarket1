package kr.co.kmarket1.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.MemberVO;

public class MemberDao extends DBHelper{
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance () {
		return instance;
	}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private MemberDao () {}
	
	public MemberVO selectMember(String uid, String pass) {
		MemberVO vo = null;
		try {
			logger.info("selectUser start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_USER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVO();
				vo.setUid(rs.getString(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setGender(rs.getInt(4));
				vo.setHp(rs.getString(5));
				vo.setEmail(rs.getString(6));
				vo.setType(rs.getInt(7));
				vo.setPoint(rs.getString(8));
				vo.setLevel(rs.getInt(9));
				vo.setZip(rs.getString(10));
				vo.setAddr1(rs.getString(11));
				vo.setAddr2(rs.getString(12));
				vo.setCompany(rs.getString(13));
				vo.setCeo(rs.getString(14));
				vo.setBizRegNum(rs.getString(15));
				vo.setComRegNum(rs.getString(16));
				vo.setTel(rs.getString(17));
				vo.setManager(rs.getString(18));
				vo.setManagerHp(rs.getString(19));
				vo.setFax(rs.getString(20));
				vo.setRegip(rs.getString(21));
				vo.setWdate(rs.getString(22));
				vo.setRdate(rs.getString(23));
				vo.setLocationTerms(rs.getInt(24));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	public void selectMembers() {}
	
	public int selectCountUid(String uid) {
		int result = 0;
		try {
			logger.info("selectCountUid start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : "+ result);
		return result;
	}
	
	// 회원가입 
	//개인 회원가입
	public void insertMember(MemberVO vo) {
		try {
			logger.info("insertMember start..");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER_NORMAL);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getName());
			psmt.setInt(4, vo.getGender());
			psmt.setString(5, vo.getEmail());
			psmt.setInt(6, vo.getType());
			psmt.setInt(7, vo.getLevel());
			psmt.setString(8, vo.getHp());
			psmt.setString(9, vo.getZip());
			psmt.setString(10, vo.getAddr1());
			psmt.setString(11, vo.getAddr2());
			psmt.setString(12, vo.getRegip());
			psmt.setInt(13, vo.getLocationTerms());
			
			psmt.executeUpdate();
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	
	}
	
	
	public void insertSellerMember(MemberVO vo){
		try {
			logger.info("insertSellerMember start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_MEMBER_SELLER);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getPass());
			psmt.setString(3, vo.getHp());
			psmt.setString(4, vo.getCompany());
			psmt.setString(5, vo.getCeo());
			psmt.setString(6, vo.getBizRegNum());
			psmt.setString(7, vo.getComRegNum());
			psmt.setString(8, vo.getTel());
			psmt.setString(9, vo.getFax());
			psmt.setString(10, vo.getEmail());
			psmt.setString(11, vo.getZip());
			psmt.setString(12, vo.getAddr1());
			psmt.setString(13, vo.getAddr2());
			psmt.setInt(14, vo.getType());
			psmt.setInt(15, vo.getLevel());
			psmt.setString(16, vo.getRegip());
			
			
			psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	
	public void updateMember() {}
	public void deleteMember() {}
	
	
}
