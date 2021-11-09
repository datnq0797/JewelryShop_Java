package com.BanHang.myapp.Service.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Categorys;
@Service
public interface ICategoryService {
	@Autowired
	public List<ProductsDto> GetAllProductsPaginate(int id);
	@Autowired
	public List<ProductsDto> GetDataProductsPaginate(int id,int start,int end);
	@Autowired
	public List<Categorys> GetCategorys();
}
