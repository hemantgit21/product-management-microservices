package com.student.main.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;


@Document(value = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	
}
