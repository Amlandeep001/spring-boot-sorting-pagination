package com.org.springboot.pagination.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springboot.pagination.dto.APIResponse;
import com.org.springboot.pagination.entity.Product;
import com.org.springboot.pagination.service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/products")
@Log4j2
public class ProductController {
	
	private final ProductService service;
	
	public ProductController(ProductService service) {
		
		this.service = service;
	}
	
	@GetMapping
	private APIResponse<List<Product>> getProducts(){
		
		List<Product> allProducts = service.findAllProducts();
		return new APIResponse<>(allProducts.size(), allProducts);
		
	}
	
	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field){
		
		log.info("Displaying products after sorting in Ascending order on basis of: {}", field);
		
		List<Product> allProducts = service.findProductsWithSorting(field);
		return new APIResponse<>(allProducts.size(), allProducts);
		
	}
	
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
		
		log.info("Displaying products after pagination where page number: {} and count in per page: {}", offset, pageSize);
		
		Page<Product> productrsWithPagination = service.findProductsWithPagination(offset, pageSize);
		return new APIResponse<>(productrsWithPagination.getSize(), productrsWithPagination);
		
	}
}