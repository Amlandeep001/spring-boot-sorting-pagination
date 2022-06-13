package com.org.springboot.pagination.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springboot.pagination.entity.Product;

/**
 * 
 * @author amlandeep.nandi
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
