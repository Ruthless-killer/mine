package cn.sm1234.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.DeptBean;

public interface courseDao {

	int saveOne(@Param("course") CourseBean cousrse);
	
	
	int updateById(@Param("course") CourseBean cousrse);
	int deleteById(@Param("course") CourseBean cousrse);

	@Select("select  * from course limit #{arg0},#{arg1}")
	List<CourseBean> selByPage(int i, int pageSize);
	@Select("select count(*) from course")
	int selCount();

	@Select("select * from course where id = #{courseid}")
	CourseBean selById(@Param("courseid") int courseid);

	@Select("select * from course where name = #{coursename}")
	CourseBean selByName(@Param("coursename")String coursename);
	
	

}
