package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarSeNaoContemEspaco implements ValidarSenhaService {
	
	/*
	 *  Validar se nao contem espacos
	 */
	private final static String VALIDAR_SE_NAO_CONTEM_ESPACO = "[^\\ ]+";
	
	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se nao contem espaco");
		Pattern pattern = Pattern.compile(VALIDAR_SE_NAO_CONTEM_ESPACO);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarSeNaoContemEspaco >>> A senha não pode conter espaços");
	}

}
