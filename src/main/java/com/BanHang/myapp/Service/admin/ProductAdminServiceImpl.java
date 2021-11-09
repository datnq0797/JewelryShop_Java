package com.BanHang.myapp.Service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dao.ProductsDao;
import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Products;
@Service
public class ProductAdminServiceImpl implements IProducts_Admin_Service{

	@Autowired
	private ProductsDao products = new ProductsDao();
	
	
	@Override
	public List<Products> GetProduct() {
		List<Products> list= new ArrayList<Products>();
		list = products.getProduct();
		return list;
	}


	@Override
	public int AddProduct(Products pro) {
		return products.AddProduct(pro);
	}


	@Override
	public int UpdateProduct(int id,Products pro) {
	
		return products.UpdateProduct(id,pro);
	}


	@Override
	public int DeleteProduct(int id) {
		
		return products.DeleteProduct(id);
	}


	@Override
	public List<ProductsDto> SearchingProduct(int start, int totalPage, String source) {
		
		return products.FindProductByNameAndCate(start, totalPage, source);
	}
	
	

	@Override
	public List<ProductsDto> GetAllProductFinded(String source) {
	
		return products.GetAllProductsFinded(source);
	}
}
