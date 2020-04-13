package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.chengji;

public interface cjDao {

	@Select("select  * from grade limit #{arg0},#{arg1}")
	List<chengji> selByPage(int i, int pageSize);

	@Select("select count(*) from grade")
	int selCount();
	
	@Select("select  * from grade where studentid = #{sid}")
	ArrayList<chengji> selBySid(@Param("sid") int sid);
	

}
