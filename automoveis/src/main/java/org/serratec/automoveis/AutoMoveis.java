package org.serratec.automoveis;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;

@Entity
public class AutoMoveis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private String modelo;
	
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	
	@Enumerated(EnumType.STRING)
	private Marca marca;
	
	@Enumerated(EnumType.STRING)
	private Cor cor;
	
	@Past(message = "A data de fabricação não pode ser superior a data de hoje")
	private LocalDate anoFabricacao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Proprietario proprietario;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Acessorios> acessorios;
	
	public List<Acessorios> getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(List<Acessorios> acessorios) {
		this.acessorios = acessorios;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public LocalDate getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(LocalDate anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
}
