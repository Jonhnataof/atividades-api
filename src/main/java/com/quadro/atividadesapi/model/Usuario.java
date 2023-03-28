package com.quadro.atividadesapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(schema="atividades")
public class Usuario {
	@Id
	@SequenceGenerator(name = "pk_usuario", sequenceName= "usuario_id_seq" , allocationSize = 1,  schema="atividades")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_usuario")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String senha;

}
