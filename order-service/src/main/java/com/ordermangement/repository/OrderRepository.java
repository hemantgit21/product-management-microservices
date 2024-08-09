package com.ordermangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermangement.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
