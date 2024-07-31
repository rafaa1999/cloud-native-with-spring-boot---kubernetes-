package com.rafaa.cloud_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudServiceApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	void when_get_root_then_return_message() {
		webTestClient
				.get()
				.uri("/")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Spring Boot on the cloud!");

	}


}
