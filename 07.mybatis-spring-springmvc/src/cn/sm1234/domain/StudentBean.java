package cn.sm1234.domain;

import java.util.Date;

public class StudentBean {
	
	private int id;
	private String sno;
	private String name;
	private String sex;
	private Date birthday;
	private String nation;
	private String tel;
	private String email;
	private String address;
	private String password;
	private int classid;
	private String classname;
	private int powerid;
	private String des;
	
	
	
	
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", sno=" + sno + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday
				+ ", nation=" + nation + ", tel=" + tel + ", email=" + email + ", address=" + address + ", password="
				+ password + ", classid=" + classid + ", classname=" + classname + ", powerid=" + powerid + ", des="
				+ des + "]";
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getPowerid() {
		return powerid;
	}
	public void setPowerid(int powerid) {
		this.powerid = powerid;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

}
