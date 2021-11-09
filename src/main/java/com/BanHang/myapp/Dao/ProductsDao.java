package com.BanHang.myapp.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BanHang.myapp.Dto.Mapper_ProductsDto;
import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.MapperProduct;
import com.BanHang.myapp.Entity.Products;

@Repository
public class ProductsDao extends BaseDao {

	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		sql.append("p.id as id_product ");
		sql.append(",p.id_category ");
		sql.append(",p.sizes ");
		sql.append(",p.name ");
		sql.append(",p.price ");
		sql.append(",p.sale ");
		sql.append(",p.title ");
		sql.append(",p.highlight ");
		sql.append(",p.new_product ");
		sql.append(",p.details ");
		sql.append(",c.id as id_color ");
		sql.append(",c.name as name_color ");
		sql.append(",c.code as code_color ");
		sql.append(",c.img ");
		sql.append(",p.created_at ");
		sql.append(",p.updated_at ");
		sql.append("from products as p ");
		sql.append("inner join ");
		sql.append("colors as c ");
		sql.append("on p.id = c.id_product ");
		return sql;
	}

	//-----admin
	public int AddProduct(Products pro) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `products`( ");
		sql.append("`id_category`,`sizes`, `name`, `price`, `sale`, `title`, `highlight`, `new_product`, `details`, `created_at`, `updated_at`) ");
		sql.append("VALUES ( ");
		sql.append("'"+pro.getId_category()+"', ");
		sql.append("'"+pro.getSizes()+"', ");
		sql.append("'"+pro.getName()+"', ");
		sql.append("'"+pro.getPrice()+"', ");
		sql.append("'"+pro.getSale()+"', ");
		sql.append("'"+pro.getTitle()+"', ");
		sql.append("'"+pro.getHighlight()+"', ");
		sql.append("'"+pro.getNew_product()+"', ");
		sql.append("'"+pro.getDetails()+"', ");
		sql.append(""+pro.getCreated_at()+", ");
		sql.append(""+pro.getUpdated_at()+" ");
		sql.append(");");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public int DeleteProduct(int id) {
		String  sql = "DELETE FROM `products` WHERE `id` = "+id;
		_jdbcTemplate.execute(sql);
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public int UpdateProduct(int id,Products pro) {
		StringBuffer  sql = new StringBuffer();
		sql.append("UPDATE `products` ");
		sql.append("SET ");
		sql.append("`id_category`="+ pro.getId_category()+", ");
		sql.append("`sizes`="+pro.getSizes()+", ");
		sql.append("`name`="+pro.getName()+", ");
		sql.append("`price`="+pro.getPrice()+", ");
		sql.append("`sale`="+pro.getSale()+", ");
		sql.append("`title`="+pro.getTitle()+", ");
		sql.append("`highlight`="+pro.getHighlight()+", ");
		sql.append("`new_product`="+pro.getNew_product()+", ");
		sql.append("`details`="+pro.getDetails()+", ");
		sql.append("`created_at`="+pro.getCreated_at()+", ");
		sql.append("`updated_at`="+pro.getUpdated_at()+" ");
		sql.append("WHERE `id` = 1");
		
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public List<Products> getProduct() {
		List<Products> list = new ArrayList<Products>();
		String sql = "SELECT * FROM products";
		list = _jdbcTemplate.query(sql, new MapperProduct());
		return list;
		
	}
	
	
	//-----end--admin
	
	
	private String SqlProducts(boolean newProduct, Boolean highLight) {
		StringBuffer sql = SqlString();
		sql.append("where 1=1 ");

		if (newProduct)
			sql.append("and p.new_product = true ");
		if (highLight)
			sql.append("and p.highlight = true ");

		sql.append("group by p.id,c.id_product ");
		sql.append("order by rand() ");

		if (newProduct)
			sql.append("limit 12 ");
		if (highLight)
			sql.append("limit 9 ");

		return sql.toString();
	}

	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("where 1=1 ");
		sql.append("and id_category = " + id + " ");

		return sql;
	}

	
	
	//----tim kiem
	private StringBuffer SqlProductsByNameCate(String source) {
		StringBuffer sql = SqlString();
		sql.append("where 1=1 ");
		sql.append("and p.name like '%"+source+"%' ");
		sql.append("or ");
		sql.append("p.sizes like '%"+source+"%'");
		return sql;
	}
	private String SqlProductsByNameCatePaginate(int start, int totalPage,String source) {
		StringBuffer sql = SqlProductsByNameCate(source);
		sql.append(" limit  " + start + "," + totalPage);
		return sql.toString();
	}
	
	
	
	
	
	private String SqlProductsByPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);
		sql.append(" limit  " + start + "," + totalPage);
		return sql.toString();
	}

	public List<ProductsDto> GetDataNew_Products() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProducts(YES, NO);
		list = _jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return list;
	}

	public List<ProductsDto> GetDataHighlight_Products() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProducts(NO, YES);
		list = _jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return list;
	}

	public List<ProductsDto> GetAllProductsByID(int id) {

		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductsByID(id).toString();
		list = _jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return list;
	}

	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<ProductsDto> listByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new Mapper_ProductsDto());
		List<ProductsDto> list = new ArrayList<ProductsDto>();

		if (listByID.size() > 0) {
			String sql = SqlProductsByPaginate(id, start, totalPage);
			list = _jdbcTemplate.query(sql, new Mapper_ProductsDto());
		}
		return list;
	}

	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("where 1=1 ");
		sql.append("and p.id= " + id + " ");
		sql.append("limit 1");
		return sql.toString();
	}
	
	public List<ProductsDto> GetProductByID(long id) {
		String sql= SqlProductByID(id);
		List<ProductsDto> listProduct =_jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return listProduct;
	}
	
	
	public Products GetProductByID2(int id) {
		String sql= "SELECT * FROM `products` WHERE id = "+id;
		Products Product =_jdbcTemplate.queryForObject(sql, new MapperProduct());
		return Product;
	}
	
	public ProductsDto FindProductByID(long id) {
		String sql= SqlProductByID(id);
		ProductsDto product =_jdbcTemplate.queryForObject(sql, new Mapper_ProductsDto());
		return product;
	}
	
	//----searching
	public List<ProductsDto> GetAllProductsFinded(String source) {

		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductsByNameCate(source).toString();
		list = _jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return list;
	}
	
	public List<ProductsDto>  FindProductByNameAndCate(int start, int totalPage,String source) {
		String sql= SqlProductsByNameCatePaginate(start, totalPage,source);
		List<ProductsDto>  product =_jdbcTemplate.query(sql, new Mapper_ProductsDto());
		return product;
	}
}
