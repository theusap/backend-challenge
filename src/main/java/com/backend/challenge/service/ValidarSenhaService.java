package com.backend.challenge.service;

import com.backend.challenge.exception.ValidarSenhaException;

public interface ValidarSenhaService {
	
	boolean validar(String senha) throws ValidarSenhaException;

}
