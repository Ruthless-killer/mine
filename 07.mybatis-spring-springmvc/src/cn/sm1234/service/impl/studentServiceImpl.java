package cn.sm1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.studentDao;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;
import cn.sm1234.service.studentService;



@Service
public class studentServiceImpl implements studentService {
	@Autowired
	private studentDao studentdao;

	public StudentBean login(User user) {
		//return null;
		// TODO Auto-generated method stub
		//System.out.println(user);
		return studentdao.findByUser(user);
	}

	public void saveStudent(StudentBean s) {
		studentdao.saveStudent(s);
		// TODO Auto-generated method stub
		
	}

}
