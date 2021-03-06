package cn.sm1234.service;

import java.util.ArrayList;

import cn.sm1234.domain.DeptBean;
import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;

public interface studentService  {

	StudentBean login(User user);

	int saveStudent(StudentBean s);
	
	int update(StudentBean student);

	int delete(ArrayList<Integer> del);

	EasyUIDatagrid showAll(int pageSize,int pageNumber);

	


}
