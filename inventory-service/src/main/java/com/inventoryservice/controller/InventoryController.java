package com.inventoryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryservice.service.Inventoryservices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
  
	 private final Inventoryservices inventoryservices;
	
	@GetMapping("/{sku-code}")
	@ResponseStatus(HttpStatus.OK)
	
	public boolean isInStock(@PathVariable("sku-code") String skucode)
	{
		return inventoryservices.isInstock(skucode);
	}
   	
}
