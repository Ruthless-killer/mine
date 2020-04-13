package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.PoliticsClassBean;

public interface PoliticsClassService {

	EasyUIDatagrid showAll(int rows, int page);

	int update(PoliticsClassBean politicsClassBean);

	int saveOne(PoliticsClassBean politicsClassBean);

	int delete(ArrayList<Integer> del);

}
