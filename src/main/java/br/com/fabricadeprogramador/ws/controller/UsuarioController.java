package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Usuario;
import br.com.fabricadeprogramador.ws.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/usuarios", 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioCadastrado = usuarioService.salvar(usuario);
		
		return new ResponseEntity<Usuario>(usuarioCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/usuarios", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarTodosUsuarios() {

		Collection<Usuario> usuarioRetornados = usuarioService.buscarTodos();

		return new ResponseEntity<>(usuarioRetornados, HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/usuarios/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuariosPorId(@PathVariable Long id) {

		Usuario usuarioRetornado = usuarioService.buscarPorId(id);

		return new ResponseEntity<>(usuarioRetornado, HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/usuarios/{id}") 
	public ResponseEntity<Usuario> excluirUsuario(@PathVariable Long id) {

		Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
		
		if (usuarioEncontrado == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		usuarioService.excluir(usuarioEncontrado);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/usuarios", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {

		Usuario usuarioAlterado = usuarioService.salvar(usuario);

		return new ResponseEntity<Usuario>(usuarioAlterado, HttpStatus.OK);
	}
}
