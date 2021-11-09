package com.BanHang.myapp.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeAdminController extends BaseAdminController{

	@RequestMapping(value= {"/trang-admin"})
	public ModelAndView home() {
		_mvShare.setViewName(("admin/homeadmin"));
		
		
		return _mvShare; 
		
	}
}
