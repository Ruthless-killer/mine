package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.PoliticsClassBean;

public interface PoliticsClassDao {

	
	int saveOne(@Param("politicsClass") PoliticsClassBean politicsClass);

	int updateById(@Param("politicsClassBean") PoliticsClassBean politicsClassBean);

	int deleteById(@Param("array") ArrayList<Integer> array);
	
	@Select("select  * from politicsclass limit #{arg0},#{arg1}")
	List<PoliticsClassBean> selByPage( int i, int pageSize);
	
	@Select("select count(*) from politicsclass")
	int selCount();

	
	@Select("select  * from politicsclass where id = #{i}")
	DeptBean selsectOne(int i);

	@Select("select * from politicsclass where id=#{classid}")
	PoliticsClassBean selById(@Param("classid") int classid);

	@Select("select * from politicsclass where name = #{classname} ")
	PoliticsClassBean selByName(@Param("classname") String classname);

	

	

}
