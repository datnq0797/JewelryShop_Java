package com.BanHang.myapp.Dao;

import org.springframework.stereotype.Repository;

import com.BanHang.myapp.Entity.MapperUsers;
import com.BanHang.myapp.Entity.Users;

@Repository
public class UsersDao  extends BaseDao{
	public int AddAccount(Users user) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("users( ");
		sql.append("    id, ");
		sql.append("    user, ");
		sql.append("    password, ");
		sql.append("    display_name, ");
		sql.append("    address ");
		sql.append("    ) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+user.getId()+"', ");
		sql.append("    '"+user.getUser()+"', ");
		sql.append("    '"+user.getPassword()+"', ");
		sql.append("    '"+user.getDisplay_name()+"', ");
		sql.append("    '"+user.getAddress()+"' ");
		sql.append("    )");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Users GetUserByAcc(Users user) {
		String sql ="SELECT * FROM users WHERE user = '"+user.getUser()+"'";	
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	}
}
