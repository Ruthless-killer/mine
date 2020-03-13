package cn.sm1234.dao;


import org.apache.ibatis.annotations.Param;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;



public interface studentDao {
	
	

	StudentBean findByUser(@Param("user") User user);

	int saveStudent(StudentBean s);

	int update(StudentBean student);

}
