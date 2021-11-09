package com.BanHang.myapp.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.BanHang.myapp.Dao.ProductsDao;
import com.BanHang.myapp.Dto.PaginateDto;
import com.BanHang.myapp.Dto.TextSearch;
import com.BanHang.myapp.Entity.Products;
import com.BanHang.myapp.Service.admin.ProductAdminServiceImpl;
import com.BanHang.myapp.Service.user.CategoryServiceImpl;
import com.BanHang.myapp.Service.user.PaginateServiceImpl;

@Controller
public class ProductAdminController extends BaseAdminController {

	@Autowired
	private ProductAdminServiceImpl productAdminServiceImpl;

	@Autowired
	private ProductsDao productsDao;

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@Autowired
	private PaginateServiceImpl paginateServiceImpl;

	private int totalProductsPage = 9;

	@RequestMapping(value = { "/trang-admin/List_Product" })
	public ModelAndView home() {
		_mvShare.setViewName("admin/List_Product");
		_mvShare.addObject("products", productAdminServiceImpl.GetProduct());
		_mvShare.addObject("categorys", categoryServiceImpl.GetCategorys());
		return _mvShare;
	}

	@RequestMapping(value = { "/trang-admin/add-product" })
	public ModelAndView home2() {
		_mvShare.setViewName("admin/Add_Product");
		_mvShare.addObject("products", productAdminServiceImpl.GetProduct());
		_mvShare.addObject("categorys", categoryServiceImpl.GetCategorys());
		return _mvShare;
	}

	
	
	
	@RequestMapping(value = { "/trang-admin/edit_Product/{id}" },method = RequestMethod.GET)
	public ModelAndView EditPage(@PathVariable int id) {
		
		_mvShare.addObject("product", new Products());
		_mvShare.setViewName("admin/Update_Product");
		_mvShare.addObject("products", productsDao.GetProductByID2(id));
		_mvShare.addObject("id", id);
		return _mvShare;

	}
	@RequestMapping(value = "/trang-admin/update-Product", method = RequestMethod.GET)
	public ModelAndView CreatePro() {
		_mvShare.setViewName("admin/Add_Product");
		_mvShare.addObject("product", new Products());
		return _mvShare;
	}
	@RequestMapping(value = { "/trang-admin/update_Product/{id}" })
	public String Edit(@PathVariable int id) {
		
		Products product = productsDao.GetProductByID2(id);

		int i = productAdminServiceImpl.UpdateProduct(id, product);

		return "redirect:/trang-admin/List_Product";
	}

	
	
	
	
	
	@RequestMapping(value = { "/trang-admin/List_Product/{id}" })
	public String Delete(@PathVariable int id) {

		int i = productAdminServiceImpl.DeleteProduct(id);

		return "redirect:/trang-admin/List_Product";
	}

	@RequestMapping(value = "trang-admin/add-product", method = RequestMethod.GET)
	public ModelAndView CreatePro() {
		_mvShare.setViewName("admin/Add_Product");
		_mvShare.addObject("product", new Products());
		return _mvShare;
	}

	@RequestMapping(value = "trang-admin/add-product", method = RequestMethod.POST)
	public ModelAndView CreatePro(@ModelAttribute("product") Products product) {

		int count = productAdminServiceImpl.AddProduct(product);
		if (count > 0) {
			_mvShare.addObject("status", "Thêm thành công !!");
		} else {
			_mvShare.addObject("status", "Thêm thất bại !!");
		}

		return _mvShare;
	}

	// --------------Searching
	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public ModelAndView Register() {
		_mvShare.setViewName("user/products/searching");
		_mvShare.addObject("source", new TextSearch());
		return _mvShare;
	}

	@RequestMapping(value = "/searching", method = RequestMethod.POST)
	public ModelAndView SearchingProduct(@ModelAttribute("source") TextSearch source) {

		String text = source.getText().toString();
		int totalData = productAdminServiceImpl.GetAllProductFinded(text).size();
		if (totalData > 0) {
			PaginateDto paginateInfo = paginateServiceImpl.GetInfoPaginates(totalData, totalProductsPage, 1);
			_mvShare.addObject("idCategory", text);

			_mvShare.addObject("paginateInfo", paginateInfo);

			_mvShare.addObject("productsPaginate",
					productAdminServiceImpl.SearchingProduct(paginateInfo.getStart(), totalProductsPage, text));

		}

		return _mvShare;
	}

	@RequestMapping(value = "/searching/{text}/{currentPage}")
	public ModelAndView SearchingProduct(@PathVariable String text, @PathVariable String currentPage) {
		_mvShare.setViewName("user/products/searching");

		int totalData = productAdminServiceImpl.GetAllProductFinded(text).size();

		PaginateDto paginateInfo = paginateServiceImpl.GetInfoPaginates(totalData, totalProductsPage,
				Integer.parseInt(currentPage));
		_mvShare.addObject("idCategory", text);

		_mvShare.addObject("paginateInfo", paginateInfo);

		_mvShare.addObject("productsPaginate",
				productAdminServiceImpl.SearchingProduct(paginateInfo.getStart(), totalProductsPage, text));
		return _mvShare;
	}
}
