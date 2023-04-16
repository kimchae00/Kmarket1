package kr.co.kmarket1.dao;

import kr.co.kmarket1.db.DBHelper;

public class PointDao extends DBHelper{
	private static PointDao instance = new PointDao();
	public static PointDao getInstance () {
		return instance;
	}
	private PointDao () {}
	
	public void selectPoint() {}
	public void selectPoints() {}
	public void insertPoint() {}
	public void updatePoint() {}
	public void deletePoint() {}
}
