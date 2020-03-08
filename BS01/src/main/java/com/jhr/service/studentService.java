package com.jhr.service;

import org.springframework.stereotype.Service;

import com.jhr.bean.StudentBean;
import com.jhr.bean.User;

public interface studentService  {

	StudentBean login(User user);

}
