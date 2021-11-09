package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dao.CategorysDao;
import com.BanHang.myapp.Dao.ProductsDao;
import com.BanHang.myapp.Dto.ProductsDto;
import com.BanHang.myapp.Entity.Categorys;
@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductsDao productsDao;
	
	@Autowired
	private CategorysDao categorysDao;
	
	@Override
	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		List<ProductsDto> products = productsDao.GetDataProductsPaginate(id,start, totalPage);
		return products;
	}

	@Override
	public List<ProductsDto> GetAllProductsPaginate(int id) {
		List<ProductsDto> products = productsDao.GetAllProductsByID(id);
		return products;
	}

	@Override
	public List<Categorys> GetCategorys() {
		List<Categorys> categorys = categorysDao.GetDataCategorys();
		return categorys;
	}

}
