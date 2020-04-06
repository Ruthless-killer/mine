package cn.sm1234.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sun.org.glassfish.gmbal.ParameterNames;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;



public interface studentDao {
	
	

	StudentBean findByUser(@Param("user") User user);

	int saveOne(@Param("student") StudentBean student);

	int updateById(@Param("student") StudentBean student);
	
	
	@Select("select  * from student limit #{arg0},#{arg1}")
	List<StudentBean> selByPage(int i, int pageSize);

	@Select("select count(*) from student")
	int selCount();

	int deleteById(@Param("array") ArrayList<Integer> array);

	@Select("select id from student where classid = #{cid}")
	ArrayList<Integer> selByCid(@Param("cid") int cid);

}
