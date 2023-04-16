package kr.co.kmarket1.vo;

public class ArticleVO {
	private int no;
	private int parent; 
	private int comment;
	private String cate;
	private String cate2;
	private String title;
	private String group;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	
	private String nick;
	
	private int fno;
	private String oriName;
	private int download;
	
	private String fname;
	
	private String c2Name;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setNo(String no) {
		this.no = Integer.parseInt(no);
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public void setParent(String parent) {
		this.parent = Integer.parseInt(parent);
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getFno() {
		return fno;
	}
	
	public void setFno(int fno) {
		this.fno = fno;
	}
	
	public String getOriName() {
		return oriName;
	}
	
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	
	public int getDownload() {
		return download;
	}
	
	public void setDownload(int download) {
		this.download = download;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getCate2() {
		return cate2;
	}
	
	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}
	
	public String getC2Name() {
		return c2Name;
	}
	
	public void setC2Name(String c2Name) {
		this.c2Name = c2Name;
	}
}
