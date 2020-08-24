package com.sqad1.ecommers.service;

import java.util.List;

import com.sqad1.ecommers.dto.ProductDto;

public interface ProductService {

	List<ProductDto> searchProduct(String productName);

}
