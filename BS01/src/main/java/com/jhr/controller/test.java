package com.jhr.controller;

import javax.annotation.Resource;
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
public class test {
	@Resource
	private studentService studentservice;
	
	@RequestMapping("test")
	public String login(){
		System.out.println("controller²ã");
		studentservice.print();
		return "kaoshi1.jsp";
		
		
		
	}

	
}
