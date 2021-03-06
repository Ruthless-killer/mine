package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.PoliticsClassDao;
import cn.sm1234.dao.studentDao;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;
import cn.sm1234.service.studentService;



@Service
public class studentServiceImpl implements studentService {
	@Autowired
	private studentDao studentdao;
	@Autowired
	private PoliticsClassDao politicsclassdao;

	public StudentBean login(User user) {
		//return null;
		// TODO Auto-generated method stub
		//System.out.println(user);
		return studentdao.findByUser(user);
	}

	public int saveStudent(StudentBean s) {
		// TODO Auto-generated method stub
		s.setClassid(1);
		s.setPowerid(1);
		if(s.getClassname()!=null) {
			String classname = s.getClassname();
			int classid=politicsclassdao.selByName(classname).getId();
			s.setClassid(classid);
			return studentdao.saveOne(s);
		}
		return 0;
	}

	public int update(StudentBean s) {
		// TODO Auto-generated method stub
		s.setClassid(1);
		s.setPowerid(1);
		if(s.getClassname()!=null) {
			String classname = s.getClassname();
			int classid=politicsclassdao.selByName(classname).getId();
			s.setClassid(classid);
			return studentdao.updateById(s);
		}
		
		return studentdao.updateById(s);
	}

	

	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		System.out.println("pageSize:"+pageSize);
		System.out.println("pageNumber:"+pageNumber);
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<StudentBean> stulist=studentdao.selByPage(pageSize*(pageNumber-1), pageSize);
		for (StudentBean studentBean : stulist) {
			System.out.println(studentBean);
		}
		if(stulist!=null) {
			for (StudentBean studentBean : stulist) {
				int classid = studentBean.getClassid();
				 PoliticsClassBean pcb = politicsclassdao.selById(classid);
				 String classn = pcb.getName();
				 studentBean.setClassname(classn);
			}
		}
		datagrid.setRows(stulist);
		datagrid.setTotal(studentdao.selCount());
		return datagrid;
	}

	public int delete(ArrayList<Integer> del) {
		// TODO Auto-generated method stub
		return studentdao.deleteById(del);
	}


	

}
