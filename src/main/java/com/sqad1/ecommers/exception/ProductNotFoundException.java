package com.sqad1.ecommers.exception;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(String productName) {
		super(String.format("Product "+productName+" not found"));
	}

}
