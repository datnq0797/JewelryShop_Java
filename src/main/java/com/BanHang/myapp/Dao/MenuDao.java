package com.BanHang.myapp.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BanHang.myapp.Entity.MapperMenu;
import com.BanHang.myapp.Entity.Menu;

@Repository
public class MenuDao extends BaseDao{
	public List<Menu> GetDataMenu(){
		List<Menu> list = new ArrayList<Menu>();
		String sql = "SELECT * FROM `menu`";
		list = _jdbcTemplate.query(sql, new MapperMenu());
		return list;
	}
}
