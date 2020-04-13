package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.courseDao;
import cn.sm1234.dao.judgeDao;
import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankJudgeBean;
import cn.sm1234.domain.QuestionBankSelectBean;
import cn.sm1234.service.judgeService;

@Service("judgeService")
public class judgeServiceImp implements judgeService {
	@Autowired
	private judgeDao judgedao;
	@Autowired
	private courseDao coursedao;
	
	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<QuestionBankJudgeBean> qj=judgedao.selByPage(pageSize*(pageNumber-1), pageSize);
		if(qj!=null&&qj.size()!=0) {
			for (QuestionBankJudgeBean questionBankJudgeBean : qj) {
				int courseid = questionBankJudgeBean.getCourseid();
				String coursename=coursedao.selById(courseid).getName();
				questionBankJudgeBean.setCoursename(coursename);
			}
			
		}
		datagrid.setRows(qj);
		datagrid.setTotal(judgedao.selCount());
		return datagrid;
	}

	public int saveOne(QuestionBankJudgeBean questionjudge) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(QuestionBankJudgeBean questionjudge) {
		// TODO Auto-generated method stub
		questionjudge.setCourseid(1);
		System.out.println(questionjudge);
		if(questionjudge.getCoursename()!=null||!questionjudge.getCoursename().equals("")) {
			CourseBean c=coursedao.selByName(questionjudge.getCoursename());
			System.out.println(c);
			int cid = c.getId();
			questionjudge.setCourseid(cid);
			System.out.println(questionjudge);
			return judgedao.update(questionjudge);
		}
		return 0;
	}

	public int selcount(int judgenumber) {
		// TODO Auto-generated method stub
		return judgedao.selCount();
	}

	public ArrayList<QuestionBankJudgeBean> selAll() {
		// TODO Auto-generated method stub
		return judgedao.selAll();
	}

	public ArrayList<QuestionBankJudgeBean> selAllByName(String coursename) {
		// TODO Auto-generated method stub
		CourseBean c=coursedao.selByName(coursename);
		int cid = c.getId();
		return judgedao.selAllByCId(cid);
	}

}
