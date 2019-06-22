package com.gk.ecart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gk.ecart.dao.ProductDAO;
import com.gk.ecart.entity.Product;
import com.gk.ecart.util.FileUtil;
import com.gk.ecart.validator.ProductValidator;


@Controller
@RequestMapping("/manage")
public class ManagementController {

	private static final Logger logger=LogManager.getLogger(ManagementController.class);
	private ProductDAO productDAO;
	
	@RequestMapping("/product")
	public ModelAndView manageProduct(@RequestParam(name="succeess" ,required=false)String success) {
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product", nProduct);

		if(success != null) {
			if(success.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}	
			else if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		return mv;
	}
	@RequestMapping("/{id}/product")
	public ModelAndView manageProductEdit(@PathVariable int id) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		// Product nProduct = new Product();		
		mv.addObject("product", productDAO.get(id));

		return mv;
	}
	
	@RequestMapping(value = "/product", method=RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, 
			BindingResult results, Model model, HttpServletRequest request) {
		
		// mandatory file upload check
		if(mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		}
		else {
			// edit check only when the file has been selected
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}			
		}
		
		if(results.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickManageProduct",true);
			return "page";
		}			

		
		if(mProduct.getId() == 0 ) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
		}
	
		 //upload the file
		 if(!mProduct.getFile().getOriginalFilename().equals("") ){
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode()); 
		 }
		
		return "redirect:/manage/product?success=product";
	}
	
}
