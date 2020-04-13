package cn.sm1234.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.QuestionBankSelectBean;

public interface selectDao {

	@Select("select * from question_bank_select limit #{arg0},#{arg1}")
	List<QuestionBankSelectBean> selByPage(int i, int pageSize);

	@Select("select count(*) from question_bank_select")
	int selCount();

	int update(@Param("questionselect") QuestionBankSelectBean questionselect);

	int deleteById(@Param("array") ArrayList<Integer> array);

	int saveOne(@Param("questionselect")QuestionBankSelectBean questionselect);
	@Select("select * from question_bank_select")
	ArrayList<QuestionBankSelectBean> selAll();

	@Select("select * from question_bank_select where courseid = #{cid} ")
	ArrayList<QuestionBankSelectBean> selAllByCId(@Param("cid") int cid);


}
