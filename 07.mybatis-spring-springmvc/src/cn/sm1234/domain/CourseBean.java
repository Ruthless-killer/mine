package cn.sm1234.domain;

public class CourseBean {
	private int id;
	private String name;
	private String des;
	
	
	
	
	
	@Override
	public String toString() {
		return "CourseBean [id=" + id + ", name=" + name + ", des=" + des + "]";
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
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}
