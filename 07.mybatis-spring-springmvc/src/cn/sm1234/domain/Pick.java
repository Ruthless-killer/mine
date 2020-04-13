package cn.sm1234.domain;

public class Pick {
	private  int id;
	private  int classid;
	private  int courseid;
	private  String des;
	
	
	
	
	
	@Override
	public String toString() {
		return "Pick [id=" + id + ", classid=" + classid + ", courseid=" + courseid + ", des=" + des + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	
	

}
