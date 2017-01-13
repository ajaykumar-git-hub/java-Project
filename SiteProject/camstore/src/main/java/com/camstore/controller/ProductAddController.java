package com.camstore.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.camstore.dao.ProductDAO;
import com.camstore.model.Product;

@Controller
public class ProductAddController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/ProductAdd",method=RequestMethod.GET)
	public String listProducts(Model model)
	{
		model.addAttribute("product",new Product());
		model.addAttribute("listProducts",productDAO.listProducts());
		return "ProductAdd";
	}

	@RequestMapping(value= "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product)
	{
		if (product.getProductId () == 0) {
			productDAO.addProduct(product);
		} else {
			productDAO.updateProduct(product);
		}

		return "redirect:/";
		
	}
	
	
	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id)
	{
		productDAO.removeProduct(id);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("person", productDAO.getProductById(id));
        model.addAttribute("listPersons", productDAO.listProducts());
        return "ProductAdd";
	}

}
