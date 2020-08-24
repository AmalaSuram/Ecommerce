package com.sqad1.ecommers.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqad1.ecommers.dto.ProductDto;
import com.sqad1.ecommers.entity.Product;
import com.sqad1.ecommers.exception.ProductNotFoundException;
import com.sqad1.ecommers.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductDto> searchProduct(String productName) throws ProductNotFoundException {
		List<Product> productList = productRepository.findByProductNameContainingIgnoreCase(productName);
		if(productList.isEmpty()) {
			throw new ProductNotFoundException(productName);
		}
		List<ProductDto> productDtoList = productList.stream().map(p->convertToDto(p)).collect(Collectors.toList());
		
		return productDtoList;
	}
	
	private ProductDto convertToDto(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}
	

}
