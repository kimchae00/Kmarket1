package kr.co.kmarket1.vo;

public class CartVO {
	int cartNo;
	String uid;
	int prodNo;
	int count;
	int price;
	int discount;
	int point;
	int delivery;
	int total;
	String rdate;
	
	// 추가 필드
	String prodName;
	String thumb1;
	String descript;
	int prodCate1;
	int prodCate2;
	
	public int getProdCate1() {
		return prodCate1;
	}
	public void setProdCate1(int prodCate1) {
		this.prodCate1 = prodCate1;
	}
	public int getProdCate2() {
		return prodCate2;
	}
	public void setProdCate2(int prodCate2) {
		this.prodCate2 = prodCate2;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getThumb1() {
		return thumb1;
	}
	public void setThumb1(String thumb1) {
		this.thumb1 = thumb1;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public void setCartNo(String cartNo) {
		this.cartNo = Integer.parseInt(cartNo);
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = Integer.parseInt(prodNo);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setCount(String count) {
		this.count = Integer.parseInt(count);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setDiscount(String discount) {
		this.discount = Integer.parseInt(discount);
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setPoint(String point) {
		this.point = Integer.parseInt(point);
	}
	public int getDelivery() {
		return delivery;
	}
	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = Integer.parseInt(delivery);
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
}
