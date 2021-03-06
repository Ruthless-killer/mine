package cn.sm1234.domain;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;




public class DeptBean {

	private int id;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date setdate;
	private String des;
	
	
	
	
	
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
	public Date getSetdate() {
		return setdate;
	}
	public void setSetdate(Date setdate) {
		this.setdate = setdate;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "DeptBean [id=" + id + ", name=" + name + ", setdate=" + setdate + ", des=" + des + "]";
	}
	
}
