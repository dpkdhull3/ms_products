package com.example.product.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SQSListener {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	public void sendMessageToQueue() {
		queueMessagingTemplate.send("https://sqs.ap-south-1.amazonaws.com/062115412779/product-queue",
				MessageBuilder.withPayload("queue message").build());
	}

	@SqsListener("product-queue")
	public void loadMessagesFromQueue(String message) {
		log.info("sqs message received1 " + message);
	}

}
