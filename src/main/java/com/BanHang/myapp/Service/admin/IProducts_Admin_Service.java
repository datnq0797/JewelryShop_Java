package com.BanHang.myapp.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Products;

@Service
public interface IProducts_Admin_Service {
	@Autowired
	public List<Products> GetProduct();
	@Autowired
	public int AddProduct(Products pro);
	@Autowired
	public int UpdateProduct(int id,Products pro);
	@Autowired
	public int DeleteProduct(int id);
	@Autowired
	public List<ProductsDto> SearchingProduct(int start, int totalPage,String source);
	@Autowired
	public List<ProductsDto> GetAllProductFinded(String source);
}
