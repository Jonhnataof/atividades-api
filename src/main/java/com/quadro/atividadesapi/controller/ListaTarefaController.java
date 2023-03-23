package com.quadro.atividadesapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quadro.atividadesapi.model.ListaTarefa;
import com.quadro.atividadesapi.service.ListaTarefaService;

@RestController
@RequestMapping("/lista-tarefa")
public class ListaTarefaController {
	@Autowired
	private ListaTarefaService listatarefaService;

	@GetMapping()
	public ResponseEntity<List<ListaTarefa>> findAll() {
		List<ListaTarefa> result = listatarefaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<ListaTarefa>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<ListaTarefa>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ListaTarefa>> findById(@PathVariable Integer id) {
		Optional<ListaTarefa> result = listatarefaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<ListaTarefa>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<ListaTarefa>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ListaTarefa> save(@RequestBody ListaTarefa listatarefa) {
		
		listatarefaService.save(listatarefa);

		return ResponseEntity.ok(listatarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ListaTarefa> update(@PathVariable Integer id, @RequestBody ListaTarefa listatarefa) {
		ListaTarefa listatarefaAtualizado = listatarefaService.findById(id).get();
		
		listatarefaAtualizado.setNome(listatarefa.getNome());
		listatarefaAtualizado.setDescricao(listatarefa.getDescricao());
		
		listatarefaService.save(listatarefaAtualizado);

		return ResponseEntity.ok(listatarefaAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		listatarefaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
