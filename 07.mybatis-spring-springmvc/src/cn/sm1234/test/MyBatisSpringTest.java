package cn.sm1234.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sm1234.domain.Customer;
import cn.sm1234.service.CustomerService;


public class MyBatisSpringTest {

	@Test
	public void test(){
		//1.加载spring配置
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CustomerService customerService = (CustomerService)ac.getBean("customerService");
		
		Customer customer = new Customer();
		customer.setName("老李");
		customer.setGender("男");
		customer.setTelephone("020-555555");
		customer.setAddress("广州东圃镇");
		customerService.saveCustomer(customer);
	}
}
