package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service //considera como componente, serviço que chama o repository
public class SaleService {
	
	@Autowired // instância injetada automaticamente pelo framework
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; 
	
	@Transactional(readOnly = true) // não fazer lock no banco
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		// converter para lista de SellerDTO
		// Para cada item da lista cria um novo objeto DTO e converte novamente para lista
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true) // não fazer lock no banco	
	public List<SaleSumDTO> amountGroupBySeller() {
		return repository.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true) // não fazer lock no banco	
	public List<SaleSucessDTO> sucessGroupBySeller() {
		return repository.sucessGroupBySeller();
	}	
}
