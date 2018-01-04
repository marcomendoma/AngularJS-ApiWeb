package br.com.fabricadeprogramador.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="usuarios")
public class Usuario {
	
	@Id
	@SequenceGenerator(name = "usuario_id", sequenceName = "usuario_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "usuario_id")
	private Long id;
	
	@NotEmpty(message="Nome do usuário é campo obrigatório")
	@Column(name="nome", length=10)
	private String Nome;
	
	@NotEmpty(message="Senha do usuário é campo obrigatório")
	@Column(name="senha", length=10)
	private String Senha;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
}
