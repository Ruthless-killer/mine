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
		//System.out.println(user);
		// TODO Auto-generated method stub
		if(user.getUserType().equals("js")) {
			return	teacherdao.findByUsername(user);
		}else {
			return	teacherdao.findByUsernameG(user);
		}
		//return null;
	}
	
	

}
