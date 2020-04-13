package cn.sm1234.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.service.courseService;



@Controller
@RequestMapping("kc")
public class courseController {
	@Autowired
	private courseService courservice;
	
	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		//System.out.println("showAll");
		return courservice.showAll(rows, page);
		
	}
	
	/*
	 * 根据id号进行更新 
	 * 此功能可能不会有前端  也就是不会实现
	 */
	@RequestMapping("update")
	@ResponseBody
	public int update(CourseBean course) {
		System.out.println("update");
		System.out.println(course);
		return courservice.update(course);
		//return 0;
		
	}
	
	/*
	 * 根据id号进行保存
	 * 
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(String name,String des) {
		System.out.println("saveOne");
		CourseBean course = new CourseBean();
		course.setDes(des);
		course.setName(name);
		System.out.println(course);
		return courservice.saveOne(course);
		//return 0;
		
	}
	
}
