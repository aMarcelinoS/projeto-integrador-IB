package entities;

import java.io.Serializable;
import java.util.Objects;

public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	private String marca;
	private String nome;
	
	public Vacina(Integer id, String marca, String nome) {
		Id = id;
		this.marca = marca;
		this.nome = nome;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacina other = (Vacina) obj;
		return Objects.equals(Id, other.Id);
	}
	
	@Override
	public String toString() {
		return "Vacina [Id=" + Id + ", marca=" + marca + ", nome=" + nome + "]";
	}
	
	
}


