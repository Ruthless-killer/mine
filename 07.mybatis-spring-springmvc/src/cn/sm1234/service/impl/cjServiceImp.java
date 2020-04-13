package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.sm1234.dao.cjDao;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.QuestionBankJudgeBean;
import cn.sm1234.domain.chengji;
import cn.sm1234.service.cjService;
@Service("cjService")
public class cjServiceImp implements cjService {
	private cjDao cjdao;
	public EasyUIDatagrid showAll(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<chengji> qj=cjdao.selByPage(pageSize*(pageNumber-1), pageSize);
		
		datagrid.setRows(qj);
		datagrid.setTotal(cjdao.selCount());
		return datagrid;
	}
	public ArrayList<chengji> showOne(int s) {
		// TODO Auto-generated method stub
		return cjdao.selBySid(s);
	}

}
