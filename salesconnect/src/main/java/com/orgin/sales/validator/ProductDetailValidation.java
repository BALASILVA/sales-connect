package com.orgin.sales.validator;

import org.springframework.stereotype.Service;

import com.orgin.sales.model.Product;

@Service
public class ProductDetailValidation {
	
	public boolean vaildateProductName(String productName)
	{
		
		if(productName==null || productName.trim().equalsIgnoreCase(""))
			return false;
		return true;
	}
	public boolean validateProduct(Product product)
	{
		if(vaildateProductName(product.getProductName()))
			return true;
		return false;
	}
}
