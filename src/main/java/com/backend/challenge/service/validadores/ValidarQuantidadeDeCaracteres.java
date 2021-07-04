package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarQuantidadeDeCaracteres implements ValidarSenhaService {

	/*
	 * Validar quantidade de caracteres
	 */
	private final static String VALIDAR_QUANTIDADE_DE_CARACTERES = ".{9,}";

	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando a quantidade de caractres");
		Pattern pattern = Pattern.compile(VALIDAR_QUANTIDADE_DE_CARACTERES);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarQuantidadeDeCaracteres >>> A senha deve ter no minimo 9 caracteres");
	}

}
