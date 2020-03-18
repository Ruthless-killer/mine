package cn.sm1234.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sm1234.dao.deptDao;
import cn.sm1234.domain.Customer;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.service.CustomerService;
import cn.sm1234.service.deptService;
import cn.sm1234.service.majorService;
import cn.sm1234.service.studentService;
import cn.sm1234.utils.DateUtils;


public class MyBatisSpringTest {

//	@Test
//	public void test(){
//		//1.加载spring配置
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		studentService customerService = (studentService)ac.getBean("studentService");
//		
//		StudentBean s= new StudentBean();
//		s.setSno("02");
//		s.setPassword("123");
//		
//		customerService.saveStudent(s);
//	}
	
//	@Test
//	public void test(){
//		//1.加载spring配置
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		CustomerService customerService = (CustomerService)ac.getBean("customerService");
//		
//		Customer customer = new Customer();
//		customer.setName("老李");
//		customer.setGender("女");
//		customer.setTelephone("020-555555");
//		customer.setAddress("广州东圃镇");
//		customerService.saveCustomer(customer);
//	}
	
	@Test
	public void test(){
		//1.加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		deptDao d = (deptDao)ac.getBean("deptDao");
		deptService d = (deptService)ac.getBean("deptService");
		deptDao dao = (deptDao)ac.getBean("deptDao");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
//		List<DeptBean> l=(List<DeptBean>) dao.selByPage(0, 1);
		int a= dao.deleteById(list);
//		EasyUIDatagrid a= d.showAll(0, 1);
//		DeptBean d1=dao.selsectOne(1);
		System.out.println(a);
	}
	
//	/*
//	 * @Test public void test(){ //1.加载spring配置 ApplicationContext ac = new
//	 * ClassPathXmlApplicationContext("applicationContext.xml"); majorService d =
//	 * (majorService)ac.getBean("majorService");
//	 * 
//	 * d.showAll(2, 1); System.out.println("a"); }
//	 */
}
