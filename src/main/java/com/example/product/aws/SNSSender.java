package com.example.product.aws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.example.product.entities.Product;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class SNSSender {

	@Autowired
	private AmazonSNSClient snsClient;

	String TOPIC_ARN = "arn:aws:sns:ap-south-1:062115412779:topic2";


	public void publishMessageToTopic(Product product) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, buildEmailBody(product),
				"Adding Product");
		
		log.info(TOPIC_ARN, publishRequest);
		
        
		snsClient.publish(publishRequest);
		
	}

	private String buildEmailBody(Product product) {
		return product.getProductName() + " Added successfully";
	}
}
