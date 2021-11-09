package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Categorys;
import com.BanHang.myapp.Entity.Menu;
import com.BanHang.myapp.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	
	@Autowired
	public List<Categorys> GetDataCategorys();
	
	@Autowired
	public List<Menu> GetDataMenu();
	
	@Autowired
	public List<ProductsDto> GetDataNew_Products();
	
	@Autowired
	public List<ProductsDto> GetDataHighlight_Products();
	
}
