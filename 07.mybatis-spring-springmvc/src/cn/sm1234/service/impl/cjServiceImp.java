package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.cjDao;
import cn.sm1234.dao.courseDao;
import cn.sm1234.dao.studentDao;
import cn.sm1234.dao.teacherDao;
import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankJudgeBean;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.chengji;
import cn.sm1234.service.cjService;
@Service("cjService")
public class cjServiceImp implements cjService {
	@Autowired
	private cjDao cjdao;
	@Autowired
	private studentDao studentdao;
	@Autowired
	private teacherDao teacherdao;
	@Autowired
	private courseDao coursedao;
	
	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		System.out.println("page="+pageSize);
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<chengji> qj=cjdao.selByPage(pageSize*(pageNumber-1), pageSize);
		for (chengji chengji : qj) {
			StudentBean s=studentdao.selBySid(chengji.getStudentid());
			chengji.setStudentname(s.getName());
			//TeacherBean t = teacherdao.selByTid(chengji.getTeacherid());
			CourseBean c = coursedao.selById(chengji.getCourseid());
			chengji.setCoursename(c.getName());
			
		}
		datagrid.setRows(qj);
		datagrid.setTotal(cjdao.selCount());
		return datagrid;
	}
	public ArrayList<chengji> showOne(int s) {
		// TODO Auto-generated method stub
		return cjdao.selBySid(s);
	}

}
