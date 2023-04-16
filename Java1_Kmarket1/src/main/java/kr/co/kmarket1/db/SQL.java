package kr.co.kmarket1.db;

public class SQL {
	// sql은 공용으로 사용하기에 수정하시거나 추가하신 sql문은 주석을 달아주세요~////////////////////
	// select , insert , update , delete 순으로 뭉쳐서 작성해주면 보기 편해요.
	
	

	
	
	// Admin\ProductDao
	public static final String INSERT_PRODUCT = "INSERT INTO `km_product` SET "
												+ "`prodCate1` = ?, "
												+ "`prodCate2` = ?, "
												+ "`prodName` = ?, "
												+ "`descript` = ?, "
												+ "`company` = ?, "
												+ "`seller` = ?, "
												+ "`price` = ?, "
												+ "`discount` = ?, "
												+ "`point` = ?, "
												+ "`stock` = ?, "
												+ "`delivery` = ?, "
												+ "`thumb1` = ?, "
												+ "`thumb2` = ?, "
												+ "`thumb3` = ?, "
												+ "`detail` = ?, "
												+ "`status` = ?, "
												+ "`duty` = ?, "
												+ "`receipt` = ?, "
												+ "`bizType` = ?, "
												+ "`origin` = ?, "
												+ "`ip` = ?, "
												+ "`rdate`=NOW()";
	
	// admin list 상품 불러오기
	public static final String SELECT_ADMIN_PRODUCT_LIST = "SELECT * FROM `km_product` ORDER BY `prodNo` DESC LIMIT ?,10";
	public static final String SELECT_ADMIN_PRODUCT_LIST_SELLER = "SELECT * FROM `km_product` WHERE `seller`=? ORDER BY `prodNo` DESC LIMIT ?,10";
	public static final String SELECT_ADMIN_PRODUCT_LIST_SEARCH = "SELECT * from `km_product` WHERE ? LIKE ? ORDER BY `prodNo` DESC LIMIT 10";
	
	//리스트 페이지
	public static final String COUNT_LIST_TOTAL = "SELECT COUNT(*) FROM `km_product`";
	//리스트 페이지
	public static final String COUNT_LIST_TOTAL_SELLER = "SELECT COUNT(*) FROM `km_product` where `seller`=?";
	
	// admin list 삭제
	public static final String DELETE_ADMIN_LIST = "DELETE FROM `km_product` WHERE `prodNo`=?";
	// admin list 수정
	public static final String MODIFY_ADMIN_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	// admin 상품정보 수정
	public static final String UPDATE_ADMIN_PRODUCT = "UPDATE `km_product` "
														+ "SET `prodName`=?, `descript`=?, `company`=?, `seller`=?, `price`=?, `point`=?, `discount`=?, `stock`=?, `delivery`=?, `thumb1`=?, `thumb2`=?, `thumb3`=?, `detail`=?, `rdate`=now() "
														+ "WHERE `prodNo` = ?";
	// 선택삭제
	public static final String SELECT_DELETE = "DELETE FROM `km_product` WHERE `prodNo`=?";

	//member
	// terms 불러오기
	public static final String SELECT_TERMS = "SELECT * FROM `km_member_terms`";
	
	// 로그인 
	public static final String SELECT_USER = "select * from `km_member` where `uid`=? and `pass`=SHA2(?,256)";
	
	// 회원가입 - 개인 구매자 (insertMember)
	public static final String INSERT_MEMBER_NORMAL = "INSERT INTO `km_member` SET "
													+ "`uid`=?, "
													+ "`pass`=SHA2(?, 256), "
													+ "`name`=?, "
													+ "`gender`=?, "
													+ "`email`=?, "
													+ "`type`=?, "
													+ "`level`=?, "
													+ "`hp`=?, "
													+ "`zip`=?, "
													+ "`addr1`=?, "
													+ "`addr2`=?, "
													+ "`regip`=?, "
													+ "`locationTerms`=?, "
													+ "`rdate`= NOW()";

	// 회원가입 - 판매자 (insertSellerMember)
	public static final String INSERT_MEMBER_SELLER = "INSERT INTO `km_member` SET " 
													+ "`uid`=?, "
													+ "`pass`=SHA2(?, 256), "
													+ "`name`='판매자', "
													+ "`gender`='3', "
													+ "`hp`=?, "
													+ "`company`=?, "
													+ "`ceo`=?, "
													+ "`bizRegNum`=?, "
													+ "`comRegNum`=?, "
													+ "`tel`=?, "
													+ "`fax`=?, "
													+ "`email`=?, "
													+ "`zip`=?, "
													+ "`addr1`=?, "
													+ "`addr2`=?, "
													+ "`type`=?, "
													+ "`level`=?, "
													+ "`regip`=?, "
													+"`rdate`=NOW()";
													
													
	
