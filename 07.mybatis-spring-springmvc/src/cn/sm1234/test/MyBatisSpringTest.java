package cn.sm1234.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sm1234.domain.Customer;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.service.CustomerService;
import cn.sm1234.service.deptService;
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
		
		deptService deptservice = (deptService)ac.getBean("deptService");
		DeptBean dept = new DeptBean();
		dept.setName("机电学院2");
		Date d=DateUtils.strToDate("2019-07-03");
		dept.setSetdate(d);
		dept.setDes("电子工程学院");
		int a=deptservice.saveOne(dept);
		System.out.println(a);
	}
}
