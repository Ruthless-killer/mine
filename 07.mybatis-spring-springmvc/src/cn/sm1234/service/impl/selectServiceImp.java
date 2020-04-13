package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.courseDao;
import cn.sm1234.dao.selectDao;
import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankSelectBean;
import cn.sm1234.service.selectService;
@Service("selectService")
public class selectServiceImp implements selectService {
	@Autowired
	private selectDao selectdao;
	@Autowired
	private courseDao coursedao;
	public int saveOne(QuestionBankSelectBean questionselect) {
		// TODO Auto-generated method stub
		questionselect.setCourseid(1);
		System.out.println(questionselect);
		if(questionselect.getCoursename()!=null||!questionselect.getCoursename().equals("")) {
			CourseBean c=coursedao.selByName(questionselect.getCoursename());
			int cid = c.getId();
			questionselect.setCourseid(cid);
			System.out.println(questionselect);
			return selectdao.saveOne(questionselect);
		}
		return 0;
	}

	public int update(QuestionBankSelectBean questionselect) {
		// TODO Auto-generated method stub
		questionselect.setCourseid(1);
		System.out.println(questionselect);
		if(questionselect.getCoursename()!=null||!questionselect.getCoursename().equals("")) {
			CourseBean c=coursedao.selByName(questionselect.getCoursename());
			int cid = c.getId();
			questionselect.setCourseid(cid);
			System.out.println(questionselect);
			return selectdao.update(questionselect);
		}
		return 0;
	}

	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<QuestionBankSelectBean> qs=selectdao.selByPage(pageSize*(pageNumber-1), pageSize);
		if(qs!=null&&qs.size()!=0) {
			for (QuestionBankSelectBean questionBankSelectBean : qs) {
				int courseid = questionBankSelectBean.getCourseid();
				String coursename=coursedao.selById(courseid).getName();
				questionBankSelectBean.setCoursename(coursename);
			}
		}
		datagrid.setRows(qs);
		datagrid.setTotal(selectdao.selCount());
		return datagrid;
	}

	public int selcount(int selectnumber) {
		// TODO Auto-generated method stub
		return selectdao.selCount();
	}

	public int delete(ArrayList<Integer> al) {
		// TODO Auto-generated method stub
		return selectdao.deleteById(al);
	}

	public ArrayList<QuestionBankSelectBean> selAll() {
		// TODO Auto-generated method stub
		return selectdao.selAll();
	}

	public ArrayList<QuestionBankSelectBean> selAllByName(String coursename) {
		// TODO Auto-generated method stub
		CourseBean c=coursedao.selByName(coursename);
		System.out.println(c);
		int cid = c.getId();
		return selectdao.selAllByCId(cid);
	}

}
