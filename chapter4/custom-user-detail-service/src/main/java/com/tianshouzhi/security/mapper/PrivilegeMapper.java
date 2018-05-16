package com.tianshouzhi.security.mapper;

import com.tianshouzhi.security.entity.PrivilegeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tianshouzhi on 2018/5/15.
 */
public interface PrivilegeMapper {
	@Select("SELECT * FROM privilege WHERE user_id=#{userId}")
	List<PrivilegeEntity> loadByUserId(@Param("userId") int userId);

	@Insert("INSERT INTO privilege(user_id,name) VALUES(#{userId},#{name})")
	void insert(PrivilegeEntity privilege);
}
