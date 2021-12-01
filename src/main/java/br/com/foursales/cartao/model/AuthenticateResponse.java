package br.com.foursales.cartao.model;

public class AuthenticateResponse {
	
	private final String jwttoken;

	public AuthenticateResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}

}
