package com.quadro.atividadesapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;

import lombok.Setter;
import lombok.Getter;

@Entity
@Getter
@Setter
public class ListaTarefa {
	@Id
	@SequenceGenerator(name = "pk_lista_tarefa", sequenceName= "lista_tarefa_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_lista_tarefa")
	private Integer id;
	
	private String nome;
	
	private String descricao;

}
