package com.orgin.sales.service;

import java.util.List;

import com.orgin.sales.model.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> findAll();

	List<Product> findAllByAdminId(long adminId);
	
}
