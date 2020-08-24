package com.sqad1.ecommers.dto;

import java.util.List;


public class ProductSearchDto {
	private List<ProductDto> productdtoList;
	private Integer statusCode;
	private String message;
	public List<ProductDto> getProductdtoList() {
		return productdtoList;
	}
	public void setProductdtoList(List<ProductDto> productdtoList) {
		this.productdtoList = productdtoList;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
