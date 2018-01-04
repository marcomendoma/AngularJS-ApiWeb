package br.com.fabricadeprogramador.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="estado")
public class Estado {
	
	@Id
	@SequenceGenerator(name = "uf_id", sequenceName = "uf_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "uf_id")
	private Long id;
	
	@NotEmpty(message="Uf: campo obrigatório.")
	@Column(name="uf", length=2)
	private String Uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUf() {
		return Uf;
	}

	public void setUf(String uf) {
		Uf = uf;
	}
}
