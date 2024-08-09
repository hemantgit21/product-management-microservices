package com.inventoryservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Inventoryservices {

	private final InventoryRepository inventoryRepository;

	@Transactional(readOnly = true)
	public boolean isInstock(String skucode) {
		return inventoryRepository.findBySkucode(skucode).isPresent();
	}
}
