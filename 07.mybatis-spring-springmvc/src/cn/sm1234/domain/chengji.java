package cn.sm1234.domain;

public class chengji {
	private int id;
	private  int studentid;
	private String studentname;
	private int teacherid;
	private String teachername;
	private int courseid;
	private String coursename;
	private int grade;
	private String papername;
	
	
	
	

	@Override
	public String toString() {
		return "chengji [id=" + id + ", studentid=" + studentid + ", studentname=" + studentname + ", teacherid="
				+ teacherid + ", teachername=" + teachername + ", courseid=" + courseid + ", coursename=" + coursename
				+ ", grade=" + grade + ", papername=" + papername + "]";
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getPapername() {
		return papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	
}
