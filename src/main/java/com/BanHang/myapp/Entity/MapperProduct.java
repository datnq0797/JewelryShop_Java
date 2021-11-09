package com.BanHang.myapp.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProduct implements RowMapper<Products> {
	@Override
	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products pro = new Products();
		pro.setId(rs.getInt("id"));
		pro.setId_category(rs.getLong("id_category"));
		pro.setSizes(rs.getString("sizes"));
		pro.setName(rs.getString("name"));
		pro.setPrice(rs.getDouble("price"));
		pro.setSale(rs.getInt("sale"));
		pro.setTitle(rs.getString("title"));
		pro.setHighlight(rs.getInt("highlight"));
		pro.setNew_product(rs.getInt("new_product"));
		pro.setDetails(rs.getString("details"));
		pro.setCreated_at(rs.getDate("created_at"));
		pro.setUpdated_at(rs.getDate("updated_at"));
		return pro;

	}
}
