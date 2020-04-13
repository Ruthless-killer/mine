package cn.sm1234.service;

import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;

public interface courseService {

	int saveOne(CourseBean cousrse);

	int update(CourseBean cousrse);

	int delete(CourseBean cousrse);

	EasyUIDatagrid showAll(int pageSize,int pageNumber);

	

}
