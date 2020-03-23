package cn.sm1234.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.sm1234.domain.StudentBean;
import cn.sm1234.domain.TeacherBean;
import cn.sm1234.domain.User;

public interface teacherDao {

	

	TeacherBean findByUsername(@Param("user") User user);

	TeacherBean findByUsernameG(@Param("user") User user);

	@Select("select * from teacher where tno = #{teacherid}")
	String selById(@Param("teacherid") int teacherid);

	@Select("select * from teacher where namae = #{teachername}")
	TeacherBean selByName(@Param("teachername") String teachername);

	@Select("select * from teacher limit #{arg0},#{arg1}")
	List<TeacherBean> selByPage(int i, int pageSize);

	@Select("select count(*) from teacher")
	int selCount();

	int update(TeacherBean teacher);

	int saveOne(TeacherBean teacher);

}
