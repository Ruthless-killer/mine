package com.jhr.dao;

import org.springframework.stereotype.Component;

import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;
@Component
public interface teacherDao {

	TeacherBean login(User user);

}
