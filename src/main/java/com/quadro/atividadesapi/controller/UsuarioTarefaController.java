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

import com.quadro.atividadesapi.dto.UsuarioTarefaDTO;
import com.quadro.atividadesapi.model.Tarefa;
import com.quadro.atividadesapi.model.Usuario;
import com.quadro.atividadesapi.model.UsuarioTarefa;
import com.quadro.atividadesapi.service.TarefaService;
import com.quadro.atividadesapi.service.UsuarioService;
import com.quadro.atividadesapi.service.UsuarioTarefaService;

@RestController
@RequestMapping("/usuario-tarefa")
public class UsuarioTarefaController {
	@Autowired
	private UsuarioTarefaService usuariotarefaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TarefaService tarefaService;

	@GetMapping()
	public ResponseEntity<List<UsuarioTarefa>> findAll() {
		List<UsuarioTarefa> result = usuariotarefaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<UsuarioTarefa>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<UsuarioTarefa>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<UsuarioTarefa>> findById(@PathVariable Integer id) {
		Optional<UsuarioTarefa> result = usuariotarefaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<UsuarioTarefa>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<UsuarioTarefa>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UsuarioTarefa> save(@RequestBody UsuarioTarefaDTO usuariotarefa) {
		UsuarioTarefa novoUsuarioTarefa = new UsuarioTarefa();
		
		Usuario usuario = usuarioService.findById( usuariotarefa.getUsuario() ).get();
		novoUsuarioTarefa.setUsuario(usuario);
		
		Tarefa tarefa = tarefaService.findById(usuariotarefa.getTarefa()).get();
		novoUsuarioTarefa.setTarefa(tarefa);
		
		usuariotarefaService.save(novoUsuarioTarefa);

		return ResponseEntity.ok(novoUsuarioTarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioTarefa> update(@PathVariable Integer id, @RequestBody UsuarioTarefaDTO usuariotarefa) {
		UsuarioTarefa usuariotarefaAtualizado = usuariotarefaService.findById(id).get();
		
		Usuario usuario = usuarioService.findById(usuariotarefa.getUsuario()).get();
		usuariotarefaAtualizado.setUsuario(usuario);
		
		Tarefa tarefa = tarefaService.findById(usuariotarefa.getTarefa()).get();
		usuariotarefaAtualizado.setTarefa(tarefa);
		
		usuariotarefaService.save(usuariotarefaAtualizado);

		return ResponseEntity.ok(usuariotarefaAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		usuariotarefaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
