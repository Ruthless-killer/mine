package cn.sm1234.domain;

public class QuestionBankJudgeBean {
	private int id;
	private String question;
	private int answer;
	private String teachername;
	private int courseid;
	private String coursename;
	
	
	
	@Override
	public String toString() {
		return "QuestionBankJudgeBean [id=" + id + ", question=" + question + ", answer=" + answer + ", teachername="
				+ teachername + ", courseid=" + courseid + ", coursename=" + coursename + "]";
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

}
