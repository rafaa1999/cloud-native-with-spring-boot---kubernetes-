package com.rafaa.cloud_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceApplication.class, args);
	}

}

@ConfigurationProperties(prefix = "demo")
record CloudProperties(String message){}

@RestController
class CloudController{

	private final CloudProperties cloudProperties;

    CloudController(CloudProperties cloudProperties) {
        this.cloudProperties = cloudProperties;
    }

    @GetMapping("/")
	public Mono<String> getMessage() {
		return Mono.just(cloudProperties.message());
	}

}