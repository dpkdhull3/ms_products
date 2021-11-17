package com.example.product.entities;




import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {
	

	@Id()
	private String productId;
	private String productName;
	private String productDescription;
	private Double price;
	private Integer stocksQuantity;
	private List<String> productImage;
	private Double discountPercentage;
	
	


}
