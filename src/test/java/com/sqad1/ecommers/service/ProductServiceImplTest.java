package com.sqad1.ecommers.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.sqad1.ecommers.dto.ProductDto;
import com.sqad1.ecommers.dto.ProductSearchDto;
import com.sqad1.ecommers.entity.Product;
import com.sqad1.ecommers.exception.ProductNotFoundException;
import com.sqad1.ecommers.repository.ProductRepository;
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImplTest {
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepository productRepository;
	List<Product> productList=new ArrayList<Product>();
	Product product=new Product();
	@Before
	public void init() {
		product.setProductdesc("good");
		product.setProductId(1);
		product.setProductName("dove");
		product.setProductPrice(100.00);
		product.setQuantity(2);
		
		productList.add(product);
		
	}
	
	@Test
	public void testsearchProduct() throws ProductNotFoundException {
		Mockito.when(productRepository.findByProductNameContainingIgnoreCase("dove")).thenReturn(productList);
		List<ProductDto> searchProduct = productServiceImpl.searchProduct("dove");
	
		assertEquals(1, searchProduct.size());
	}
}
