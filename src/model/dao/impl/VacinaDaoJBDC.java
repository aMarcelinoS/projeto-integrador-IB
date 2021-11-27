package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO tbvacina (Marca, Nome_da_Vacina) "
					+ "VALUES "
					+ "(?, ?)", 
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getMarca());
			st.setString(2, obj.getNome());

			int rowsAffected = st.executeUpdate();

			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro inesperado! Nenhuma linha foi afetada!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Vacina obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE tbvacina SET Marca = ?, Nome_da_Vacina = ? "
					+ "WHERE tbvacina.Id = ?");
			
			st.setString(1, obj.getMarca());
			st.setString(2, obj.getNome());
			st.setInt(3, obj.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tbvacina WHERE Id = ? ");
			
			st.setInt(1, id);			
			st.executeUpdate();
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tbvacina");
			
			rs = st.executeQuery();
			
			List<Vacina> list = new LinkedList<Vacina>();
			
			while(rs.next()) {
				Vacina vac = new Vacina();
				vac.setId(rs.getInt("Id"));
				vac.setMarca(rs.getString("Marca"));
				vac.setNome(rs.getString("Nome_da_Vacina"));
				list.add(vac);
			}
			return list;				
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
