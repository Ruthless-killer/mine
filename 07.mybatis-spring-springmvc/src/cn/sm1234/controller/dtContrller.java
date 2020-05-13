package cn.sm1234.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.PaperBean;
import cn.sm1234.domain.PaperSelectBean;
import cn.sm1234.domain.User;
import cn.sm1234.domain.chengji;
import cn.sm1234.service.cjService;
import cn.sm1234.service.dtService;

@Controller
@RequestMapping("/dt")
public class dtContrller {
	@Autowired
	private dtService dtservice;
	@Autowired
	private cjService cjservice;

	/*
	 * 查询相关试卷
	 */
	@RequestMapping("selp")
	@ResponseBody
	public int selp(HttpServletRequest request,HttpSession session) {
		//System.out.println("ssss");
		//HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		String sid = u.getUserName();
//		System.out.println(session.getAttribute("user"));
		int studentid = Integer.parseInt(sid);
		HashMap<String , Integer> h=dtservice.selBySid(studentid);
//		List<String> list = new ArrayList<String>();
//	    list.add("简单是可靠的先决条件");
//	    list.add("兴趣是最好的老师");
//	    list.add("知识上的投资总能得到最好的回报");
		for (Map.Entry<String , Integer> entry : h.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		session.setAttribute("list", h);//查询出来考试科目存在list中
		return 1;
		
	}

	@RequestMapping("dt")
	@ResponseBody
	public int dt(String papername,int courseid,HttpServletRequest request,HttpSession session) {
//		System.out.println("dt");
		System.out.println(papername);
//		System.out.println(courseid);
		ArrayList<PaperBean> pb=dtservice.takepapaer(papername,courseid);
		session.setAttribute("pb", pb);
	   
		return 1;
		
	}
	
	@RequestMapping("save")
	@ResponseBody
	public int save(String[] selquestion,String[] selanswer,String[] judquestion,String[] judanswer,
			HttpSession session,String papername,int studentid,int courseid) {
//		System.out.println("dt");
//		System.out.println(papername);
//		System.out.println(courseid);
		System.out.println("------------------------------");
		
		for (String string : judanswer) {
			System.out.println(string);
		}
		
		int cj = dtservice.answer(selquestion, selanswer,judquestion,judanswer,papername,studentid);
		System.out.println("chengji"+cj);
		chengji c= new chengji();
		User u =(User)session.getAttribute("user");
		String sd = u.getUserName();
		c.setStudentid(Integer.parseInt(sd));
		c.setCourseid(courseid);
		c.setGrade(cj);
		c.setPapername(papername);
		dtservice.savescore(c);
		return 1;
		
	}
	
	
//	@RequestMapping("showStu")
//	@ResponseBody
//	public int showStu(String papername,int courseid,HttpServletRequest request,HttpSession session) {
//		
//		User u = (User) session.getAttribute("user");
//		String sno  = u.getUserName();
//	
//		cjservice.showStu(sno);
//		return 1;
//		
//	}
}
