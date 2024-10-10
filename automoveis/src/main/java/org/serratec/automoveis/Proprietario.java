package org.serratec.automoveis;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Proprietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo nome não pode estar vazio")
	@Size(min=3, message="O nome deve ter no minimo 3 caracteres")
	private String nome;
	private String cnh;
	private String telefone;
	
	@OneToMany(mappedBy = "proprietario")
	private List<AutoMoveis> automoveis;
	
//	public List<AutoMoveis> getAutomoveis() {
//		return automoveis;
//	}
	public void setAutomoveis(List<AutoMoveis> automoveis) {
		this.automoveis = automoveis;
	}
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
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
