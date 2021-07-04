package com.backend.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.challenge.domain.SenhaResponse;
import com.backend.challenge.domain.SenhaResquet;
import com.backend.challenge.exception.SenhaException;
import com.backend.challenge.exception.ValidarSenhaException;
import com.backend.challenge.service.SenhaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class SenhaController {

	SenhaService service;

	@Autowired
	public SenhaController(SenhaService service) {
		this.service = service;
	}

	@PostMapping(path = "/senha")
	public ResponseEntity<SenhaResponse> login(@RequestBody SenhaResquet resquet) {
		try {
			return new ResponseEntity<>(service.validarSenha(resquet), HttpStatus.OK);
		}
		catch (ValidarSenhaException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(new SenhaResponse(false), HttpStatus.UNAUTHORIZED);
		}
		catch (SenhaException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}