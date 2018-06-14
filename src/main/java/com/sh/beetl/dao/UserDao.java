package com.sh.beetl.dao;

import com.sh.beetl.entity.User;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.mapper.BaseMapper;

public interface UserDao extends BaseMapper<User> {

	@Sql("select * from user where id = ?")
	User findById(Integer id);
	
}
