package com.backend.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.validadores.ValidarQuantidadeDeCaracteres;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresEspeciais;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresEspeciaisNaoPermitidos;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresMaiusculos;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresMinusculos;
import com.backend.challenge.service.validadores.ValidarSeContemDigito;
import com.backend.challenge.service.validadores.ValidarSeNaoContemEspaco;

@SpringBootTest
public class ValidacaoDeCaracteresTest {

	@InjectMocks
	ValidarQuantidadeDeCaracteres quantidadeDeCaracteres;

	@InjectMocks
	ValidarSeContemCaracteresEspeciais validarSeContemCaracteresEspeciais;
	
	@InjectMocks
	ValidarSeContemCaracteresEspeciaisNaoPermitidos validarSeContemCaracteresEspeciaisNaoPermitidos;

	@InjectMocks
	ValidarSeContemCaracteresMaiusculos validarSeContemCaracteresMaiusculos;

	@InjectMocks
	ValidarSeContemCaracteresMinusculos validarSeContemCaracteresMinusculos;

	@InjectMocks
	ValidarSeContemDigito validarSeContemDigito;

	@InjectMocks
	ValidarSeNaoContemEspaco validarSeNaoContemEspaco;

	@Test
	public void caracteresMinusculosTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeContemCaracteresMinusculos.validar("minusculos");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void caracteresMinusculosTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeContemCaracteresMinusculos.validar("MINUSCULOS"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

	@Test
	public void caracteresMaiusculosTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeContemCaracteresMaiusculos.validar("MAIUSCULO");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void caracteresMaiusculosTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeContemCaracteresMaiusculos.validar("maiusculo"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

	@Test
	public void quantidadeDeCaracteresTestTrue() throws ValidarSenhaException {
		boolean validacao = quantidadeDeCaracteres.validar("123456789");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void quantidadeDeCaracteresTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> quantidadeDeCaracteres.validar("12345678"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

	@Test
	public void validarSeContemDigitoTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeContemDigito.validar("123456789");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void validarSeContemDigitoTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeContemDigito.validar("ABCDEFGHI"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

	@Test
	public void validarSeContemCaracteresEspeciaisTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeContemCaracteresEspeciais.validar("@@@@@@@@@");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void validarSeContemCaracteresEspeciaisTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeContemCaracteresEspeciais.validar("AAAAAAAAA"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}
	
	@Test
	public void validarSeContemCaracteresEspeciaisNaoPermitidosTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeContemCaracteresEspeciaisNaoPermitidos.validar("!");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void validarSeContemCaracteresEspeciaisNaoPermitidosTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeContemCaracteresEspeciaisNaoPermitidos.validar("="));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

	@Test
	public void validarSeContemEspacoTestTrue() throws ValidarSenhaException {
		boolean validacao = validarSeNaoContemEspaco.validar("AbTp9Efok");
		boolean expected = true;
		assertEquals(expected, validacao);
	}

	@Test
	public void validarSeContemEspacoTestFalse() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> validarSeNaoContemEspaco.validar("AbTp 9Efok"));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}

}