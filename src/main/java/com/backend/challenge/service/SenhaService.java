package com.backend.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.challenge.domain.SenhaResponse;
import com.backend.challenge.domain.SenhaResquet;
import com.backend.challenge.exception.SenhaException;
import com.backend.challenge.exception.ValidarSenhaException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SenhaService {

	private List<ValidarSenhaService> validarSenhaServiceList;

	@Autowired
	public SenhaService(List<ValidarSenhaService> validarSenhaServiceList) {
		this.validarSenhaServiceList = validarSenhaServiceList;
	}

	public SenhaResponse validarSenha(SenhaResquet resquet) throws SenhaException, ValidarSenhaException {

		log.info("SenhaService >>> Validação de senha");

		if (resquet.getSenha() == null || resquet.getSenha().isBlank())
			throw new SenhaException("LoginService >>> O campo senha não pode ser vazio");

		for (ValidarSenhaService validarSenhaService : validarSenhaServiceList) {
			validarSenhaService.validar(resquet.getSenha());
		}
		
		log.info("SenhaService >>> Senha validada com sucesso !!!");

		return new SenhaResponse(true);
	
	}

}