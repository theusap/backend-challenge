package com.backend.challenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SenhaResponse {

	public SenhaResponse(Boolean senhaValida) {
		this.senhaValida = senhaValida;
	}

	@JsonProperty("senhaValida")
	private Boolean senhaValida;

	public Boolean isSenhaValida() {
		return senhaValida;
	}

}
