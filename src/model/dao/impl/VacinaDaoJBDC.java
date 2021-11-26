package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT*FROM tbvacina WHERE Id = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();	
			if (rs.next()) {
				Vacina vac = new Vacina();
				vac.setId(rs.getInt("Id"));
				vac.setMarca(rs.getString("Marca"));
				vac.setNome(rs.getString("Nome_da_Vacina"));
				return vac;
			}
			return null;			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Vacina> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
