package com.backend.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.validadores.ValidarConjuntoDeCaracteres;

@SpringBootTest
public class ValidacaoDeConjuntoDeCaracteresTest {

	@InjectMocks
	ValidarConjuntoDeCaracteres validarConjuntoDeCaracteres;

	@Test
	public void validacaoDeConjuntoDeCaracteresTest() throws ValidarSenhaException {
		boolean validacao = validarConjuntoDeCaracteres.validar("AbTp9!fok");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void erroValidacaoDeConjuntoDeCaracteresTest() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarConjuntoDeCaracteres.validar("AbTp9!foA"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

}
