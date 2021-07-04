package com.backend.challenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenhaResquet {
	
	public SenhaResquet(String senha) {
		this.senha = senha;
	}
	
	public SenhaResquet() {
	}

	@JsonProperty("senha")
	private String senha;

	public String getSenha() {
		return senha;
	}
	
}
