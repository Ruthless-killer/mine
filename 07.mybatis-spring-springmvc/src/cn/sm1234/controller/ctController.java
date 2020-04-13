package cn.sm1234.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.PaperJudgeBean;
import cn.sm1234.domain.PaperSelectBean;
import cn.sm1234.domain.QuestionBankJudgeBean;
import cn.sm1234.domain.QuestionBankSelectBean;
import cn.sm1234.domain.paper;
import cn.sm1234.service.ctService;
import cn.sm1234.service.deptService;
import cn.sm1234.service.judgeService;
import cn.sm1234.service.selectService;
import cn.sm1234.utils.UUIDutil;

@Controller
@RequestMapping("/ct")
public class ctController {

	@Autowired
	private selectService selectservice;
	@Autowired
	private judgeService judgeservice;
	@Autowired
	private ctService ctservice;
	

	/*
	 */
	@RequestMapping("ct")
	@ResponseBody
	public int ct(paper q) {
		System.out.println(q);

		int cts=0;
		int ctd=0;
		ArrayList<QuestionBankSelectBean> sel = selectservice.selAllByName(q.getCoursename());
		if (sel.size() != 0 && sel.size() >= q.getSelectnumber()) {
			//随机选择number个数据
			List<Integer> s=UUIDutil.getRandomNumList(q.getSelectnumber(), 0, sel.size());
			for (Integer integer : s) {
				System.out.println(integer);
				sel.get(integer);
				PaperSelectBean ps = new PaperSelectBean();
				ps.setPapername(q.getPapername());
				ps.setQuestion(sel.get(integer).getQuestion());
				ps.setModelanswer(sel.get(integer).getAnswer());
				ps.setScore(q.getSelectscore());
				//ps.setTeachername(sel.get(integer).getTeachername());
				ps.setCourseid(sel.get(integer).getCourseid());
				cts=ctservice.saveSelq(ps);
			}
		} else {
			return 0;
		}

		ArrayList<QuestionBankJudgeBean> jud = judgeservice.selAllByName(q.getCoursename());
		if (jud.size() != 0 && jud.size() >= q.getJudgenumber()) {
			List<Integer> s=UUIDutil.getRandomNumList(q.getJudgenumber(), 0, jud.size());
			for (Integer integer : s) {
				jud.get(integer);
				PaperJudgeBean ps = new PaperJudgeBean();
				ps.setPapername(q.getPapername());
				ps.setQuestion(jud.get(integer).getQuestion());
				ps.setModelanswer(jud.get(integer).getAnswer());
				System.out.println("jud.get(integer).getAnswer()"+jud.get(integer).getAnswer());
				ps.setScore(q.getSelectscore());
				//ps.setTeachername(sel.get(integer).getTeachername());
				ps.setCourseid(jud.get(integer).getCourseid());
				ctd=ctservice.saveJudq(ps);
			}
		} else {
			return 0;
		}
		if(cts!=0&&ctd!=0) {
			return 1;
		}else {
			return 0;
		}

		

	}

}
