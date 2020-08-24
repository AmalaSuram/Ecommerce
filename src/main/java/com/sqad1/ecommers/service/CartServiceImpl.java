package com.sqad1.ecommers.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sqad1.ecommers.constant.AppConstant;
import com.sqad1.ecommers.dto.CartDto;
import com.sqad1.ecommers.dto.CartResponseDto;
import com.sqad1.ecommers.entity.Cart;
import com.sqad1.ecommers.entity.Product;
import com.sqad1.ecommers.exception.ProductNotFountException;
import com.sqad1.ecommers.repository.CartRepository;
import com.sqad1.ecommers.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	/**
	 * 
	 * @param productId
	 * @param productquantity
	 * @return
	 * @throws ProductNotFountException
	 */
	public CartResponseDto addCart (Integer productId , Integer productquantity) throws ProductNotFountException{
		
		CartResponseDto cartResponseDto = new CartResponseDto();
		CartDto cartDto = new CartDto();
		Cart cart = new Cart();
		Optional<Product> productOp = productRepository.findById(productId);
		
		if(productOp.isPresent()){
			
			Product product = productOp.get();
			cartDto.setProductId(productId);
			cartDto.setProductPrice(product.getProductPrice());
			cartDto.setQuantity(productquantity);
			//cartDto.set
			
			BeanUtils.copyProperties(cartDto, cart);
			cartRepository.save(cart);
			
			//update product quantity
			product.setQuantity(product.getQuantity()-productquantity);
			
			System.out.println("Result::"+ product.getQuantity() );
			productRepository.save(product);
			cartResponseDto.setResponseMessage(AppConstant.PRODUCT_ADD_SUCCESS);
			cartResponseDto.setStatus(AppConstant.SUCCESS_STATUS_CODE);
			return cartResponseDto;
		}else{
			
			 throw new ProductNotFountException(productId.toString());
		}
	}
}
