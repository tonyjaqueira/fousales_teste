package br.com.foursales.cartao.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.foursales.cartao.dto.CandidateDTO;
import br.com.foursales.cartao.dto.CreditCardDTO;
import br.com.foursales.cartao.entity.Candidate;
import br.com.foursales.cartao.entity.CreditCard;

@Service
public class CandidateCardMapper {
	
	@Autowired
    private ModelMapper modelMapper;
	
	public CandidateDTO convertToDto(Candidate candidate) {
		CandidateDTO dto = modelMapper.map(candidate, CandidateDTO.class);
		dto.setListaCards(candidate.getListCreditCards().stream().map(this::convertToDto).collect(Collectors.toList()));
		return dto;
	}
	
	public CreditCardDTO convertToDto(CreditCard creditCard) {
		CreditCardDTO dto = modelMapper.map(creditCard, CreditCardDTO.class);
		dto.setIdCandidate(creditCard.getCandidate().getId());
		return dto;
	}
	
	public Candidate convertToEntity(CandidateDTO dto) {
		return modelMapper.map(dto, Candidate.class);
	}
	
	public CreditCard convertToEntity(CreditCardDTO dto) {
		CreditCard creditCard = modelMapper.map(dto, CreditCard.class);
		creditCard.setCandidate(convertToEntity(new CandidateDTO(dto.getIdCandidate())));
		return creditCard;
	}
	
	public List<CandidateDTO> convertClientDTOList(List<Candidate> list) {
		return list
		          .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}
	
	public List<CreditCardDTO> convertCreditDTOList(List<CreditCard> list) {
		return list
		          .stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}

}
