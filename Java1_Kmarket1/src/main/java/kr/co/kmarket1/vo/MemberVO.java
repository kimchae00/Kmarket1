package kr.co.kmarket1.vo;

public class MemberVO {
	public String uid;
	public String pass;
	public String name;
	public int gender;
	public String hp;
	public String email;
	public int type;
	public String point;
	public int level;
	public String zip;
	public String addr1;
	public String addr2;
	public String company;
	public String ceo;
	public String bizRegNum;
	public String comRegNum;
	public String tel;
	public String manager;
	public String managerHp;
	public String fax;
	public String regip;
	public String wdate;
	public String rdate;
	public int locationTerms;
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setGender(String gender) {
		this.gender = Integer.parseInt(gender);
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public void setType(String type) {
		this.type = Integer.parseInt(type);
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setLevel(String level) {
		this.level = Integer.parseInt(level);
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBizRegNum() {
		return bizRegNum;
	}
	public void setBizRegNum(String bizRegNum) {
		this.bizRegNum = bizRegNum;
	}
	public String getComRegNum() {
		return comRegNum;
	}
	public void setComRegNum(String comRegNum) {
		this.comRegNum = comRegNum;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManagerHp() {
		return managerHp;
	}
	public void setManagerHp(String managerHp) {
		this.managerHp = managerHp;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getLocationTerms() {
		return locationTerms;
	}
	public void setLocationTerms(int locationTerms) {
		this.locationTerms = locationTerms;
	}
	public void setLocationTerms(String locationTerms) {
		this.locationTerms = Integer.parseInt(locationTerms);
	}
	
	
	
}
