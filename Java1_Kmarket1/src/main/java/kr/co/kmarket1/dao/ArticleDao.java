package kr.co.kmarket1.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket1.db.DBHelper;
import kr.co.kmarket1.db.SQL;
import kr.co.kmarket1.vo.ArticleVO;

public class ArticleDao extends DBHelper{
	private static ArticleDao instance = new ArticleDao();
	public static ArticleDao getInstance () {
		return instance;
	}
	public ArticleDao () {}
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	// 기본 CRUD
	// 게시물 글보기
	public ArticleVO selectArticle(String no) {
		logger.info("selectArticle start...");
		ArticleVO article = new ArticleVO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article` where `no`=?");
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setCate2(rs.getString(6));
				article.setTitle(rs.getString(7));
				article.setContent(rs.getString(8));
				article.setFile(rs.getInt(9));
				article.setHit(rs.getInt(10));
				article.setUid(rs.getString(11));
				article.setRegip(rs.getString(12));
				article.setRdate(rs.getString(13));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return article;
	}
	// 답변 불러오기
	public ArticleVO selectReply(String no) {
		logger.info("selectReply start...");
		ArticleVO article = new ArticleVO();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article` where `parent`=?");
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				article.setContent(rs.getString(8));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return article;
	}
	// 그룹별 리스트 불러오기
	public List<ArticleVO> selectArticlesByGroup(String group,int start) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByGroup start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article` where `group`=? and `parent`=0 ORDER BY `no` DESC LIMIT ?,10;");
			psmt.setString(1, group);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	// CS인덱스용 리스트 불러오기
	public List<ArticleVO> selectArticlesByGroupIdxQ(String group, int top) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByGroupIdxQ start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select a.*,b.c2Name from `km_article` as a join `km_article_cate` as b on a.cate2=b.cate2 where `group`=? and `parent`=0 ORDER BY `no` DESC LIMIT ?");
			psmt.setString(1, group);
			psmt.setInt(2, top);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				article.setC2Name(rs.getString(14));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	public List<ArticleVO> selectArticlesByGroupIdxN(String group, int top) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByGroupIdxN start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article` where `group`=? and `parent`=0 ORDER BY `no` DESC LIMIT ?");
			psmt.setString(1, group);
			psmt.setInt(2, top);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	// 공지사항 리스트 불러오기 
	public List<ArticleVO> selectArticlesByCateN(String group, String cate, int top) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByCateN start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * from `km_article` where `group`=? AND `cate`=? and `parent`=0 ORDER BY `no` DESC LIMIT ?,10");
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setInt(3, top);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setComment(rs.getInt(3));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setCate2(rs.getString(6));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	// 문의하기 리스트 불러오기 
	public List<ArticleVO> selectArticlesByCate(String group, String cate, int top) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByCate start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT a.*,b.c2Name from `km_article` AS a JOIN `km_article_cate` AS b ON a.cate2=b.cate2  where `group`=? AND a.cate=? and `parent`=0 ORDER BY `no` DESC LIMIT ?,10");
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setInt(3, top);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setComment(rs.getInt(3));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setCate2(rs.getString(6));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				article.setC2Name(rs.getString(14));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	// 자주묻는질문 및 문의하기 리스트 불러오기
	public List<ArticleVO> selectArticlesByCate2(String group,String cate, String cate2, int top) {
		List<ArticleVO> articles = new ArrayList<>();
		try {
			logger.info("selectArticlesByCate2 start...");
			conn = getConnection();
			psmt = conn.prepareStatement("select * from `km_article` where `group`=? AND `cate`=? AND `cate2`=? and `parent`=0 ORDER BY `no` DESC LIMIT ?,10;");
			psmt.setString(1, group);
			psmt.setString(2, cate);
			psmt.setString(3, cate2);
			psmt.setInt(4, top);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ArticleVO article = new ArticleVO();
				article.setNo(rs.getInt(1));
				article.setComment(rs.getInt(3));
				article.setGroup(rs.getString(4));
				article.setCate(rs.getString(5));
				article.setCate2(rs.getString(6));
				article.setTitle(rs.getString(7));
				article.setUid(rs.getString(11).substring(0,3));
				article.setRdate(rs.getString(13).substring(2,10));
				
				articles.add(article);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	// 전체 게시물 카운트(2차 카테고리 O)
	public int selectCountTotal(String cate, String cate2, String group) {
		int total = 0;
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(`no`) FROM `km_article` where `parent`=0 and `cate`=? and `cate2`=? and `group`=?");
			psmt.setString(1, cate);
			psmt.setString(2, cate2);
			psmt.setString(3, group);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	// 전체 게시물 카운트(카테고리 O)
	public int selectCountTotal(String cate, String group) {
		int total = 0;
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(`no`) FROM `km_article` where `parent`=0 and `cate`=? and `group`=?");
			psmt.setString(1, cate);
			psmt.setString(2, group);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	// 전체 게시물 카운트(카테고리 X)
	public int selectCountTotal(String group) {
		int total = 0;
		try {
			logger.info("selectCountTotal start...");
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT COUNT(`no`) FROM `km_article` where `parent`=0 and `group`=?");
			psmt.setString(1, group);
			rs = psmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return total;
	}
	// 게시물 작성
	public void insertArticle(ArticleVO vo) {
		try {
			logger.info("insertArticle start...");
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_ARTICLE);
			psmt.setString(1, vo.getGroup());
			psmt.setString(2, vo.getCate());
			psmt.setString(3, vo.getCate2());
			psmt.setString(4, vo.getTitle());
			psmt.setString(5, vo.getContent());
			psmt.setString(6, vo.getUid());
			psmt.setString(7, vo.getRegip());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	// 답변 작성
	public int insertReply(ArticleVO vo) {
		int result = 0;
		try {
			logger.info("insertReply start...");
			conn = getConnection();
			conn.setAutoCommit(false); // 트렌젝션 시작
			psmt = conn.prepareStatement("insert into `km_article` set `parent`=?,`uid`=?,`content`=?,`regip`=?,`rdate`=now()");
			psmt.setInt(1, vo.getNo());
			psmt.setString(2, vo.getUid());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getRegip());
			result = psmt.executeUpdate();
			PreparedStatement psmt2 = conn.prepareStatement("UPDATE `km_article` SET `comment`=`comment`+1 WHERE `no`=?");
			psmt2.setInt(1, vo.getNo());
			psmt2.executeUpdate();
			conn.commit();			// 트렌젝션 끝 All or Nothing
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	// 게시물 수정
	public void updateArticle(ArticleVO vo) {
		try {
			logger.info("updateArticle start...");
			conn = getConnection();
			psmt = conn.prepareStatement("update `km_article` set `title`=?,`content`=?,`cate`=?,`rdate`=now() where `no`=?");
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getCate());
			psmt.setInt(4, vo.getNo());
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	// 조회수 업데이트
	public void updateArticleHit(String no) {
		logger.info("updateArticleHit start...");
		try{
			conn = getConnection();
			psmt = conn.prepareStatement("update `km_article` set `hit` = `hit` + 1 where `no`=?");
			psmt.setString(1, no);
			psmt.executeUpdate();
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	// 게시물 삭제
	public void deleteArticle(String no) {
		try {
			logger.info("deleteArticle start...");
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `km_article` WHERE `no`=? or `parent`=?");
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	// 게시물 선택 삭제
	public int deleteArticleByChk(String chks) {
		int result = 0;
		try {
			logger.info("deleteArticle start...");
			conn = getConnection();
			psmt = conn.prepareStatement("DELETE FROM `km_article` WHERE `no` in (?) or `parent` in (?)");
			psmt.setString(1, chks);
			psmt.setString(2, chks);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
}
