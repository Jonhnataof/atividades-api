package com.quadro.atividadesapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quadro.atividadesapi.model.Usuario;
import com.quadro.atividadesapi.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	public void save(Usuario usuario) {
		String senha = usuario.getSenha();
		int quantidadeDeCaractere = senha.length();
		//int qtd = usuario.getSenha().length();
		
		String email = usuario.getEmail();
		
		Usuario u = usuarioRepository.findByEmail(email);
		
		if (quantidadeDeCaractere >= 8 && senha.startsWith("a") && senha.endsWith("0") && email.contains("@") && email.contains(".com") && u== null) {
			usuarioRepository.save(usuario);
		}
	}

	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}


}
