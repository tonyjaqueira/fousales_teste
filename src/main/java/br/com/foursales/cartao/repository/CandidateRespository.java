package br.com.foursales.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursales.cartao.entity.Candidate;

public interface CandidateRespository extends JpaRepository<Candidate, Long>{

}
