package kr.co.kmarket1.vo;
/*
 * cate1	TINYINT(4)		
 * cate2	TINYINT(4)		
 * c2Name	VARCHAR(20)		
 */
public class Cate2VO {
	private int cate1;
	private int cate2;
	private String c2Name;
	
	private String artiCate;
	private String artiCate2;
	
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public int getCate2() {
		return cate2;
	}
	public void setCate2(int cate2) {
		this.cate2 = cate2;
	}
	public String getC2Name() {
		return c2Name;
	}
	public void setC2Name(String c2Name) {
		this.c2Name = c2Name;
	}
	
	public String getArtiCate2() {
		return artiCate2;
	}
	
	public void setArtiCate2(String artiCate2) {
		this.artiCate2 = artiCate2;
	}
	
	public String getArtiCate() {
		return artiCate;
	}
	
	public void setArtiCate(String artiCate) {
		this.artiCate = artiCate;
	}
}
