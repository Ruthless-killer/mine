package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;

public interface majorService {

	int saveOne(MajorBean major);

	int update(MajorBean major);

	int delete(ArrayList<Integer> del);

	EasyUIDatagrid showAll(int pageSize,int pageNumber);

	

}
