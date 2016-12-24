package com.camstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.camstore.dao.ProductDAO;
import com.camstore.model.Product;
import com.google.gson.Gson;
 

@Controller
public class HomeController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/")
	public ModelAndView helloWorld(){
		
		ModelAndView model=new ModelAndView("index");
		return model;
	}

	@RequestMapping("/Product")
	public ModelAndView productsPage(){
	List<Product> products=productDAO.getAllProducts();
	String json = new Gson().toJson(products); 
	ModelAndView model=new ModelAndView("Product");
	model.addObject("productData",json);
	return model;
	}
}
