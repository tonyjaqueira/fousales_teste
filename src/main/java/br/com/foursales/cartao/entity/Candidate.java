package br.com.foursales.cartao.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {

	@Id
	@Column(name="id_candidate")
	@SequenceGenerator(name = "id_candidate_seq", sequenceName = "id_candidate_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_candidate_seq")
	private Long id;
	
	private String name;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	private String cpf;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_candidate")
	private List<CreditCard> listCreditCards;

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(id, other.id);
	}

	public Candidate(Long id) {
		this.id = id;
	}
	
	public Candidate() {
	}

	public List<CreditCard> getListCreditCards() {
		return listCreditCards;
	}

	public void setListCreditCards(List<CreditCard> listCreditCards) {
		this.listCreditCards = listCreditCards;
	}
	
}
