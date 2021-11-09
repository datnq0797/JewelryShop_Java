package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.ProductsDto;

@Service
public interface IProductService {
	@Autowired
	public ProductsDto GetProductByID(long id);
	
	@Autowired
	public List<ProductsDto> GetProductByIDCategory(int id);
	
}
