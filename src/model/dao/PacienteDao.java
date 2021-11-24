package model.dao;

import java.util.List;

import model.entities.Paciente;
import model.entities.Vacina;

public interface PacienteDao {
	void insert(Paciente obj);
	void update(Paciente obj);
	void deleteById(Integer id);
	Paciente findById(Integer id);
	List<Paciente> findAll();
	List<Paciente> findByVacina(Vacina vacina);
}
