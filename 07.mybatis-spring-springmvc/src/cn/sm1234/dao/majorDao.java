package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sm1234.domain.MajorBean;

public interface majorDao {

	
	int saveOne(@Param("major") MajorBean major);
	
	
	int updateById(@Param("major") MajorBean major);

	int deleteById(@Param("array") ArrayList<Integer> array);
	
	@Select("select  * from major limit #{arg0},#{arg1}")
	List<MajorBean> selByPage(int i, int pageSize);
	
	
	@Select("select count(*) from major")
	int selCount();

	@Select("select * from major where id = #{majorid}")
	MajorBean selById(@Param("majorid") int majorid);


	@Select("select * from major where name= #{majorname}")
	MajorBean selByName(@Param("majorname") String majorname);

	
	

}
