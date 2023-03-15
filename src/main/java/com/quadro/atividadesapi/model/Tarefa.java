package com.quadro.atividadesapi.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarefa {
	@Id
	@SequenceGenerator(name = "pk_tarefa", sequenceName= "tarefa_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_tarefa")
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	
	private Date dataCriacao;
	
	private Date dataAtualizacao;
	
	private Date dataConclusao;
	
	private String status;
	
	private Integer lista;
	
	

}
