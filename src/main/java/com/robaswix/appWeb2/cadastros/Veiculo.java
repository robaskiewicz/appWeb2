package com.robaswix.appWeb2.cadastros;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	
	@NotBlank(message = "Favor inserir Modelo")
	private String modelo;
	
	@NotNull(message = "Favor inserir Ano")
	private Integer ano;
	
	
	private String marca;

	@NotBlank(message = "Favor inserir Placa")
	private String placa;
	
	@ManyToOne
	private Locacao locacao;
	
	
	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "veiculo"
			)
	
	private List<Locacao> locacoes = new ArrayList<>();
	

	public List<Locacao> getLocacoes() {
		return locacoes;
	}
	
	
	@Deprecated
	protected Veiculo() {
		
	}
	public Veiculo(String tipo) {
		this.tipo = tipo;
	}
	

	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Veiculo [tipo=" + tipo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
}
