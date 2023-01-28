package com.skillsoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillsoft.springboot.exception.ProductNotFoundException;
import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public List<Product> getAllTopics() {
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable("id") Long pid) {
		
		return productService.getProduct(pid).orElseThrow(()-> new ProductNotFoundException(pid));
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
	}
	
	@PutMapping("/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable("id") Long pid) {
		
		productService.updateProduct(pid, product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable("id") Long pid) {
		
		productService.deleteProduct(pid);
	}
	

}
