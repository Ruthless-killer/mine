package cn.sm1234.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sm1234.domain.PaperSelectBean;

public interface paperselectDao {

	int saveSelq(@Param("ps") PaperSelectBean ps);

	@Select("SELECT * from paper_select where studentid =#{sid} group by papername")
	ArrayList<PaperSelectBean> selBySid(@Param("sid") int sid);

	@Select("SELECT * from paper_select where papername=#{papername} and courseid = #{courseid}")
	ArrayList<PaperSelectBean> selByNAC(@Param("papername")String papername,@Param("courseid") int courseid);

	@Select("select * from paper_select where question like #{question}")
	PaperSelectBean selByq(@Param("question")String question);

	@Update("update paper_select set studentanswer = #{string} where papername=#{papername} and studentid = #{studentid} and question like #{question}")
	int updateAS(@Param("string")String string,@Param("papername") String papername,@Param("studentid") int studentid, @Param("question")String question);

}
