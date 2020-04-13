package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.deptDao;
import cn.sm1234.dao.majorDao;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.service.deptService;
import cn.sm1234.service.majorService;
@Service("majorService")
public class majorServiceImp implements majorService {
	@Autowired
	private majorDao majordao;
	@Autowired
	private deptDao deptdao;

	public int saveOne(MajorBean major) {
		// TODO Auto-generated method stub
		System.out.println(major);
		major.setDeptId(1);
		String deptname = major.getDeptName();
		if(deptname!=null) {
			DeptBean d=deptdao.selByName(deptname);
			System.out.println(d);
			if(d!=null) {
				major.setDeptId(d.getId());
			}else {
				return 0;
			}
		}
		System.out.println(major);
		return majordao.saveOne(major);
	}

	public int update(MajorBean major) {
		// TODO Auto-generated method stub
		String deptname = major.getDeptName();
		DeptBean d=deptdao.selByName(deptname);
		if(d!=null) {
			major.setDeptId(d.getId());
			return majordao.updateById(major);
		}
		return 0;
	}

	public int delete(ArrayList<Integer> del) {
		// TODO Auto-generated method stub
		return majordao.deleteById(del);
	}

	public EasyUIDatagrid showAll(int pageSize,int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<MajorBean> majorlist=majordao.selByPage(pageSize*(pageNumber-1), pageSize);
//		System.out.println(majorlist.size());
//		for(int i=0;i<majorlist.size();i++) {
//			System.out.println(majorlist.get(i));
//		}
		if(majorlist.size()!=0) {
			for (MajorBean m : majorlist) {
				int id=m.getDeptId();
				System.out.println("id="+id);
				m.setDeptName(deptdao.selsectOne(id).getName());
				//System.out.println(id);
				
			}
		}
		datagrid.setRows(majorlist);
		datagrid.setTotal(majordao.selCount());
//		for (MajorBean m : majorlist) {
//			System.out.println(m);
//		}
		return datagrid;
	}

}
