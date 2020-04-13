package cn.sm1234.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.Pick;

public interface pickDao {

	@Select("select * from pick where courseid = #{courseid}")
	ArrayList<Pick> selById(@Param("courseid") int courseid);
	

}
