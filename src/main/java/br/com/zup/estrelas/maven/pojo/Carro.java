package br.com.zup.estrelas.maven.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	@Id
	private String placa;

	@Column(nullable = false)
	private String nome;
	private String cor;
	private String fabricante;

	@Column(name = "ano_fabricacao")
	private int anoFabricacao;

	public Carro() {

	}

	public Carro(String placa, String nome, String cor, String fabricante, int anoFabricacao) {
		this.placa = placa;
		this.nome = nome;
		this.cor = cor;
		this.fabricante = fabricante;
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
}
