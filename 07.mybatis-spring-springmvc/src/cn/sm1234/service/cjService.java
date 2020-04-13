package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.chengji;

public interface cjService {

	EasyUIDatagrid showAll(int rows, int page);

	ArrayList<chengji> showOne(int s);

}
