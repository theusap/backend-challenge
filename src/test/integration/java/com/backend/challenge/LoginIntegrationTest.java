package com.backend.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.challenge.controller.SenhaController;
import com.backend.challenge.domain.SenhaResponse;
import com.backend.challenge.domain.SenhaResquet;
import com.backend.challenge.service.SenhaService;

@SpringBootTest
public class LoginIntegrationTest {

	@Autowired
	SenhaController controller;

	@Autowired
	SenhaService service;

	@BeforeEach
	public void init() {
		this.controller = new SenhaController(service);
	}

	@Test
	void senhaValidaTrueIntegrationTest() {
		ResponseEntity<SenhaResponse> responseEntity = controller.login(loginResquetMock());
		HttpStatus statusExpected = HttpStatus.OK;
		Boolean senhaValidaExpected = true;
		assertEquals(statusExpected, responseEntity.getStatusCode());
		assertEquals(senhaValidaExpected, responseEntity.getBody().isSenhaValida());
	}
	
	@Test
	void validarSenhaExceptionIntegrationTest() {
		ResponseEntity<SenhaResponse> responseEntity = controller.login(loginResqueErrortMock());
		HttpStatus statusExpected = HttpStatus.UNAUTHORIZED;
		Boolean senhaValidaExpected = false;
		assertEquals(statusExpected, responseEntity.getStatusCode());
		assertEquals(senhaValidaExpected, responseEntity.getBody().isSenhaValida());
	}
	
	@Test
	void senhaExceptionIntegrationTest() {
		ResponseEntity<SenhaResponse> responseEntity = controller.login(loginResquetVazioMock());
		HttpStatus statusExpected = HttpStatus.BAD_REQUEST;
		assertEquals(statusExpected, responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());  
	}

	public SenhaResquet loginResquetMock() {
		return new SenhaResquet("AbTp9!fok");
	}
	
	public SenhaResquet loginResqueErrortMock() {
		return new SenhaResquet("AbTp9!fo");
	}
	
	public SenhaResquet loginResquetVazioMock() {
		return new SenhaResquet();
	}

}