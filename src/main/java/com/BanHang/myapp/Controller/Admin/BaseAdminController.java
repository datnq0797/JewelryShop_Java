package com.BanHang.myapp.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.BanHang.myapp.Service.user.HomeServiceImpl;
@Controller
public class BaseAdminController {
	@Autowired
	HomeServiceImpl _homeService;
	
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init () {
		
		_mvShare.addObject("menu", _homeService.GetDataMenu());
		return _mvShare;
	}
}