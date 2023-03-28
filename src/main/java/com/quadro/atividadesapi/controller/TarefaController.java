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

import com.quadro.atividadesapi.model.Tarefa;
import com.quadro.atividadesapi.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {
		@Autowired
		private TarefaService tarefaService;

		@GetMapping()
		public ResponseEntity<List<Tarefa>> findAll() {
			List<Tarefa> result = tarefaService.findAll();
			if (result == null || result.isEmpty())
				return new ResponseEntity<List<Tarefa>>(result, HttpStatus.NO_CONTENT);

			return new ResponseEntity<List<Tarefa>>(result, HttpStatus.OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Optional<Tarefa>> findById(@PathVariable Integer id) {
			Optional<Tarefa> result = tarefaService.findById(id);
			if (result == null)
				return new ResponseEntity<Optional<Tarefa>>(result, HttpStatus.NO_CONTENT);

			return new ResponseEntity<Optional<Tarefa>>(result, HttpStatus.OK);
		}

		@PostMapping
		public ResponseEntity<Tarefa> save(@RequestBody Tarefa tarefa) {
			
			tarefaService.save(tarefa);

			return ResponseEntity.ok(tarefa);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
			Tarefa tarefaAtualizada = tarefaService.findById(id).get();
			tarefaAtualizada.setTitulo(tarefa.getTitulo());
			tarefaAtualizada.setDescricao(tarefa.getDescricao());
			tarefaAtualizada.setDataCriacao(tarefa.getDataCriacao());
			tarefaAtualizada.setDataAtualizacao(tarefa.getDataAtualizacao());
			tarefaAtualizada.setDataConclusao(tarefa.getDataConclusao());
			tarefaAtualizada.setStatus(tarefa.getStatus());
			tarefaAtualizada.setLista(tarefa.getLista());
			
			tarefaService.save(tarefaAtualizada);

			return ResponseEntity.ok(tarefaAtualizada);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete(@PathVariable Integer id) {
			tarefaService.delete(id);

			return ResponseEntity.ok("Deletado");
		}


}
