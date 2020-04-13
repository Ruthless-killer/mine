package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.QuestionBankJudgeBean;
import cn.sm1234.domain.QuestionBankSelectBean;

public interface judgeDao {

	@Select("select * from question_bank_judge limit #{arg0},#{arg1}")
	List<QuestionBankJudgeBean> selByPage(int i, int pageSize);

	@Select("select count(*) from question_bank_judge")
	int selCount();

	int update(@Param("questionjudge") QuestionBankJudgeBean questionjudge);
	
	@Select("select * from question_bank_judge")
	ArrayList<QuestionBankJudgeBean> selAll();

	@Select("select * from question_bank_judge where courseid = #{cid}")
	ArrayList<QuestionBankJudgeBean> selAllByCId(@Param("cid") int cid);


}
