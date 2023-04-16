package kr.co.kmarket1.dao;

import kr.co.kmarket1.db.DBHelper;

public class ReviewDao extends DBHelper{
	private static ReviewDao instance = new ReviewDao();
	public static ReviewDao getInstance () {
		return instance;
	}
	private ReviewDao () {}
	
	public void selectReview () {}
	public void selectReviews () {}
	public void insertReview () {}
	public void updateReview () {}
	public void deleteReview () {}
}
