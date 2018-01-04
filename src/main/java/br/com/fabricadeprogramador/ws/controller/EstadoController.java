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

import br.com.fabricadeprogramador.ws.model.Estado;
import br.com.fabricadeprogramador.ws.service.UfService;

@RestController
public class EstadoController {

	@Autowired
	private UfService ufService;
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/estados", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> cadastrarEstado(@RequestBody Estado estado) {

		Estado estadoCadastrado = ufService.salvar(estado);

		return new ResponseEntity<Estado>(estadoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/estados", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Estado>> buscarTodosEstados() {

		Collection<Estado> estadoRetornados = ufService.buscarTodos();

		return new ResponseEntity<>(estadoRetornados, HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/estados/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> buscarestadosPorId(@PathVariable Long id) {

		Estado estadoRetornado = ufService.buscarPorId(id);

		return new ResponseEntity<>(estadoRetornado, HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/estados/{id}") 
	public ResponseEntity<Estado> excluirestado(@PathVariable Long id) {

		Estado estadoEncontrado = ufService.buscarPorId(id);
		
		if (estadoEncontrado == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		ufService.excluir(estadoEncontrado);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/estados", 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> alterarestado(@RequestBody Estado estado) {

		Estado estadoAlterado = ufService.salvar(estado);

		return new ResponseEntity<Estado>(estadoAlterado, HttpStatus.OK);
	}
}
