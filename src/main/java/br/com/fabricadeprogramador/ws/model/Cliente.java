package br.com.fabricadeprogramador.ws.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="cliente")
public class Cliente { 
	
	@Id
	@SequenceGenerator(name = "cliente_id", sequenceName = "cliente_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cliente_id")
	private Long id;
	
	@NotEmpty(message="Nome do cliente: campo obrigatório.")
	@Column(name="nome", length=50)
	private String nome;
	
	@OneToMany()
	@JoinColumn(name="id_cliente")
	private List<Estado> estados;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
}
