package com.BanHang.myapp.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BanHang.myapp.Entity.Users;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController{

	@RequestMapping(value= {"/","/trang-chu"})
	public ModelAndView home() {
		_mvShare.setViewName(("user/home"));
	
		
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("newproducts", _homeService.GetDataNew_Products());	
		_mvShare.addObject("highlightproducts", _homeService.GetDataHighlight_Products());	
		
		return _mvShare; 
		
	}
	
	
		
	
	
}
