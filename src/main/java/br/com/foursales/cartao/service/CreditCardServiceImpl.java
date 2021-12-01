package br.com.foursales.cartao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.foursales.cartao.entity.Candidate;
import br.com.foursales.cartao.entity.CreditCard;
import br.com.foursales.cartao.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	@Autowired
	CandidateService candidateService;

	@Override
	public void save(CreditCard creditCard) {
		Candidate candidate = candidateService.findById(creditCard.getCandidate().getId());
				  creditCard.setCandidate(candidate);
		creditCardRepository.save(creditCard);		
	}

	@Override
	public List<CreditCard> listAll() {
		return Optional.ofNullable(creditCardRepository.findAll())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhum Cartão não encontrado"));
	}

	@Override
	public CreditCard findById(Long id) {
		return Optional.ofNullable(creditCardRepository.findById(id)).get()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado"));
	}

	@Override
	public void update(CreditCard creditCardp) {
		findById(creditCardp.getId());
		creditCardRepository.save(creditCardp);	
	}

	@Override
	public void delete(Long id) {
		findById(id);
		creditCardRepository.deleteById(id);	
	}

}
