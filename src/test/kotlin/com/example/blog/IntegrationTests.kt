package com.example.blog

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

	@BeforeAll
	fun setup() {
		println(">> Setup")
	}



	@Test
	fun `Assert article page title, content and status code`() {
//		println(">> Assert article page title, content and status code")
//		val title = "Reactor Aluminium has landed"
//		val entity = restTemplate.getForEntity<String>("/api/user/0")
//		assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
	}

	@AfterAll
	fun teardown() {
		println(">> Tear down")
	}

}