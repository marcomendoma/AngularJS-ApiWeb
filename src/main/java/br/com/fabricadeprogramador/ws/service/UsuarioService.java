package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Usuario;
import br.com.fabricadeprogramador.ws.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario){
		return usuarioRepository.save(usuario); 
	}
	
	public Collection<Usuario>  buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	public void excluir(Usuario usuario){
		usuarioRepository.delete(usuario);
	}
	
	public Usuario buscarPorId(Long id){
		return usuarioRepository.findOne(id);
	}
	
	public Usuario buscarPorNome(String nome){
		return usuarioRepository.buscarPorNome(nome);
	}
	
	//public List<Usuario> findByNome(String Nome){
	//	return (List<Usuario>) usuarioRepository.findByNome(Nome);
	//}
}
