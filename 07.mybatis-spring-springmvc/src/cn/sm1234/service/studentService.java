package cn.sm1234.service;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.User;

public interface studentService  {

	StudentBean login(User user);

	void saveStudent(StudentBean s);

}
