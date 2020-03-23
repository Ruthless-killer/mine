package cn.sm1234.service;

import cn.sm1234.domain.EasyUIDatagrid;
import cn.sm1234.domain.MajorBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;

public interface teacherService {

	TeacherBean login(User user);

	EasyUIDatagrid showAll(int rows, int page);

	int update(TeacherBean teacher);

	int saveOne(TeacherBean teacher);

}
