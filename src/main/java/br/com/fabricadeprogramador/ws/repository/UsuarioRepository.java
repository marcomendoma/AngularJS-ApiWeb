package br.com.fabricadeprogramador.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fabricadeprogramador.ws.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//@Query(value="select u from Usuario u where u.nome=?1")
	@Query(value="select * from Usuarios where nome=?0", nativeQuery=true)
	public Usuario buscarPorNome(String nome);
	
	//public List<Usuario> findByNome(String Nome);
}
