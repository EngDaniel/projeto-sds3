package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service //considera como componente, serviço que chama o repository
public class SellerService {
	
	@Autowired // instância injetada automaticamente pelo framework
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		// converter para lista de SellerDTO
		// Para cada item da lista cria um novo objeto DTO e converte novamente para lista
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
