package com.jhr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;
import com.jhr.dao.teacherDao;
import com.jhr.service.teacherService;

public class teacherServiceImp implements teacherService {
	@Autowired
	private teacherDao teacherdao;
	@Override
	public TeacherBean login(User user) {
		// TODO Auto-generated method stub
		return teacherdao.login(user);
	}

}
