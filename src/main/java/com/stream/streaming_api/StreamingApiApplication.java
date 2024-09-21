package com.stream.streaming_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class StreamingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamingApiApplication.class, args);
	}

}
