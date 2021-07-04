package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarSeContemDigito implements ValidarSenhaService {

	/*
	 *  Validar quantidade de digitos
	 */
	private final static String VALIDAR_SE_CONTEM_DIGITO = ".*\\d.*";
	
	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se contem digito");
		Pattern pattern = Pattern.compile(VALIDAR_SE_CONTEM_DIGITO);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarSeContemDigito >>> A senha deve conter no minimo um digito");
	}
	
}
