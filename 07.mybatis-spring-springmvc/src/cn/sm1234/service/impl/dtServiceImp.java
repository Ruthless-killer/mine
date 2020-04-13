package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.chengjiDao;
import cn.sm1234.dao.dtDao;
import cn.sm1234.dao.paperjudgeDao;
import cn.sm1234.dao.paperselectDao;
import cn.sm1234.domain.PaperBean;
import cn.sm1234.domain.PaperJudgeBean;
import cn.sm1234.domain.PaperSelectBean;
import cn.sm1234.domain.chengji;
import cn.sm1234.service.dtService;
@Service("dtService")
public class dtServiceImp implements dtService {

	@Autowired
	private paperselectDao paperselectdao;
	@Autowired
	private paperjudgeDao paperjudgedao;
	@Autowired
	private chengjiDao chengjidao;
	public HashMap<String , Integer> selBySid(int sid) {
		// TODO Auto-generated method stub
		//ArrayList<String> papern  = new ArrayList<String>();
		HashMap<String , Integer> p = new HashMap<String , Integer>();
		
		ArrayList<PaperSelectBean> ps =paperselectdao.selBySid(sid);
		if(ps.size()!=0) {
			for (PaperSelectBean paperSelectBean : ps) {
				p.put( paperSelectBean.getPapername(),paperSelectBean.getCourseid());
			}
		}
		ArrayList<PaperJudgeBean> pd = paperjudgedao.selBySid(sid);
		if(pd.size()!=0) {
			for (PaperJudgeBean paperJudgeBean : pd) {
				p.put( paperJudgeBean.getPapername(),paperJudgeBean.getCourseid());
			}
		}
//		for (Map.Entry<String , Integer> entry : p.entrySet()) {
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//		}
		return p;
	}
	public ArrayList<PaperBean> takepapaer(String papername, int courseid) {
		// TODO Auto-generated method stub
		ArrayList<PaperBean>  pb = new ArrayList<PaperBean>();
		ArrayList<PaperSelectBean> ps=paperselectdao.selByNAC(papername,courseid);
		for (PaperSelectBean paperSelectBean : ps) {
			PaperBean p = new PaperBean();
			p.setCourseid(paperSelectBean.getCourseid());
			p.setGetscore(paperSelectBean.getGetscore());
			p.setId(paperSelectBean.getId());
			p.setModelanswer(paperSelectBean.getModelanswer());
			p.setPapername(paperSelectBean.getPapername());
			p.setQuestion(paperSelectBean.getQuestion());
			p.setScore(paperSelectBean.getScore());
			p.setStudentanswer(paperSelectBean.getStudentanswer());
			p.setStudentid(paperSelectBean.getStudentid());
			p.setTeachername(paperSelectBean.getTeachername());
			p.setType(1);
			pb.add(p);
		}
		ArrayList<PaperJudgeBean>  pd=paperjudgedao.selByNAC(papername,courseid);
		for (PaperJudgeBean paperJudgeBean : pd) {
			PaperBean p = new PaperBean();
			p.setCourseid(paperJudgeBean.getCourseid());
			p.setGetscore(paperJudgeBean.getGetscore());
			p.setId(paperJudgeBean.getId());
			p.setModelanswer(paperJudgeBean.getModelanswer());
			p.setPapername(paperJudgeBean.getPapername());
			p.setQuestion(paperJudgeBean.getQuestion());
			p.setScore(paperJudgeBean.getScore());
			p.setStudentanswer(paperJudgeBean.getStudentanswer());
			p.setStudentid(paperJudgeBean.getStudentid());
			p.setTeachername(paperJudgeBean.getTeachername());
			p.setType(2);
			pb.add(p);
		}
		return pb;
	}
	
	public int answer(String[] question, String[] answer, String[] judquestion, String[] judanswer,String papername,int studentid) {
		
		// TODO Auto-generated method stub
		int chengji = 0;
		for (int i=0;i<question.length;i++) {
			PaperSelectBean  ps=paperselectdao.selByq(question[i]+"%");
			String q = ps.getQuestion();
			System.out.println("answer[i]"+answer[i]);
			System.out.println("ps.getModelanswer()"+ps.getModelanswer());
			System.out.println("ps.getScore()"+ps.getScore());
			if(answer[i].equals(ps.getModelanswer()+"")) {
				paperselectdao.updateAS(answer[i],papername,studentid,q);
				chengji = chengji+ps.getScore();
				System.out.println(chengji+"aaaaaaaaa");
			}else {
				paperselectdao.updateAS(answer[i],papername,studentid,q);
				chengji+=0;
			}
		}
		for (int i=0;i<judquestion.length;i++) {
			PaperJudgeBean  pd=paperjudgedao.selByq(judquestion[i]+"%");
			String q = pd.getQuestion()+"%";
			if(judanswer[i].equals(pd.getModelanswer()+"")) {
				paperjudgedao.updateAS(judanswer[i],papername,studentid,q);
				chengji+=pd.getScore();
				
			}else {
				
				paperjudgedao.updateAS(judanswer[i],papername,studentid,q);
				chengji+=0;
			}
		}
		System.out.println("chengji 是"+chengji);
		return chengji;
	}
	public int savescore(chengji c) {
		// TODO Auto-generated method stub
		return chengjidao.savescore(c);
	}

}
