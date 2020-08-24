package com.sqad1.ecommers.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.sqad1.ecommers.dto.ProductDto;
import com.sqad1.ecommers.dto.ProductSearchDto;
import com.sqad1.ecommers.exception.ProductNotFoundException;
import com.sqad1.ecommers.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	@Mock
	ProductService productService;
	
	List<ProductDto> ProductList=new ArrayList<ProductDto>();
	ProductDto productDto=new ProductDto();
	@Before
	public void init() {
		productDto.setProductdesc("good");
		productDto.setProductName("dove");
		productDto.setProductPrice(100.00);
		productDto.setQuantity(1);
		
		ProductList.add(productDto);
	}
	
	@Test
	public void testsearchProduct() throws ProductNotFoundException {
		Mockito.when(productService.searchProduct("dove")).thenReturn(ProductList);
		
		ResponseEntity<ProductSearchDto> searchProduct = productController.searchProduct("dove");
		assertEquals(200, searchProduct.getBody().getStatusCode());
	}
}

