package com.quadro.atividadesapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Setter;
import lombok.Getter;

@Entity
@Setter
@Getter
public class UsuarioTarefa {
	@Id
	@SequenceGenerator(name = "pk_usuario_tarefa", sequenceName= "usuario_tarefa_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_usuario_tarefa")
	private Integer id;
	
	private Integer usuario;
	
	private Integer tarefa;

}
