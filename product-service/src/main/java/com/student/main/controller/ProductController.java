package com.student.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student.main.dto.ProductRequest;
import com.student.main.dto.ProductResponse;
import com.student.main.model.Product;
import com.student.main.repository.ProductRepository;
import com.student.main.services.ProductServices;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

	private final ProductServices productservices ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	
	public void createdproduct(@RequestBody ProductRequest productrequest)
	{
         productservices.createProduct(productrequest);
	
	
	}    
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllproduct() {

		
		return productservices.getAllProduct();
	}
	
	
	
}
