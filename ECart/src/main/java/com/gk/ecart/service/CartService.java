package com.gk.ecart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gk.ecart.entity.Cart;
import com.gk.ecart.entity.CartLine;


@Service
public interface CartService {
	List<CartLine> getCartLines();
	String manageCartLine(int cartLineId, int count);
	String addCartLine(int productId);
	Cart getCart();
	String removeCartLine(int cartLineId);
	String validateCartLine();

}
