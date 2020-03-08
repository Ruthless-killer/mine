package com.jhr.dao;

import org.springframework.stereotype.Component;

import com.jhr.bean.StudentBean;
import com.jhr.bean.User;

public interface studentDao {

	StudentBean login(User user);

}
