package cn.sm1234.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.courseDao;
import cn.sm1234.dao.deptDao;
import cn.sm1234.domain.CourseBean;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.service.courseService;
import cn.sm1234.service.deptService;
@Service("courseService")
public class courseServiceImp implements courseService {
	@Autowired
	private courseDao coursedao;

	public int saveOne(CourseBean cousrse) {
		// TODO Auto-generated method stub
		return coursedao.saveOne(cousrse);
	}

	public int update(CourseBean cousrse) {
		// TODO Auto-generated method stub
		return coursedao.updateById(cousrse);
	}

	public int delete(CourseBean cousrse) {
		// TODO Auto-generated method stub
		return coursedao.deleteById(cousrse);
	}

	public EasyUIDatagrid showAll(int pageSize,int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		datagrid.setRows(coursedao.selByPage(pageSize*(pageNumber-1), pageSize));
		datagrid.setTotal(coursedao.selCount());
		return datagrid;
	}

}
