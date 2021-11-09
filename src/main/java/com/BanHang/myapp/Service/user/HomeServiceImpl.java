package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dao.CategorysDao;
import com.BanHang.myapp.Dao.MenuDao;
import com.BanHang.myapp.Dao.ProductsDao;
import com.BanHang.myapp.Dao.SlidesDao;
import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Categorys;
import com.BanHang.myapp.Entity.Menu;
import com.BanHang.myapp.Entity.Slides;




@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slidesDao;
	
	@Autowired
	private CategorysDao categorysDao;
	
	@Autowired
	private MenuDao menuDao;
	 
	@Autowired
	private ProductsDao productsDao;
	
	@Override
	public List<Slides> GetDataSlide() {
		return slidesDao.GetDataSlide();
	}

	@Override
	public List<Categorys> GetDataCategorys() {
		return categorysDao.GetDataCategorys();
	}

	@Override
	public List<Menu> GetDataMenu() {
		return menuDao.GetDataMenu();
	}

	@Override
	public List<ProductsDto> GetDataNew_Products() {
		return productsDao.GetDataNew_Products();
	}

	@Override
	public List<ProductsDto> GetDataHighlight_Products() {
		return productsDao.GetDataHighlight_Products();
	}
	 
}
