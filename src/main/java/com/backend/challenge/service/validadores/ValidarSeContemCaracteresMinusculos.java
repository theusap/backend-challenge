package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarSeContemCaracteresMinusculos implements ValidarSenhaService {

	/*
	 * Validar quantidade de caracteres minusculos
	 */
	private final static String VALIDAR_SE_CONTEM_CARACTERES_MINUSCULO = "^(?=.*[a-z]).+$";

	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se contem caracteres minusculos");
		Pattern pattern = Pattern.compile(VALIDAR_SE_CONTEM_CARACTERES_MINUSCULO);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarSeContemCaracteresMinusculos >>> A senha deve conter no minimo uma letra minuscula");
	}

}
