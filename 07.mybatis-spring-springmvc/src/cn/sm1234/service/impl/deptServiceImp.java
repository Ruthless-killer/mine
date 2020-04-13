package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.deptDao;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.service.deptService;
@Service("deptService")
public class deptServiceImp implements deptService {
	@Autowired
	private deptDao deptdao;

	public int saveOne(DeptBean dept) {
		// TODO Auto-generated method stub
		System.out.println(dept);
		return deptdao.saveOneDept(dept);
	}

	public int update(DeptBean dept) {
		// TODO Auto-generated method stub
		return deptdao.updateById(dept);
	}

	public int delete(ArrayList<Integer> del) {
		// TODO Auto-generated method stub
		return deptdao.deleteById(del);
	}

	public EasyUIDatagrid showAll(int pageSize,int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<DeptBean> deptList=deptdao.selByPage(pageSize*(pageNumber-1), pageSize);
		datagrid.setRows(deptdao.selByPage(pageSize*(pageNumber-1), pageSize));
		datagrid.setTotal(deptdao.selCount());
		return datagrid;
	}

	public DeptBean selsectOne(int i) {
		//return null;
		// TODO Auto-generated method stub
		return deptdao.selsectOne(i);
	}

}