	// 회원가입 - 관리자 
	public static final String INSERT_MEMBER_admin = "INSERT INTO `km_member` SET " 
													+ "`uid`=?, "
													+ "`pass`=SHA2(?, 256), "
													+ "`name`='?', "
													+ "`gender`='4', "
													+ "`hp`=?, "
													+ "`email`=?, "
													+ "`type`=3, "
													+ "`level`=7, "
													+ "`regip`=?, "
													+"`rdate`=NOW()";

	// 회원가입 - uid 중복체크 
	public static final String SELECT_COUNT_UID = "select count('uid') from `km_member` where `uid`=?";
	


	// product
	public static final String SELECT_COUNT_TOTAL = "select count(`prodNo`) from `km_product` where `prodCate1`=? and `prodCate2`=?";
	public static final String SELECT_COUNT_TOTAL_REVIEW = "SELECT COUNT(`revNo`) FROM `km_product_review` where `prodNo`=? ";

	public static final String SELECT_PRODUCT = "select * from `km_product` where `prodNo`=?";

	public static final String SELECT_PRODUCTS = "select * from `km_product` where `prodNo` in (?)";

	
	// product - 상품정렬
	public static final String SELECT_PRODUCTS_BY_SOLD = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `sold` desc limit ?, 10";
	public static final String SELECT_PRODUCTS_BY_LOW_PRICE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `price` asc limit ?, 10";
	public static final String SELECT_PRODUCTS_BY_HIGH_PRICE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `price` desc limit ?, 10";
	public static final String SELECT_PRODUCTS_BY_SCORE = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `score` desc limit ?, 10";
	public static final String SELECT_PRODUCTS_BY_REVIEW = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `review` desc limit ?, 10";
	public static final String SELECT_PRODUCTS_BY_NEW = "SELECT * FROM `km_product` WHERE `prodCate1`=? AND `prodCate2`=? "
													+ "order by `rdate` desc limit ?, 10";
	// product - 리뷰 보기
	public static final String SELECT_REVIEW = "SELECT a.*, b.`prodName` FROM `km_product_review` AS a "
													+"JOIN `km_product` as b ON a.prodNo = b.prodNo "
													+"where a.`prodNo`=? "
													+"ORDER BY `rdate` desc "
													+"LIMIT ?, 5";
	
	// product - 카트(장바구니)
	public static final String INSERT_CART = "insert into `km_product_cart` set "
												+ "`uid`=?, "
												+ "`prodNo`=?, "
												+ "`count`=?, "
												+ "`price`=?, "
												+ "`discount`=?, "
												+ "`point`=?, "
												+ "`delivery`=?, "
												+ "`total`=?, "
												+ "`rdate`=NOW()";
	// product - 장바구니 출력
	public static final String SELECT_CARTS_BY_UID = "SELECT a.*, b.`prodName`, b.`thumb1`, b.`descript`, b.`prodCate1`, b.`prodCate2` FROM `km_product_cart` AS a "
												+"JOIN `km_product` as b ON a.prodNo = b.prodNo where `uid`=?";
	public static final String SELECT_CARTS_BY_CARTNO = "SELECT a.*, b.`prodName`, b.`thumb1`, b.`descript`, b.`prodCate1`, b.`prodCate2` FROM `km_product_cart` AS a "
			+"JOIN `km_product` as b ON a.prodNo = b.prodNo where `cartNo` in (?)";
	// product - 장바구니 전체합계(total)
	
	public static final String SELECT_CART = "select * from `km_product_cart` where `prodNo` = ? and `uid`=?";
	
	// product - order(item)
	public static final String INSERT_ORDER_ITEM = "insert into `km_product_order_item` set "
												+ "`prodNo`=?, "
												+ "`count`=?, "
												+ "`price`=?, "
												+ "`discount`=?, "
												+ "`point`=?, "
												+ "`delivery`=?, "
												+ "`total`=?";
	// product - order
	public static final String INSERT_ORDER = "insert into `km_product_order` set "
												+ "`ordUid`=?, "
												+ "`ordCount`=?, "
												+ "`ordPrice`=?, "
												+ "`ordDiscount`=?, "
												+ "`ordDelivery`=?, "
												+ "`savePoint`=?, "
												+ "`usedPoint`=?, "
												+ "`ordTotPrice`=?, "
												+ "`recipName`=?, "
												+ "`recipHp`=?, "
												+ "`recipZip`=?, "
												+ "`recipAddr1`=?, "
												+ "`recipAddr2`=?, "
												+ "`ordPayment`=?, "
												+ "`ordComplete`=?, "
												+ "`ordDate`=NOW()";
	// ARTICLE
	public static final String INSERT_ARTICLE 	= "insert into `km_article` set "
												+ "`group`=?, "
												+ "`cate`=?, "
												+ "`cate2`=?, "
												+ "`title`=?, "
												+ "`content`=?, "
												+ "`uid`=?, "
												+ "`regip`=?, "
												+ "`rdate`=NOW()";
}
