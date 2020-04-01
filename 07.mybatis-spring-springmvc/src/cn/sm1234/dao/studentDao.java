package cn.sm1234.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;



public interface studentDao {
	
	

	StudentBean findByUser(@Param("user") User user);

	int saveStudent(StudentBean s);

	int updateById(@Param("student") StudentBean student);
	
	
	@Select("select  * from student limit #{arg0},#{arg1}")
	List<StudentBean> selByPage(int i, int pageSize);

	@Select("select count(*) from student")
	int selCount();

}
