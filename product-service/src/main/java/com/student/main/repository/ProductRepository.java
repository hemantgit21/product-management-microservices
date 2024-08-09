package com.student.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.main.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

	
	
}
