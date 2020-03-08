package com.jhr.dao;

import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;

public interface teacherDao {

	TeacherBean login(User user);

}
