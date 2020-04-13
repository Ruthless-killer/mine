package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.DeptBean;

public interface deptDao {

	int saveOneDept(@Param("dept") DeptBean dept);

	int updateById(@Param("dept") DeptBean dept);

	int deleteById(@Param("array") ArrayList<Integer> del);
	
	@Select("select  * from dept limit #{arg0},#{arg1}")
	List<DeptBean> selByPage( int i, int pageSize);
	
	@Select("select count(*) from dept")
	int selCount();

	
	@Select("select  * from dept where id = #{i}")
	DeptBean selsectOne(int id);

	@Select("select * from dept where name= #{deptname}")
	DeptBean selByName(@Param("deptname")String deptname);

	

}
