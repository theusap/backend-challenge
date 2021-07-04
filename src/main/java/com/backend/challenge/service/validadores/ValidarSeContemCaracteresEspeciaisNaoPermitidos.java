package com.backend.challenge.service.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.ValidarSenhaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ValidarSeContemCaracteresEspeciaisNaoPermitidos implements ValidarSenhaService {
	
	/*
	 * Validar caracteres especiais nao permitidos
	 */
	private final static String VALIDAR_SE_CONTEM_CARACTERES_ESPECIAL_NAO_PERMITIDOS = "^(?=.*['\"¹²³£¢¨¬_=§\\[\\]{ª}º|\\<,>.:;?°]).+$"; 
	
	@Override
	public boolean validar(String senha) throws ValidarSenhaException {
		log.info("Validando se contem catacteres especiais nao permitidos");
		Pattern pattern = Pattern.compile(VALIDAR_SE_CONTEM_CARACTERES_ESPECIAL_NAO_PERMITIDOS);
		Matcher matcher = pattern.matcher(senha);
		if (!matcher.matches()) 
			return true;
		throw new ValidarSenhaException("ValidarSeContemCaracteresEspeciaisNaoPermitidos >> caracter especial não permitido");
	}
}
