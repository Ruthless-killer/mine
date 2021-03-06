package cn.sm1234.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankSelectBean;
import cn.sm1234.service.deptService;
import cn.sm1234.service.selectService;
import cn.sm1234.utils.UUIDutil;

@Controller
@RequestMapping("/xzt")
public class selectController {
	@Autowired
	private selectService selectservice;
	/*
	 * 进行单一的院系信息的添加
	 * 注：需要有id  8 位 int类型
	 * 还有时间 
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(String question,int answer,String teachername,String coursename) {
		QuestionBankSelectBean sele= new QuestionBankSelectBean();
		sele.setAnswer(answer);
		sele.setCoursename(coursename);
		sele.setQuestion(question);
		sele.setTeachername(teachername);
		//System.out.println(question);
		//return 0;
		System.out.println(sele);
		return selectservice.saveOne(sele);
		
		
	}
	
	/*
	 * 根据id号进行更新 
	 * 此功能可能不会有前端  也就是不会实现
	 */
	@RequestMapping("update")
	@ResponseBody
	public int update(QuestionBankSelectBean questionselect) {
		System.out.println("update");
		System.out.println(questionselect);
		return selectservice.update(questionselect);
		//return 0;
		
	}
	
	@RequestMapping("delet")
	@ResponseBody
	public int delete(@RequestParam(value="dele[]") ArrayList<Integer> dele) {
		
	//	ArrayList<Integer> al  = new ArrayList<Integer>();
//		if(dele!=null) {
//			System.out.println("del!=null");
//			System.out.println(dele.size());
//			//dele 无法获取到信息
//			
//		}
		
		return selectservice.delete(dele);
		//return 0;
		
	}
	
	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		//System.out.println("showAll");
		return selectservice.showAll(rows, page);
		
	}
	
	
	
	
	
	
}
