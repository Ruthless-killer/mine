package cn.sm1234.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.sm1234.domain.chengji;

public interface chengjiDao {
	
	
	int savescore(@Param("chengji") chengji chengji);

}
