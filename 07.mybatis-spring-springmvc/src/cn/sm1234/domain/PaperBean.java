package cn.sm1234.domain;

public class PaperBean {
	private int id;
	private String papername;
	private String question;
	private int modelanswer;
	private String teachername;
	private int studentid;
	private int courseid;
	private int studentanswer;
	private int score;
	private int getscore;
	
	private int type;
	
	
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "PaperBean [id=" + id + ", papername=" + papername + ", question=" + question + ", modelanswer="
				+ modelanswer + ", teachername=" + teachername + ", studentid=" + studentid + ", courseid=" + courseid
				+ ", studentanswer=" + studentanswer + ", score=" + score + ", getscore=" + getscore + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public int getGetscore() {
		return getscore;
	}
	public void setGetscore(int getscore) {
		this.getscore = getscore;
	}
	public void setModelanswer(int modelanswer) {
		this.modelanswer = modelanswer;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public void setStudentanswer(int studentanswer) {
		this.studentanswer = studentanswer;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getPapername() {
		return papername;
	}
	public void setPapername(String papername) {
		this.papername = papername;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getModelanswer() {
		return modelanswer;
	}
	public int getStudentid() {
		return studentid;
	}
	public int getStudentanswer() {
		return studentanswer;
	}
	public int getScore() {
		return score;
	}
	
	
	

}
