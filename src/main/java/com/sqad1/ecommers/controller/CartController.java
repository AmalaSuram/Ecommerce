package com.sqad1.ecommers.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sqad1.ecommers.constant.AppConstant;
import com.sqad1.ecommers.dto.CartResponseDto;
import com.sqad1.ecommers.exception.ProductNotFountException;
import com.sqad1.ecommers.service.CartServiceImpl;

/**
 * 
 * @author shraddha
 * @since 24-08-2020
 */

@RestController
@RequestMapping("/carts")
public class CartController {

	
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	CartServiceImpl cartServiceImpl ;
	
	/**
	 * 
	 * @param productId
	 * @param productquantity
	 * @return
	 * @throws ProductNotFountException
	 */
	@PostMapping("add")
	public ResponseEntity<CartResponseDto> addProduct(@RequestParam Integer productId, @RequestParam Integer productquantity ) throws ProductNotFountException {
		
		CartResponseDto cartResponseDto = cartServiceImpl.addCart(productId, productquantity);
		logger.info(AppConstant.PRODUCT_ADD_SUCCESS);
		return new ResponseEntity<>(cartResponseDto,HttpStatus.OK);
	}
}
