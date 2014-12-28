package com.fns.web;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fns.entity.Product;
import com.fns.entity.support.Repository;
import com.fns.service.ProductService;
import com.fns.utility.FileDownloader;

@Controller
public class ImageController {

	@Resource
	private ProductService productService;

	@Resource
	private Repository repository;

	@RequestMapping("/product/picture/{id}")
	public String download(@PathVariable("id") Long id,			
			HttpServletResponse response) throws FileNotFoundException {

		String redirectString = "redirect:/static/assets/img/gear_default.png";

		Product product = repository.findProductById(id);
		if (product == null) {
			return null;
		}

		try {
			FileDownloader.writeFileToOutputStream(response,
					product.getPictureFileName(),
					product.getPictureContectType(), product.getPicture());
			return null;
		} catch (IOException ioe) {

		}
		return null;

	}	
}
