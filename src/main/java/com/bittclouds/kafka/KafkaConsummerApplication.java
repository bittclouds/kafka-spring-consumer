package com.bittclouds.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsummerApplication {

	@Value("${kafka.topic.mytopic}")
	private String myTopic;

	@Value("${kafka.bootstrap.servers}")
	private String kafkaBootstrapServers;

	@Value("${zookeeper.groupId}")
	private String zookeeperGroupId;

	@Value("${zookeeper.host}")
	String zookeeperHost;

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsummerApplication.class, args);
	}

	@KafkaListener(topics = "my_topic", groupId = "test")
	public void listen(String message) {
	    System.out.println("Received Message: " + message);
	}

}
