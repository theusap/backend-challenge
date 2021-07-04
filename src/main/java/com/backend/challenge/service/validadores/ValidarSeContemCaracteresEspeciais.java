package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarSeContemCaracteresEspeciais implements ValidarSenhaService {

	/*
	 * Validar caracteres especiais
	 */
	private final static String VALIDAR_SE_CONTEM_CARACTERES_ESPECIAL = "^(?=.*[!@#$%^&*()-+]).+$";

	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se contem catacteres especiais");
		Pattern pattern = Pattern.compile(VALIDAR_SE_CONTEM_CARACTERES_ESPECIAL);
		Matcher matcher = pattern.matcher(senha);
		if (matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarSeContemCaracteresEspeciais >> A senha deve conter no minimo 1 caracter especial - Caracteres permitidos !@#$%^&*()-+");
	}

}
