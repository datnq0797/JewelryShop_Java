package com.BanHang.myapp.Dao;

import org.springframework.stereotype.Repository;

import com.BanHang.myapp.Entity.BillDetail;
import com.BanHang.myapp.Entity.Bills;
@Repository
public class BillsDao extends BaseDao{
	
	public int AddBills(Bills bill) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `bills`(`user`, `phone`, `display_name`, `address`, `total`, `quanty`, `note`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("'"+ bill.getUser()+"' , ");
		sql.append("'"+bill.getPhone() +"' , ");
		sql.append("'"+bill.getDisplay_name() +"', ");
		sql.append("'"+bill.getAddress() +"' ,");
		sql.append("'"+bill.getTotal() +"'  ,");
		sql.append("'"+bill.getQuanty() +"' ,");
		sql.append("'"+bill.getNote() +"' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIDLastBills() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public long AddBillsDetail(BillDetail billDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `billdetail`(`id_product`, `id_bills`, `quanty`, `total`) VALUES ");
		sql.append("( ");
		sql.append("'"+billDetail.getId_product()+"', ");
		sql.append("'"+billDetail.getId_bills()+"', ");
		sql.append("'"+billDetail.getQuanty()+"', ");
		sql.append("'"+billDetail.getTotal()+"' ");
		
		sql.append(");");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
}
