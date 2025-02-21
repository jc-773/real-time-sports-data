package com.real_time.reail_time_sports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReailTimeSportsApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebClient webService() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ReailTimeSportsApplication.class, args);
	}

}
