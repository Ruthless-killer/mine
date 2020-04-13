package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankSelectBean;

public interface selectService {

	int saveOne(QuestionBankSelectBean questionselect);

	int update(QuestionBankSelectBean questionselect);

	EasyUIDatagrid showAll(int pageSize,int pageNumber);

	int selcount(int selectnumber);

	int delete(ArrayList<Integer> al);

	ArrayList<QuestionBankSelectBean> selAll();

	ArrayList<QuestionBankSelectBean> selAllByName(String coursename);

	

}
