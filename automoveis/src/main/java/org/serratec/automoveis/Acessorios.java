package org.serratec.automoveis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Acessorios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String qtdPortas;
	private Boolean cambio;
	private Boolean arCondicionado;
	
	@ManyToOne
	private AutoMoveis autoMoveis;
	
//	public AutoMoveis getAutoMoveis() {
//		return autoMoveis;
//	}
	public void setAutoMoveis(AutoMoveis autoMoveis) {
		this.autoMoveis = autoMoveis;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQtdPortas() {
		return qtdPortas;
	}
	public void setQtdPortas(String qtdPortas) {
		this.qtdPortas = qtdPortas;
	}
	public Boolean getCambio() {
		return cambio;
	}
	public void setCambio(Boolean cambio) {
		this.cambio = cambio;
	}
	public Boolean getArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(Boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	
	
}
