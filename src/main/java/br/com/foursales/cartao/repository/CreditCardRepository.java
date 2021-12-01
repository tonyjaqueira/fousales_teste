package br.com.foursales.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.foursales.cartao.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

}
