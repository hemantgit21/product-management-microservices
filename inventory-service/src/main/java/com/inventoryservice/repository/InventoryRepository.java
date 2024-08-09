package com.inventoryservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventoryservice.model.Inventory;
import java.util.List;


public interface InventoryRepository extends JpaRepository<Inventory, Long> { 
	Optional <Inventory>  findBySkucode(String skucode);

	
}
