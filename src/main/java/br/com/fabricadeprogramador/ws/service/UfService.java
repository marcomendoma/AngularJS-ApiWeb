package br.com.fabricadeprogramador.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Estado;
import br.com.fabricadeprogramador.ws.repository.UfRepository;

@Service
public class UfService {

	@Autowired
	private UfRepository ufRepository;
	
	public Estado salvar(Estado estado){
		return ufRepository.save(estado);
	}
	
	public List<Estado> buscarTodos(){
		return ufRepository.findAll();
	}
	
	public Estado buscarPorId(Long id){
		return ufRepository.findOne(id);
	}
	
	public void excluir(Estado estado){
		ufRepository.delete(estado);
	}
}
