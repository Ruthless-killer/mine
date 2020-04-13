package cn.sm1234.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sm1234.domain.PaperJudgeBean;

public interface paperjudgeDao {

	int saveJudq(@Param("ps") PaperJudgeBean ps);

	@Select("SELECT * from paper_judge where studentid =#{sid} group by papername")
	ArrayList<PaperJudgeBean> selBySid(@Param("sid") int sid);

	@Select("SELECT * from paper_judge where  papername=#{papername} and courseid = #{courseid}")
	ArrayList<PaperJudgeBean>  selByNAC(@Param("papername")String papername,@Param("courseid") int courseid);

	@Select("select * from paper_judge where question like #{question}")
	PaperJudgeBean selByq(@Param("question") String question);

	@Update("update paper_judge set studentanswer = #{string} where papername =#{papername} and studentid = #{studentid} and question like #{question}")
	int updateAS(@Param("string")String string,@Param("papername") String papername,@Param("studentid")int studentid,@Param("question") String question);

}
