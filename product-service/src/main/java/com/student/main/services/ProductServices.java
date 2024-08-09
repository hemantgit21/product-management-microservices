package com.student.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.main.dto.ProductRequest;
import com.student.main.dto.ProductResponse;
import com.student.main.model.Product;
import com.student.main.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j

public class ProductServices {

	private final ProductRepository productrepository;
	
	public void createProduct(ProductRequest productRequest) 
	{
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
				
				
		productrepository.save(product);
		
		log.info("Product () is saved " , product.getId());
	}
	
	
	
	public List<ProductResponse> getAllProduct() {

		
		List<Product> products = productrepository.findAll();
		
		return products.stream().map(this::maptoProductResponse).toList();
	}
	

	
	
	private ProductResponse maptoProductResponse(Product product)
	{
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build()
				;
		
		
	}
	
	
	
	
	
	
}
