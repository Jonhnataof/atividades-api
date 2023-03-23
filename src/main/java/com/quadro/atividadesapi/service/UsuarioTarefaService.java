package com.quadro.atividadesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadro.atividadesapi.model.UsuarioTarefa;
import com.quadro.atividadesapi.repository.UsuarioTarefaRepository;

@Service
public class UsuarioTarefaService {
	@Autowired
	private UsuarioTarefaRepository usuarioTarefaRepository;

	public List<UsuarioTarefa> findAll() {
		return (List<UsuarioTarefa>) usuarioTarefaRepository.findAll();
	}

	public Optional<UsuarioTarefa> findById(Integer id) {
		return usuarioTarefaRepository.findById(id);
	}

	public void save(UsuarioTarefa usuariotarefa) {
		// só pode adicionar nova se so tiver menos que 10 tarefas
		// select * from UsuarioTarefa where usuario = 12;
		
		int tarefaId = usuariotarefa.getTarefa().getId();
		int quantidadeDeUsuariosNaTarefa = usuarioTarefaRepository.countByTarefaId(tarefaId);
		
		if (quantidadeDeUsuariosNaTarefa < 2) {
			usuarioTarefaRepository.save(usuariotarefa);
		}
//		int usuarioId = usuariotarefa.getUsuario().getId();
//		int quantidadeDeTarefasDoUsuario = usuarioTarefaRepository.countByUsuarioId(usuarioId);
//		
//		if (quantidadeDeTarefasDoUsuario < 10) {
//			usuarioTarefaRepository.save(usuariotarefa);
//		}
		
		usuarioTarefaRepository.save(usuariotarefa);
	}

	public void delete(Integer id) {
		usuarioTarefaRepository.deleteById(id);
	}

}
