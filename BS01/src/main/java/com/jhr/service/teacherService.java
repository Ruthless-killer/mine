package com.jhr.service;

import org.springframework.stereotype.Service;

import com.jhr.bean.TeacherBean;
import com.jhr.bean.User;

public interface teacherService {

	TeacherBean login(User user);

}
