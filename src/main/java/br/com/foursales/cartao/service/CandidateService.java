package br.com.foursales.cartao.service;

import java.util.List;

import br.com.foursales.cartao.entity.Candidate;

public interface CandidateService {
	
	void save(Candidate candidate);

	List<Candidate> listAll();

	Candidate findById(Long id);

	void update(Candidate candidatep);

	void delete(Long id);
	
}
