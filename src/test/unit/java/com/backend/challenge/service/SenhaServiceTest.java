package com.backend.challenge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.challenge.domain.SenhaResponse;
import com.backend.challenge.domain.SenhaResquet;
import com.backend.challenge.exception.SenhaException;
import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.validadores.ValidarConjuntoDeCaracteres;
import com.backend.challenge.service.validadores.ValidarQuantidadeDeCaracteres;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresEspeciais;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresMaiusculos;
import com.backend.challenge.service.validadores.ValidarSeContemCaracteresMinusculos;
import com.backend.challenge.service.validadores.ValidarSeContemDigito;
import com.backend.challenge.service.validadores.ValidarSeNaoContemEspaco;

@SpringBootTest
public class SenhaServiceTest {

	SenhaService service;

	List<ValidarSenhaService> validarSenhaServiceList;

	@Autowired
	ValidarConjuntoDeCaracteres validarConjuntoDeCaracteres;

	@Autowired
	ValidarQuantidadeDeCaracteres quantidadeDeCaracteres;

	@Autowired
	ValidarSeContemCaracteresEspeciais validarSeContemCaracteresEspeciais;

	@Autowired
	ValidarSeContemCaracteresMaiusculos validarSeContemCaracteresMaiusculos;

	@Autowired
	ValidarSeContemCaracteresMinusculos validarSeContemCaracteresMinusculos;

	@Autowired
	ValidarSeContemDigito validarSeContemDigito;

	@Autowired
	ValidarSeNaoContemEspaco validarSeNaoContemEspaco;

	@BeforeEach
	public void init() {
		validarSenhaServiceList = Arrays.asList(validarSeNaoContemEspaco, validarSeContemDigito,
				validarSeContemCaracteresMinusculos, validarSeContemCaracteresMaiusculos,
				validarSeContemCaracteresEspeciais, quantidadeDeCaracteres, validarConjuntoDeCaracteres);
		service = new SenhaService(validarSenhaServiceList);
	}

	@Test
	public void validarSenhaTest() throws SenhaException, ValidarSenhaException {
		SenhaResponse senhaResponse = service.validarSenha(loginResquetValidoMock());
		boolean expected = true;
		assertEquals(expected, senhaResponse.isSenhaValida());
	}

	@Test
	public void validarSenhaErroCaracterTest() {
		ValidarSenhaException exception = assertThrows(ValidarSenhaException.class,
				() -> service.validarSenha(loginResquetInvalidoMock()));
		assertEquals(ValidarSenhaException.class, exception.getClass());
	}
	
	@Test
	public void validarSenhaErroNullTest() {
		SenhaException exception = assertThrows(SenhaException.class,
				() -> service.validarSenha(loginResquetNullMock()));
		assertEquals(SenhaException.class, exception.getClass());
	}
	
	@Test
	public void validarSenhaErroEmptyTest() {
		SenhaException exception = assertThrows(SenhaException.class,
				() -> service.validarSenha(loginResquetEmptyMock()));
		assertEquals(SenhaException.class, exception.getClass());
	}
	
	private SenhaResquet loginResquetEmptyMock() {
		return new SenhaResquet("");
	}
	
	private SenhaResquet loginResquetNullMock() {
		return new SenhaResquet(null);
	}

	private SenhaResquet loginResquetValidoMock() {
		return new SenhaResquet("AbTp9!fok");
	}

	private SenhaResquet loginResquetInvalidoMock() {
		return new SenhaResquet("AbTp9!fo");
	}

}