package cn.sm1234.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.service.PoliticsClassService;
import cn.sm1234.service.majorService;



@Controller
@RequestMapping("/bj")
public class PoliticsClassController {
	@Autowired
	private PoliticsClassService politicsClassService;
	
	@RequestMapping("showAll")
	@ResponseBody
	public EasyUIDatagrid showAll(@RequestParam(defaultValue="2")int rows,@RequestParam(defaultValue="1")int page) {
		//System.out.println("showAll");
		return politicsClassService.showAll(rows, page);
		
	}
	
	
	/*
	 * 根据id号进行更新 
	 * 此功能可能不会有前端  也就是不会实现
	 */
	@RequestMapping("update")
	@ResponseBody
	public int update(PoliticsClassBean politicsClassBean) {
		System.out.println("update");
		System.out.println(politicsClassBean);
		return politicsClassService.update(politicsClassBean);
		//return 0;
		
	}
	
	/*
	 * 根据id号进行保存
	 * 
	 */
	@RequestMapping("saveOne")
	@ResponseBody
	public int saveOne(PoliticsClassBean politicsClassBean) {
		System.out.println("saveOne");
		System.out.println(politicsClassBean);
		return politicsClassService.saveOne(politicsClassBean);
		//return 0;
		
	}
	
	
	/*
	 * 删除
	 * 
	 */
	@RequestMapping("delet")
	@ResponseBody
	public int deleteMajor(@RequestParam(value="del[]") ArrayList<Integer> del) {
		if(del!=null) {
			System.out.println("delete1");
			for (Integer integer : del) {
				System.out.println(integer);
			}
			//System.out.println(major);
			return politicsClassService.delete(del);
		}
		System.out.println("aaaaaa");
		return 0;
		
	}
	
	
}
