package cn.sm1234.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.service.studentService;

@Controller
@RequestMapping("/xs")
public class studentController {
	@Autowired
	private studentService studentservice;

	// 只需要加上下面这段即可，注意不能忘记注解
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

		// 转换日期
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}

	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue = "2") int rows,
			@RequestParam(defaultValue = "1") int page) {
		System.out.println("showAll");
		return studentservice.showAll(rows, page);

	}

	/*
	 * 根据id号进行保存
	 * 
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(StudentBean student) {
		System.out.println("saveOne");
		System.out.println(student);
		return studentservice.saveStudent(student);
		// return 0;

	}
	
	
	@RequestMapping("delet")
	@ResponseBody
	public int delete(@RequestParam(value="del[]") ArrayList<Integer> del) {
		//ArrayList<Integer> al  = new ArrayList<Integer>();
		if(del!=null) {
			//System.out.println("del!=null");
			System.out.println(del.size());
			return studentservice.delete(del);
			
			
		}
		
		//return deptservice.delete(al);
		return 0;
	}

	@RequestMapping("update")
	@ResponseBody
	public int update(StudentBean student) {
		System.out.println("update");
		System.out.println(student);
		return studentservice.update(student);
		//return 0;

	}

}
