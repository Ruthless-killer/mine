package cn.sm1234.service;

import cn.sm1234.domain.PaperJudgeBean;
import cn.sm1234.domain.PaperSelectBean;

public interface ctService {

	int saveSelq(PaperSelectBean ps);

	int saveJudq(PaperJudgeBean ps);

}
