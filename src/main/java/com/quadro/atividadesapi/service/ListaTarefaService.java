package com.quadro.atividadesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadro.atividadesapi.model.ListaTarefa;
import com.quadro.atividadesapi.repository.ListaTarefaRepository;

@Service
public class ListaTarefaService {
	@Autowired
	private ListaTarefaRepository listatarefaRepository;

	public List<ListaTarefa> findAll() {
		return (List<ListaTarefa>) listatarefaRepository.findAll();
	}

	public Optional<ListaTarefa> findById(Integer id) {
		return listatarefaRepository.findById(id);
	}

	public void save(ListaTarefa listatarefa) {
		listatarefaRepository.save(listatarefa);
	}

	public void delete(Integer id) {
		listatarefaRepository.deleteById(id);
	}


}
