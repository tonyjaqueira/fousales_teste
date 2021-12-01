package br.com.foursales.cartao.dto;

import java.time.LocalDate;
import java.util.List;

public class CandidateDTO {
	
	private Long id;
	
	private String name;
	
	private LocalDate birthDate;
	
	private String cpf;
	
	private List<CreditCardDTO> listaCards;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public CandidateDTO(Long id, String name, LocalDate birthDate, String cpf, List<CreditCardDTO> listaCards) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.listaCards = listaCards;
	}
	
	public CandidateDTO(Long id) {
		this.id = id;
	}
	
	public CandidateDTO() {
		
	}

	public List<CreditCardDTO> getListaCards() {
		return listaCards;
	}

	public void setListaCards(List<CreditCardDTO> listaCards) {
		this.listaCards = listaCards;
	}
	
}
