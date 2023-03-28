package com.quadro.atividadesapi.repository;

import com.quadro.atividadesapi.model.UsuarioTarefa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioTarefaRepository extends CrudRepository<UsuarioTarefa, Integer>{
	// select count(*) from usuario_tarefa where usuario = X
	int countByUsuarioId(Integer usuarioId);
	
	int countByTarefaId(Integer tarefaId);
}
