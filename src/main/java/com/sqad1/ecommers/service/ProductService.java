package com.sqad1.ecommers.service;

import java.util.List;

import com.sqad1.ecommers.dto.ProductDto;
import com.sqad1.ecommers.exception.ProductNotFoundException;

public interface ProductService {

	List<ProductDto> searchProduct(String productName) throws ProductNotFoundException;

}
