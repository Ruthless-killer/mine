package com.jhr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhr.bean.StudentBean;
import com.jhr.bean.User;
import com.jhr.dao.studentDao;
import com.jhr.service.studentService;
@Service
public class studentServiceImpl implements studentService {
	@Autowired
	private studentDao studentdao;

	@Override
	public StudentBean login(User user) {
		// TODO Auto-generated method stub
		return studentdao.login(user);
	}

}
