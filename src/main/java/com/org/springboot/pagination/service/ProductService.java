package com.org.springboot.pagination.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.org.springboot.pagination.entity.Product;
import com.org.springboot.pagination.repsitory.ProductRepository;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductService
{
	private final ProductRepository repository;

	public ProductService(ProductRepository repository)
	{
		this.repository = repository;
	}

	// This method needs to be run once in a single life cycle and will need be commented out for every subsequent run
	// in case any other DB is used apart from H2

	@PostConstruct
	public void initDB()
	{
		List<Product> products = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
				.collect(Collectors.toList());

		log.info("Adding 200 products into database with initialization of the service");

		repository.saveAll(products);
	}

	public List<Product> findAllProducts()
	{
		return repository.findAll();
	}

	// Implementation of Sorting logic depending on the input field

	public List<Product> findProductsWithSorting(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC, field)); // for sorting into Descending order, use: Sort.Direction.DESC
	}

	// Implementation of pagination logic with offset(page number) and pageSize(no. of records per page)

	public Page<Product> findProductsWithPagination(int offset, int pageSize)
	{
		return repository.findAll(PageRequest.of(offset, pageSize));
	}

}
