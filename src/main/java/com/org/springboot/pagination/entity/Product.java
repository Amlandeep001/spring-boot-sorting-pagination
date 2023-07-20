package com.org.springboot.pagination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "product")
public class Product
{

	@Id
	@GeneratedValue
	int id;
	String name;
	int quantity;
	long price;

	public Product(String name, int quantity, long price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
}
