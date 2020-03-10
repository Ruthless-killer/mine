package cn.sm1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.teacherDao;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;
import cn.sm1234.service.teacherService;


@Service
public class teacherServiceImp implements teacherService {
	@Autowired
	private teacherDao teacherdao;

	public TeacherBean login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
