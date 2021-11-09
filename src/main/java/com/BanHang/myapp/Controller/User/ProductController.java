package com.BanHang.myapp.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BanHang.myapp.Service.user.IProductService;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private IProductService _productService;

	@RequestMapping(value = "chi-tiet-san-pham/{id}")
	public ModelAndView home(@PathVariable long id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", _productService.GetProductByID(id));
		int idCate = _productService.GetProductByID(id).getId_category();
		_mvShare.addObject("productByIdCate", _productService.GetProductByIDCategory(idCate));
		return _mvShare;

	}

}
