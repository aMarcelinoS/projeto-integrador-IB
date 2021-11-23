package model.dao;

import java.util.List;

import model.entities.Paciente;
import model.entities.Vacina;

public interface VacinaDao {
	
	void insert(Vacina obj);
	void update(Vacina obj);
	void deleteById(Integer id);
	Paciente findById(Integer id);
	List<Paciente> findAll();	
}
