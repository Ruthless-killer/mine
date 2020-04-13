package cn.sm1234.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.PoliticsClassDao;
import cn.sm1234.dao.paperjudgeDao;
import cn.sm1234.dao.paperselectDao;
import cn.sm1234.dao.pickDao;
import cn.sm1234.dao.studentDao;
import cn.sm1234.domain.PaperJudgeBean;
import cn.sm1234.domain.PaperSelectBean;
import cn.sm1234.domain.Pick;
import cn.sm1234.service.ctService;
@Service("ctService")
public class ctServiceImp implements ctService {

	@Autowired
	private pickDao pickdao;
	@Autowired
	private studentDao studentdao;
	@Autowired
	private paperselectDao paperselectdao;
	@Autowired
	private paperjudgeDao paperjudgedao;
	public int saveSelq(PaperSelectBean ps) {
		// TODO Auto-generated method stub
		ArrayList<Pick> p=pickdao.selById(ps.getCourseid());//获取上这个课的所有班级
		for (Pick pick : p) {
			int cid = pick.getClassid();//获取到班级id
			ArrayList<Integer> sid = studentdao.selByCid(cid);//获取到班级的所有学生
			for (int studentid : sid) {
				ps.setStudentid(studentid);
				return paperselectdao.saveSelq(ps);
			}
			
		}
		
		return 0;
	}
	public int saveJudq(PaperJudgeBean ps) {
		// TODO Auto-generated method stub
		ArrayList<Pick> p=pickdao.selById(ps.getCourseid());//获取上这个课的所有班级
		for (Pick pick : p) {
			int cid = pick.getClassid();//获取到班级id
			ArrayList<Integer> sid = studentdao.selByCid(cid);//获取到班级的所有学生
			for (int studentid : sid) {
				ps.setStudentid(studentid);
				return paperjudgedao.saveJudq(ps);
			}
			
		}
		return 0;
	}
	

}
