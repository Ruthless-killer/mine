package cn.sm1234.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sm1234.dao.PoliticsClassDao;
import cn.sm1234.dao.deptDao;
import cn.sm1234.dao.majorDao;
import cn.sm1234.dao.teacherDao;
import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.domain.PoliticsClassBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.service.PoliticsClassService;
import cn.sm1234.service.deptService;
import cn.sm1234.service.majorService;
@Service("politicsClassService")
public class PoliticsClassServiceImp implements PoliticsClassService {
	@Autowired
	private PoliticsClassDao politicsClassDao;
	@Autowired
	private majorDao majordao;
	@Autowired
	private teacherDao teacherdao;

	public int saveOne(PoliticsClassBean politicsClassBean) {
		// TODO Auto-generated method stub
		if(politicsClassBean.getMajorName()!=null) {
			String majorname=politicsClassBean.getMajorName();
			int majorid=majordao.selByName(majorname).getId();
			politicsClassBean.setMajorId(majorid);
		}
		if(politicsClassBean.getTeacherName()!=null) {
			String teachername = politicsClassBean.getTeacherName();
			int teacherid =teacherdao.selByName(teachername).getId();
			politicsClassBean.setTeacherId(teacherid);
		}
		return politicsClassDao.saveOne(politicsClassBean);
	}

	public int update(PoliticsClassBean politicsClassBean) {
		// TODO Auto-generated method stub
		if(politicsClassBean.getMajorName()!=null) {
			String majorname=politicsClassBean.getMajorName();
			int majorid=majordao.selByName(majorname).getId();
			politicsClassBean.setMajorId(majorid);
		}else {
			return 0;
		}
		if(politicsClassBean.getTeacherName()!=null) {
			String teachername = politicsClassBean.getTeacherName();
			int teacherid =teacherdao.selByName(teachername).getId();
			politicsClassBean.setTeacherId(teacherid);
		}else {
			return 0;
		}
		System.out.println(politicsClassBean);
		return politicsClassDao.updateById(politicsClassBean);
	}

	public int delete(ArrayList<Integer> del) {
		// TODO Auto-generated method stub
		return politicsClassDao.deleteById(del);
	}

	public EasyUIDatagrid showAll(int pageSize,int pageNumber) {
		// TODO Auto-generated method stub
		EasyUIDatagrid datagrid = new EasyUIDatagrid();
		List<PoliticsClassBean> pclist=politicsClassDao.selByPage(pageSize*(pageNumber-1), pageSize);
		if(pclist.size()!=0) {
			for (PoliticsClassBean politicsClassBean : pclist) {
				int majorid = politicsClassBean.getMajorId();
				int teacherid = politicsClassBean.getTeacherId();
				String majorname=majordao.selById(majorid).getName();
				politicsClassBean.setMajorName(majorname);
				String teachername = teacherdao.selById(teacherid).getName();
				politicsClassBean.setTeacherName(teachername);
				System.out.println(politicsClassBean);
			}
		}
		datagrid.setRows(pclist);
		datagrid.setTotal(politicsClassDao.selCount());
		return datagrid;
	}

}
