package cn.sm1234.service;

import java.util.ArrayList;
import java.util.HashMap;

import cn.sm1234.domain.PaperBean;
import cn.sm1234.domain.PaperSelectBean;
import cn.sm1234.domain.chengji;

public interface dtService {

	HashMap<String , Integer> selBySid(int sid);

	ArrayList<PaperBean> takepapaer(String papername, int courseid);

	int answer(String[] question, String[] answer, String[] judquestion, String[] judanswer, String papername, int studentid);

	int savescore(chengji c);

}
