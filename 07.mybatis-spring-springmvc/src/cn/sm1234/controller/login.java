package cn.sm1234.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;
import cn.sm1234.service.studentService;
import cn.sm1234.service.teacherService;




@Controller
public class login {
	@Autowired
	private studentService studentservice;
	@Autowired
	private teacherService teacherservice;
	
	
	@RequestMapping("loginAction")
	@ResponseBody
	public String login1(User user,HttpSession session){
		//System.out.println(user);
		System.out.println("loginActionController");
		//System.out.println(user.getUserType());
		session.setAttribute("user", user);
		if(user.getUserType().equals("xs")) {
			StudentBean student=studentservice.login(user);
			if(student!=null) {
				return "student";
			}else {
				return "0";
			}
		}else {
			TeacherBean teacher=teacherservice.login(user);
			//System.out.println(teacher);
			
//			if(teacher!=null&&teacher.getPosition().equals("管理员")) {
//				return "manager";
//			}else if(teacher!=null&& !teacher.getPosition().equals("管理员")) {
//				return "teacher";
//			}else {
//				return "0";
//			}
			
			if(teacher!=null) {
				return "teacher";
			}else {
				return "0";
			}
		}
		
	}
	
	

	
}
