package com.orgin.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.orgin.sales.model.Product;
import com.orgin.sales.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@Override
	public Product save(Product product) {
		product.setTotalSale(0);
		//Never Change This Sequence Name It Effect The Seqeunce of ProductId 
		String sequenceName=product.getAdminId()+"_Product_Sequence";
		System.out.println(sequenceName);
		product.setProductId(sequenceGeneratorService.generateSequence(sequenceName));
		return productRepository.save(product);
	}
	

	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();				
	}

	@Override
	public List<Product> findAllByAdminId(long adminId) {
		return (List<Product>)productRepository.findByAdminIdIgnoreCase(adminId);				
	}
}
