package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dao.ProductsDao;
import com.BanHang.myapp.Dto.ProductsDto;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductsDao productsDao = new ProductsDao();
	
	
	@Override
	public ProductsDto GetProductByID(long id) {
		List<ProductsDto> listProducts = productsDao.GetProductByID(id);
		return listProducts.get(0);
	}
	
	
	@Override
	public List<ProductsDto> GetProductByIDCategory(int id) {
		List<ProductsDto> listProducts = productsDao.GetAllProductsByID(id);
		return listProducts;
	}

}
