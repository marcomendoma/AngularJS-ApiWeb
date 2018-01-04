package br.com.fabricadeprogramador.ws.controller;

import java.util.Date;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Usuario;
import br.com.fabricadeprogramador.ws.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar", 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse autenticar(@RequestBody Usuario usuario) throws ServletException{
		if (usuario.getNome() == null || usuario.getSenha() == null)
			throw new ServletException("Nome e senha são campos obrigatórios !!!");
		
		Usuario usuarioAutenticado = usuarioService.buscarPorNome(usuario.getNome());
		
		if (usuarioAutenticado == null )
			throw new ServletException("Usuário não encontrado !!!");
		
		if (!usuario.getSenha().equals(usuarioAutenticado.getSenha()))
			throw new ServletException("Usuário ou senha inválido !!!");
		
		String sToken = Jwts.builder()
							.setSubject(usuarioAutenticado.getNome())
							.signWith(SignatureAlgorithm.HS512, "banana")
							.setExpiration(new Date(System.currentTimeMillis() + 2 * 60 * 1000))
							.compact();
		
		return new LoginResponse(sToken);
	}
}
