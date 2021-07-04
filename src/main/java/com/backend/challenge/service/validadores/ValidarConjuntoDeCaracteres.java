package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarConjuntoDeCaracteres implements ValidarSenhaService {

	/*
	 *  Não possuir caracteres repetidos
	 */
	private final static String VALIDAR_CARACTERES_REPETIDO = "(?:(.)(?=(.*)\\1))";

	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se não com caracteres repetidos");
		Pattern pattern = Pattern.compile(VALIDAR_CARACTERES_REPETIDO);
		Matcher matcher = pattern.matcher(senha);
		if (!matcher.find()) 
			return true;
		throw new ValidarSenhaException("ValidacaoDeConjuntoDeCaracteres >>> A senha não pode ter caracteres repetidos");
	}

}
