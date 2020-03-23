package cn.sm1234.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.teacherDao;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;
import cn.sm1234.service.teacherService;


@Service
public class teacherServiceImp implements teacherService {
	@Autowired
	private teacherDao teacherdao;

	public TeacherBean login(User user) {
		//System.out.println(user);
		// TODO Auto-generated method stub
		if(user.getUserType().equals("js")) {
			return	teacherdao.findByUsername(user);
		}else {
			return	teacherdao.findByUsernameG(user);
		}
		//return null;
	}
	
	
	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<TeacherBean> teacherlist=teacherdao.selByPage(pageSize*(pageNumber-1), pageSize);
//		System.out.println(majorlist.size());
//		for(int i=0;i<majorlist.size();i++) {
//			System.out.println(majorlist.get(i));
//		}
		datagrid.setRows(teacherlist);
		datagrid.setTotal(teacherdao.selCount());
		return datagrid;
	}


	public int update(TeacherBean teacher) {
		// TODO Auto-generated method stub
		if(teacher!=null&&teacher.getPosition()!=null) {
			if(teacher.getPosition().equals("管理员")) {
				teacher.setPowerid(3);
				return teacherdao.update(teacher);
			}else if(teacher.getPosition().equals("教师")) {
				teacher.setPowerid(2);
				return teacherdao.update(teacher);
			}
		}
		return teacherdao.update(teacher);
	}


	public int saveOne(TeacherBean teacher) {
		// TODO Auto-generated method stub
		if(teacher!=null&&teacher.getPosition()!=null) {
			if(teacher.getPosition().equals("管理员")) {
				teacher.setPowerid(3);
				return teacherdao.saveOne(teacher);
			}else if(teacher.getPosition().equals("教师")) {
				teacher.setPowerid(2);
				return teacherdao.saveOne(teacher);
			}
		}
		return teacherdao.saveOne(teacher);
	}
	

}
