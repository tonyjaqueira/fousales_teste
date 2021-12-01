package br.com.foursales.cartao.service;

import java.util.List;

import br.com.foursales.cartao.entity.CreditCard;

public interface CreditCardService {

	void save(CreditCard creditCard);

	List<CreditCard> listAll();

	CreditCard findById(Long id);

	void update(CreditCard creditCardp);

	void delete(Long id);
	
}
