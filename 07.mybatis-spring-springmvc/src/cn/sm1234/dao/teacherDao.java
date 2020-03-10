package cn.sm1234.dao;

import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;

public interface teacherDao {

	TeacherBean login(User user);

}
