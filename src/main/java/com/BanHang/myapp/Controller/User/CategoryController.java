package com.BanHang.myapp.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BanHang.myapp.Dto.PaginateDto;
import com.BanHang.myapp.Service.user.CategoryServiceImpl;
import com.BanHang.myapp.Service.user.PaginateServiceImpl;
 @Controller
public class CategoryController extends BaseController {
	 @Autowired
	 private CategoryServiceImpl categoryService;
	 
	 @Autowired
	 private PaginateServiceImpl paginateServiceImpl;
	 
	 private int totalProductsPage = 9;
	 
	 
	@RequestMapping(value= "san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
	
		
		int totalData = categoryService.GetAllProductsPaginate(Integer.parseInt(id)).size();
		PaginateDto  paginateInfo = paginateServiceImpl.GetInfoPaginates(totalData, totalProductsPage, 1);
		_mvShare.addObject("idCategory", id);
		
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	
	@RequestMapping(value= "san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
	
		
		int totalData = categoryService.GetAllProductsPaginate(Integer.parseInt(id)).size();
		PaginateDto  paginateInfo = paginateServiceImpl.GetInfoPaginates(totalData, totalProductsPage, Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", id);
		
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryService.GetDataProductsPaginate(Integer.parseInt(id),paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	
	
}
