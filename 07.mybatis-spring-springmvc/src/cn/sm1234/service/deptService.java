package cn.sm1234.service;

import java.util.ArrayList;
import java.util.List;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;

public interface deptService {

	int saveOne(DeptBean dept);

	int update(DeptBean dept);

	int delete(ArrayList<Integer> dd);

	EasyUIDatagrid showAll(int pageSize,int pageNumber);


	DeptBean selsectOne(int i);

	

}
