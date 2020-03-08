package com.jhr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhr.bean.StudentBean;
import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;
import com.jhr.service.studentService;
import com.jhr.service.teacherService;



@Controller
public class login {
	@Autowired
	private studentService studentservice;
	@Autowired
	private teacherService teacherservice;
	
	
	@RequestMapping("loginAction")
	@ResponseBody
	public String login(User user,HttpSession session){
		System.out.println(user);
		System.out.println("aaaaaaaaaa");
		session.setAttribute("user", user);
		if(user.getUserType().equals("xs")) {
			StudentBean student=studentservice.login(user);
			if(student!=null) {
				return "1";
			}else {
				return "0";
			}
		}else {
			TeacherBean teacher=teacherservice.login(user);
			if(teacher!=null) {
				return "1";
			}else {
				return "0";
			}
		}
		
	}

	
}
