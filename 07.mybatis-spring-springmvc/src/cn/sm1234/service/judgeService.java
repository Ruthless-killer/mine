package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankJudgeBean;

public interface judgeService {

	EasyUIDatagrid showAll(int rows, int page);

	int saveOne(QuestionBankJudgeBean questionjudge);

	int update(QuestionBankJudgeBean questionjudge);

	int selcount(int judgenumber);

	ArrayList<QuestionBankJudgeBean> selAll();

	ArrayList<QuestionBankJudgeBean> selAllByName(String coursename);

}
