package com.fns.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fns.entity.support.Repository;

@Controller
public class ShopController {

	@Resource
	private Repository repository;
	
	@RequestMapping("/")
	public ModelAndView login(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("products", repository.listAllProducts());		
		return mv;
	}
	
}
