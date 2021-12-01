package br.com.foursales.cartao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.foursales.cartao.entity.Candidate;
import br.com.foursales.cartao.repository.CandidateRespository;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	CandidateRespository repository;
	
	@Override
	public void save(Candidate candidate) {
		repository.save(candidate);
	}
	
	@Override
	public List<Candidate> listAll() {
		return Optional.ofNullable(repository.findAll())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum Candidato não encontrado"));
	}
	
	@Override
	public Candidate findById(Long id) {
		return Optional.ofNullable(repository.findById(id)).get()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidato não encontrado"));
	}
	
	@Override
	public void update(Candidate candidatep) {
		findById(candidatep.getId());
		repository.save(candidatep);	
	}
	
	@Override
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);	
	}
	
	
}
