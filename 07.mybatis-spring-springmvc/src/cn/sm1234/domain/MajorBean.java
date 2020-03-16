package cn.sm1234.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MajorBean {
	
	private int id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date setDate;
	private int deptId;
	private String deptName;
	private String des;
	
	
	
	
	
	@Override
	public String toString() {
		return "MajorBean [id=" + id + ", name=" + name + ", setDate=" + setDate + ", deptId=" + deptId + ", deptName="
				+ deptName + ", des=" + des + "]";
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

}
