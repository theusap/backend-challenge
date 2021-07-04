package com.backend.challenge.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.backend.challenge.domain.SenhaResponse;
import com.backend.challenge.domain.SenhaResquet;
import com.backend.challenge.exception.SenhaException;
import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.SenhaService;

@SpringBootTest
public class LoginControllerTest {

	SenhaController controller;
	SenhaService service;

	@BeforeEach
	public void init() {
		this.service = mock(SenhaService.class);
		this.controller = new SenhaController(service);
	}

	@Test
	public void loginTest() {

		ResponseEntity<SenhaResponse> responseEntity = controller.login(mockResquet());
		HttpStatus expected = HttpStatus.OK;
		assertEquals(expected, responseEntity.getStatusCode());
	}

	@Test
	public void loginValidarSenhaExceptionTest() throws SenhaException, ValidarSenhaException {

		when(service.validarSenha(any())).thenThrow(new ValidarSenhaException("ValidarSenhaException"));

		ResponseEntity<SenhaResponse> responseEntity = controller.login(mockResquet());
		HttpStatus expected = HttpStatus.UNAUTHORIZED;
		assertEquals(expected, responseEntity.getStatusCode());
	}

	@Test
	public void loginSenhaExceptionTest() throws SenhaException, ValidarSenhaException {

		when(service.validarSenha(any())).thenThrow(new SenhaException("SenhaException"));

		ResponseEntity<SenhaResponse> responseEntity = controller.login(mockResquet());
		HttpStatus expected = HttpStatus.BAD_REQUEST;
		assertEquals(expected, responseEntity.getStatusCode());
	}

	@Test
	public void loginExceptionTest() throws SenhaException, ValidarSenhaException {

		when(service.validarSenha(any())).thenThrow(new RuntimeException());

		ResponseEntity<SenhaResponse> responseEntity = controller.login(mockResquet());
		HttpStatus expected = HttpStatus.INTERNAL_SERVER_ERROR;
		assertEquals(expected, responseEntity.getStatusCode());
	}

	public SenhaResponse mockSenhaResponse() {
		return new SenhaResponse(true);
	}

	public SenhaResquet mockResquet() {
		return new SenhaResquet("AbTp9!fok");
	}

}
