package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

// implementa para converter para bytes, trafegar em rede
public class SellerDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public SellerDTO() {
		
	}
	
	// somente precisa do this porque o parâmetro e o atributo tem nomes iguais
	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
