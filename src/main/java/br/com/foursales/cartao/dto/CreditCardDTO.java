package br.com.foursales.cartao.dto;

public class CreditCardDTO {
	
	private Long id;
	
	private String number;
	
	private String validate;
	
	private Integer securityCode;
	
	private Long idCandidate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public Integer getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Integer securityCode) {
		this.securityCode = securityCode;
	}
	

	public CreditCardDTO(Long id, String number, String validate, Integer securityCode, Long idCandidate) {
		this.id = id;
		this.number = number;
		this.validate = validate;
		this.securityCode = securityCode;
		this.idCandidate = idCandidate;
	}
	
	public CreditCardDTO() {
		
	}

	public Long getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(Long idCandidate) {
		this.idCandidate = idCandidate;
	}

}
