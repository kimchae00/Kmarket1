package kr.co.kmarket1.service;

import kr.co.kmarket1.dao.MemberDao;
import kr.co.kmarket1.vo.MemberVO;

public enum MemberService {
	// 싱글톤
	instance;
	
	private MemberDao dao = MemberDao.getInstance();
	
	public MemberVO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	

}
