package com.gb.test.dao;

import com.gb.test.entity.User;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {

	@Sql("select * from user where id = ?")
	User findById(Integer id);
	
}
