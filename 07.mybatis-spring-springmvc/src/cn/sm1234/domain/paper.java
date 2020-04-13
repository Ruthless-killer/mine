package cn.sm1234.domain;

public class paper {
	private String papername;
	private String coursename;
	private int selectnumber;
	private int selectscore;
	private int judgenumber;
	private int judgescore;
	
	
	@Override
	public String toString() {
		return "paper [papername=" + papername + ", coursename=" + coursename + ", selectnumber=" + selectnumber
				+ ", selectscore=" + selectscore + ", judgenumber=" + judgenumber + ", judgescore=" + judgescore + "]";
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
	public int getSelectnumber() {
		return selectnumber;
	}
	public void setSelectnumber(int selectnumber) {
		this.selectnumber = selectnumber;
	}
	public int getSelectscore() {
		return selectscore;
	}
	public void setSelectscore(int selectscore) {
		this.selectscore = selectscore;
	}
	public int getJudgenumber() {
		return judgenumber;
	}
	public void setJudgenumber(int judgenumber) {
		this.judgenumber = judgenumber;
	}
	public int getJudgescore() {
		return judgescore;
	}
	public void setJudgescore(int judgescore) {
		this.judgescore = judgescore;
	}
	
	
	

}
