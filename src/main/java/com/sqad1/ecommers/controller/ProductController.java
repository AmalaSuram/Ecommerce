package com.sqad1.ecommers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sqad1.ecommers.constant.AppConstant;
import com.sqad1.ecommers.dto.ProductDto;
import com.sqad1.ecommers.dto.ProductSearchDto;
import com.sqad1.ecommers.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/searchproduct")
	public ResponseEntity<ProductSearchDto> searchProduct(@RequestParam String productName) {
		//log.info("Starting the  product  based on productServiceName...");
		 List<ProductDto> searchProduct = productService.searchProduct(productName);
		 ProductSearchDto productSearchDto=new ProductSearchDto();
		 productSearchDto.setMessage(AppConstant.SUCCESS_STATUS_MESSAGE);
		 productSearchDto.setStatusCode(HttpStatus.OK.value());
		 productSearchDto.setProductdtoList(searchProduct);
		return new ResponseEntity<>(productSearchDto, HttpStatus.CREATED);
	}

}
