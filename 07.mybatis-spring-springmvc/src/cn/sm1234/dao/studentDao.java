package cn.sm1234.dao;


import org.springframework.stereotype.Repository;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;


@Repository
public interface studentDao {
	
	StudentBean login(User user);
	
	
	StudentBean login();

}
