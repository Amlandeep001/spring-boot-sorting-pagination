package com.org.springboot.pagination.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	int quantity;
	long price;
	
	public Product(String name, int quantity, long price) {
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
	}
}
