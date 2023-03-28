package com.quadro.atividadesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadro.atividadesapi.model.Tarefa;
import com.quadro.atividadesapi.repository.ListaTarefaRepository;
import com.quadro.atividadesapi.repository.TarefaRepository;
import com.quadro.atividadesapi.repository.UsuarioTarefaRepository;

@Service
public class TarefaService {
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioTarefaRepository usuarioTarefaRepository;

	public List<Tarefa> findAll() {
		return (List<Tarefa>) tarefaRepository.findAll();
	}

	public Optional<Tarefa> findById(Integer id) {
		return tarefaRepository.findById(id);
	}

	public void save(Tarefa tarefa) {
		String titulo = tarefa.getTitulo();
		int qtd = tarefa.getDescricao().length();
		
		
		if (titulo.startsWith("#") && (qtd <= 2000)) {
			tarefaRepository.save(tarefa);
		}
		
	}

	public void delete(Integer id) {
		// ver todos os lista tarefe que tem alguma tarefa para esse id
		int quantidadeDeUsuariosNessaTarefa = usuarioTarefaRepository.countByTarefaId(id);
		if(quantidadeDeUsuariosNessaTarefa == 0) {			
			tarefaRepository.deleteById(id);
		}
	}

}
