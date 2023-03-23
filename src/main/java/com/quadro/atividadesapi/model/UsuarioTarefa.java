package com.quadro.atividadesapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Setter;
import lombok.Getter;

@Entity
@Setter
@Getter
@Table(schema="atividades")
public class UsuarioTarefa {
	@Id
	@SequenceGenerator(name = "pk_usuario_tarefa", sequenceName= "usuario_tarefa_id_seq" , allocationSize = 1, schema="atividades")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_usuario_tarefa")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="tarefa")
	private Tarefa tarefa;

}
