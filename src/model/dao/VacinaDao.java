package model.dao;

import java.util.List;

import model.entities.Vacina;

public interface VacinaDao {
	
	void insert(Vacina obj);
	void update(Vacina obj);
	void deleteById(Integer id);
	Vacina findById(Integer id);
	List<Vacina> findAll();	
}
