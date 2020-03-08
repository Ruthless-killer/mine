package com.jhr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;
import com.jhr.dao.teacherDao;
import com.jhr.service.teacherService;
@Service
public class teacherServiceImp implements teacherService {
	
	@Override
	public TeacherBean login(User user) {
		return null;
		// TODO Auto-generated method stub
		//return teacherdao.login(user);
	}

}
