package cn.sm1234.dao;

import org.apache.ibatis.annotations.Param;

import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;

public interface teacherDao {

	

	TeacherBean findByUsername(@Param("user") User user);

	TeacherBean findByUsernameG(@Param("user") User user);

}
