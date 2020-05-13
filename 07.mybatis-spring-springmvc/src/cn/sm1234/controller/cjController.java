package cn.sm1234.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.domain.User;
import cn.sm1234.domain.chengji;
import cn.sm1234.service.cjService;
import cn.sm1234.service.majorService;
import cn.sm1234.utils.DateUtils;



@Controller
@RequestMapping("cj")
public class cjController {
	@Autowired
	private cjService cjservice;
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		//转换日期
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}
	
	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		//System.out.println("showAll");
		return cjservice.showAll(rows, page);
		
	}
	
	
	/*
	 * 显示一个
	 * 
	 */
	@RequestMapping("showOne")
	@ResponseBody
	public ArrayList<chengji> showOne(HttpSession session) {
		User u = (User)session.getAttribute("user");
		String sid  = u.getUserName();
		int s = Integer.parseInt(sid);
		ArrayList<chengji> c= cjservice.showOne(s);
		for (chengji chengji : c) {
			System.out.println(chengji);
		}
//		if(u.getUserType().equals("student")) {
//			System.out.println("student");
//			session.setAttribute("cj1", c);
//		}else {
//			session.setAttribute("cj", c);
//		}
		session.setAttribute("cj", c);
		return c;
		
		//return 0;
		
	}
	
	
	
	
//	/*
//	 * 删除
//	 * 
//	 */
//	@RequestMapping("deletMajor")
//	@ResponseBody
//	public int deleteMajor(@RequestParam(value="del[]")ArrayList<Integer> del) {
//		if(del.size()!=0) {
//			System.out.println("delete1");
//			for (Integer integer : del) {
//				System.out.println(integer);
//			}
//			//System.out.println(major);
//			
//		}
//		System.out.println("aaaaaa");
//		return 0;
//		//return 0;
//		
//	}
	
	
}
