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

import br.com.foursales.cartao.dto.CandidateDTO;
import br.com.foursales.cartao.mapper.CandidateCardMapper;
import br.com.foursales.cartao.service.CandidateService;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {
	
	@Autowired
	CandidateService candidateCardService;
	
	@Autowired
	CandidateCardMapper mapper;
	

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody CandidateDTO candidateDto) {
		candidateCardService.save(mapper.convertToEntity(candidateDto));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping()
	public ResponseEntity<List<CandidateDTO>> listAll() {
		return ResponseEntity.ok(mapper.convertClientDTOList(candidateCardService.listAll()));
	}
	
	@GetMapping(value = "candidateById/{idCandidate}")
	public ResponseEntity<CandidateDTO> findById(@PathVariable("idCandidate") Long idCandidate) {
		return ResponseEntity.ok(mapper.convertToDto(candidateCardService.findById(idCandidate)));
	}
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody CandidateDTO candidateDto) {
		candidateCardService.update(mapper.convertToEntity(candidateDto));
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		candidateCardService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
