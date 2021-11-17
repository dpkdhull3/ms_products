package com.example.product.utils;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document(collection = "categorySequence")
public class CategorySequence {
	@Id
    private String id;
	@Getter
    private long seq;

}
