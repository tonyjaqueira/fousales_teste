package br.com.foursales.cartao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.foursales.cartao.dto.CreditCardDTO;
import br.com.foursales.cartao.mapper.CandidateCardMapper;
import br.com.foursales.cartao.service.CreditCardService;

@RestController
@RequestMapping(value = "/creditCard")
public class CreditCardController {
	
	@Autowired
	CreditCardService creditCardService;
	
	@Autowired
	CandidateCardMapper mapper;
	
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody CreditCardDTO creditCardDTO) {
		creditCardService.save(mapper.convertToEntity(creditCardDTO));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping()
	public ResponseEntity<List<CreditCardDTO>> listAll() {
		return ResponseEntity.ok(mapper.convertCreditDTOList(creditCardService.listAll()));
	}
	
	@GetMapping(value = "creditCardById/{idCreditCard}")
	public ResponseEntity<CreditCardDTO> findById(@PathVariable("idCreditCard") Long idCreditCard) {
		return ResponseEntity.ok(mapper.convertToDto(creditCardService.findById(idCreditCard)));
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody CreditCardDTO creditCardDTO) {
		creditCardService.update(mapper.convertToEntity(creditCardDTO));
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		creditCardService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
