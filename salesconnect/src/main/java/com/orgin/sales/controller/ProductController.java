package com.orgin.sales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.model.Product;
import com.orgin.sales.model.User;
import com.orgin.sales.service.ProductService;
import com.orgin.sales.validator.ProductDetailValidation;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
    @Autowired
    ProductDetailValidation productDetailValidator;
    
    @GetMapping(value = "/product")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Product>> getAllUserByAdmin()
    {
    	List<Product> users = productService.findAll();
    	return new ResponseEntity<List<Product>>(users,HttpStatus.OK);
    }
    
    @PostMapping(value = "/product")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<Product>> findAllByAdminId(@RequestBody User user)
    {
    	List<Product> users = productService.findAllByAdminId(user.getAdminId());
    	return new ResponseEntity<List<Product>>(users,HttpStatus.OK);
    }
    
	@PostMapping(value = "/addproduct")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public Boolean addProduct(@RequestBody Product product)
	{ 
		if(productDetailValidator.validateProduct(product)) {
		Product dbProduct = productService.save(product);
		if(dbProduct!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		else
		{
			return false;
		}
	}
}
