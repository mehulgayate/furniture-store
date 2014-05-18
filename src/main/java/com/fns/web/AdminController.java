package com.fns.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fns.entity.support.ProductForm;
import com.fns.entity.support.Repository;
import com.fns.service.ProductService;

@Controller
public class AdminController {
	
	
	@Resource
	private ProductService productService;
	
	@Resource
	private Repository repository;
	
	@RequestMapping("/admin")
	public ModelAndView login(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/admin");
		mv.addObject("products", repository.listAllProducts());		
		return mv;
	}
	
	@RequestMapping("/admin/add-new-product")
	public ModelAndView showAddNew(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/add-product");
		
		return mv;
	}
	
	@RequestMapping("/admin/add-product")
	public ModelAndView addNewServer(HttpSession httpSession,@ModelAttribute ProductForm productForm) throws IOException{
		ModelAndView mv=new ModelAndView("redirect:/admin");		
		productService.saveProduct(productForm);
		
		return mv;
	}

}
