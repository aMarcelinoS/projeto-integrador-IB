package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.VacinaDao;
import model.entities.Vacina;

public class VacinaDaoJBDC implements VacinaDao {
	
	Connection conn;
	
	
	
	public VacinaDaoJBDC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vacina obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vacina obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vacina findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
