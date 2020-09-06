package com.orgin.sales.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orgin.sales.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

	Product findTopByOrderByIdDesc();

	List<Product> findByAdminIdIgnoreCase(long adminId);

}
