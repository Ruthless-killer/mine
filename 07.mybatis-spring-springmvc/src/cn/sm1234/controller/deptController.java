package cn.sm1234.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.service.deptService;
import cn.sm1234.utils.DateUtils;
import cn.sm1234.utils.UUIDutil;

@Controller
public class deptController {
	@Autowired
	deptService deptservice;
	
	 //只需要加上下面这段即可，注意不能忘记注解
		@InitBinder
		public void initBinder(WebDataBinder binder, WebRequest request) {
			
			//转换日期
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
		}

	/*
	 * 进行单一的院系信息的添加
	 * 注：需要有id  8 位 int类型
	 * 还有时间 depet.set
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(String name,String setdate,String des) {
		//@RequestParam("dept") DeptBean dept
		System.out.println("saveOne");
		//System.out.println(dept);
//		System.out.println(setdate);
//		System.out.println(name);
//		System.out.println(des);
		DeptBean dept = new DeptBean();
		if(des!=null) {
			dept.setDes(des);
		}
		Date setDate=DateUtils.strToDate(setdate);
		dept.setSetdate(setDate);
		dept.setName(name);
		
		return deptservice.saveOne(dept);
		
		
		
	}
	
	/*
	 * 根据id号进行更新 
	 * 此功能可能不会有前端  也就是不会实现
	 */
	@RequestMapping("updateDept")
	@ResponseBody
	public int update(DeptBean dept) {
		System.out.println("update");
		System.out.println(dept);
		//System.out.println(setdate);
		return deptservice.update(dept);
		//return 0;
		
	}
	
	@RequestMapping("delet")
	@ResponseBody
	public int delete(@RequestParam(value="dd[]") ArrayList<Integer> dd,@Param("s") String s) {
		System.out.println(s);
		//ArrayList<Integer> al  = new ArrayList<Integer>();
		if(dd!=null) {
			//System.out.println("del!=null");
			System.out.println(dd.size());
			return deptservice.delete(dd);
			
			
		}
		
		//return deptservice.delete(al);
		return 0;
		
	}
	
	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		//System.out.println("showAll");
		return deptservice.showAll(rows, page);
		
	}
	
	
	@RequestMapping("showOne")
	@ResponseBody
	public String showName(int i) {
		DeptBean d= deptservice.selsectOne(i);
		return d.getName();
	}
	
	
	
}
