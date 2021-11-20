package com.example.product.entities;



import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticProduct {

	
	private String productName;
	private String productDescription;
	private Double price;
	private Integer stocksQuantity;
	private List<String> productImage;
	private Double discountPercentage;
}
