package cn.sm1234.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import cn.sm1234.service.majorService;
import cn.sm1234.utils.DateUtils;



@Controller
@RequestMapping("/zy")
public class majorController {
	@Autowired
	private majorService majorservice;
	
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
		return majorservice.showAll(rows, page);
		
	}
	
	
	/*
	 * 根据id号进行更新 
	 * 此功能可能不会有前端  也就是不会实现
	 */
	@RequestMapping("updateMajor")
	@ResponseBody
	public int update(MajorBean major) {
		System.out.println("update");
		System.out.println(major);
		return majorservice.update(major);
		//return 0;
		
	}
	
	/*
	 * 根据id号进行保存
	 * 
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(String name,Date setDate,String deptName,String des) {
		System.out.println("saveOne");
		MajorBean major= new MajorBean();
		major.setName(name);
		
		major.setSetDate(setDate);
		major.setDeptName(deptName);
		major.setDes(des);
		
		return majorservice.saveOne(major);
		//return 0;
		
	}
	
	
	/*
	 * 删除
	 * 
	 */
	@RequestMapping("deletMajor")
	@ResponseBody
	public int deleteMajor(@RequestParam(value="del[]")ArrayList<Integer> del) {
		if(del.size()!=0) {
			System.out.println("delete1");
			for (Integer integer : del) {
				System.out.println(integer);
			}
			//System.out.println(major);
			
		}
		System.out.println("aaaaaa");
		return majorservice.delete(del);
		//return 0;
		
	}
	
	
}
