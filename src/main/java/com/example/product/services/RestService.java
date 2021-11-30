package com.example.product.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import com.example.product.entities.ElasticProduct;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RestService {

	private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @PostMapping
    public Object addProductToElastic(String productId,ElasticProduct elasticProduct) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Content-Type", "application/json");      
    	headers.setBasicAuth("root", "Dpk1@elastic");
    	HttpEntity<Object> request = new HttpEntity<>(elasticProduct, headers);

    	
    	String OPEN_SEARCH_DOMAIN_ENDPOINT_PRODUCTS = "https://search-ecommerce-elastic-7lwzjckl34fgylx7btdtjrgnie.ap-south-1.es.amazonaws.com/products/_doc/" + productId;
        Object serverResponse =  this.restTemplate.postForObject(OPEN_SEARCH_DOMAIN_ENDPOINT_PRODUCTS, request, Object.class);
        log.info("server response ",serverResponse);
        return serverResponse;
    }
}
