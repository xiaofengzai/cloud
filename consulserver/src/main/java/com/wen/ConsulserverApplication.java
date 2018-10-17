package com.wen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulserverApplication.class, args);
	}
}
