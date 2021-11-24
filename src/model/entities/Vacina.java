package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vacina implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String marca;
	private String nome;
	
	List<Vacina> list = new ArrayList<>();
	
	
	public Vacina() {
	}
	
	public Vacina(Integer id, String marca, String nome) {
		this.id = id;
		this.marca = marca;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		Vacina other = (Vacina) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id=" + id + ", marca=" + marca + ", nome=" + nome + "]";
	}
	
	
}


