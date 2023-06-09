package kr.co.kmarket1.vo;
/*
 * prodNo		INT(11)
 * prodCate1	TINYINT(4)
 * prodCate2	TINYINT(4)
 * prodName		VARCHAR(100)
 * descript		VARCHAR(100)
 * company		VARCHAR(100)
 * seller		VARCHAR(20)
 * price		INT(11)
 * discount		TINYINT(4)
 * point		INT(11)
 * stock		INT(11)
 * sold			INT(11)
 * delivery		INT(11)
 * hit			INT(11)
 * score		TINYINT(4)
 * review		INT(4)
 * thumb1		VARCHAR(255)
 * thumb2		VARCHAR(255)
 * thumb3		VARCHAR(255)
 * detail		VARCHAR(255)
 * status		VARCHAR(20)
 * duty			VARCHAR(20)
 * receipt		VARCHAR(255)
 * bizType		VARCHAR(20)
 * origin		VARCHAR(20)
 * ip			VARCHAR(20)
 * rdate		DATETIME
 */
public class ProductVO {
	private	int prodNo;
	private int prodCate1;
	private int prodCate2;
	private String prodName;
	private String descript;
	private String company;
	private String seller;
	private int price;
	private int discount;
	private int point;
	private int stock;
	private int sold;
	private int delivery;
	private int hit;
	private int score;
	private int review;
	private String thumb1;
	private String thumb2;
	private String thumb3;
	private String detail;
	private String status;
	private String duty;
	private String receipt;
	private String bizType;
	private String origin;
	private String ip;
	private String rdate;
	private int disPrice;
	
	public int getDisPrice() {
		return disPrice;
	}
	public void setDisPrice(int disPrice) {
		this.disPrice = disPrice;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public void setDiscount(String discount) {
	this.discount = Integer.parseInt(discount);
	}
	public void setStock(String stock) {
		this.stock = Integer.parseInt(stock);
	}
	public void setPoint(String point) {
		this.point = Integer.parseInt(point);
	}
	public void setDelivery(String delivery) {
		this.delivery = Integer.parseInt(delivery);
	}
	
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public int getProdCate1() {
		return prodCate1;
	}
	public void setProdCate1(int prodCate1) {
		this.prodCate1 = prodCate1;
	}
	public void setProdCate1(String prodCate1) { // string을 매개변수로 받기위해 오버로딩
		this.prodCate1 = Integer.parseInt(prodCate1);
	}
	public int getProdCate2() {
		return prodCate2;
	}
	public void setProdCate2(int prodCate2) {
		this.prodCate2 = prodCate2;
	}
	public void setProdCate2(String prodCate2) { // string을 매개변수로 받기위해 오버로딩
		this.prodCate2 = Integer.parseInt(prodCate2);
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1;
	}
	public String getThumb2() {
		return thumb2;
	}
	public void setThumb2(String thumb2) {
		this.thumb2 = thumb2;
	}
	public String getThumb3() {
		return thumb3;
	}
	public void setThumb3(String thumb3) {
		this.thumb3 = thumb3;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
	
}
