package com.gk.ecart.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gk.ecart.service.CartService;
import com.gk.ecart.serviceImpl.CartServiceImpl;

@Controller
public class CartController {

	private static final Logger logger = LogManager.getLogger(CartController.class);

	@Autowired
	private CartServiceImpl cartservice;

	@GetMapping(value = "/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Shopping Cart");
		mv.addObject("userClickShowCart", true);
//	List l=new ArrayList();
//	l.forEach(x->System.out.println(x));
		if (result != null) {
			switch (result) {
			case "added": 
				mv.addObject("message", "Product has been successfully added inside cart!");
				cartservice.validateCartLine();
				break;
			case "unavailable":
				mv.addObject("message", "Product quantity is not available!");
				break;
			case "updated":
				mv.addObject("message", "Cart has been updated successfully!");
				cartservice.validateCartLine();
				break;
			case "modified":
				mv.addObject("message", "One or more items inside cart has been modified!");
				break;
			case "maximum":
				mv.addObject("message", "Maximum limit for the item has been reached!");
				break;
			case "deleted":
				mv.addObject("message", "CartLine has been successfully removed!");
				break;

			}
		} else {
			String response = cartservice.validateCartLine();
			if (response.equals("result=modified")) {
				mv.addObject("message", "One or more items inside cart has been modified!");
			}
		}
		mv.addObject("cartLines", cartservice.getCartLines());
		return mv;

	}

	@RequestMapping(value="/{cartLineId}/update")
	public String updateCartLine(@PathVariable int cartLineId,@RequestParam int count) {
		
		String response = cartservice.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;	
	}

	@RequestMapping("/add/{productId}/product")
	public String addCartLine(@PathVariable int productId) {
		String response = cartservice.addCartLine(productId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/{cartLineId}/remove")
	public String removeCartLine(@PathVariable int cartLineId) {
		String response = cartservice.removeCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	@RequestMapping("/validate")
	public String validateCart() {	
		String response = cartservice.validateCartLine();
		if(!response.equals("result=success")) {
			return "redirect:/cart/show?"+response;
		}
		else {
			return "redirect:/cart/checkout";
		}
	}	
	

}
