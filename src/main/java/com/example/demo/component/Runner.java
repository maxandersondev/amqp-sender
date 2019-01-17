package com.example.demo.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;

	private final ConfigurableApplicationContext context;

	public Runner(RabbitTemplate rabbitTemplate, ConfigurableApplicationContext context) {

		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		for (int x = 0; x < 100; x++) {
			System.out.println("Sending message...");
			rabbitTemplate.convertAndSend("spring-boot", x + ": Hello from RabbitMQ!");
		}
		context.close();
	}

}
