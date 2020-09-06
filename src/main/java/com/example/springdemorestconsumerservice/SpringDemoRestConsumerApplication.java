package com.example.springdemorestconsumerservice;

import com.example.springdemorestconsumerservice.model.Quote;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Log4j2
@SpringBootApplication
public class SpringDemoRestConsumerApplication {
	public static final String URL = "https://gturnquist-quoters.cfapps.io/api/random";

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoRestConsumerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return (args -> {
			Quote quote = restTemplate.getForObject(URL, Quote.class);
			log.info(quote.toString());
		});
	}
}
