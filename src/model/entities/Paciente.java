package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Paciente implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String nome;
	private Integer idade;
	private String fone;
	private String endereco;
	private String regiao;
	private String vacinado;
	private Date data;
	private Integer dose;
	private String marca;
	
	private Vacina vacina;

	public Paciente() {
	}

	public Paciente(String cpf, String nome, Integer idade, String fone, String endereco, String regiao,
			String vacinado, Date data, Integer dose, String marca, Vacina vacina) {
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.fone = fone;
		this.endereco = endereco;
		this.regiao = regiao;
		this.vacinado = vacinado;
		this.data = data;
		this.dose = dose;
		this.marca = marca;
		this.vacina = vacina;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getVacinado() {
		return vacinado;
	}

	public void setVacinado(String vacinado) {
		this.vacinado = vacinado;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", fone=" + fone + ", endereco="
				+ endereco + ", regiao=" + regiao + ", vacinado=" + vacinado + ", data=" + data + ", dose=" + dose
				+ ", marca=" + marca + ", vacina=" + vacina + "]";
	}
}
