package com.pruebasunitarias.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasunitarias.entity.Usuario;
import com.pruebasunitarias.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Iterable<Usuario> encontrarTodosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Usuario> encontrarUsuarioPorId(@PathVariable(value = "id") long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
			
		if(usuario.isPresent()) {
			return ResponseEntity.ok().body(usuario.get());
		} else {
			return ResponseEntity.notFound().build();
		}
    }
	
	@PostMapping
	public Usuario guardarUsuario(@Validated @RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
}
