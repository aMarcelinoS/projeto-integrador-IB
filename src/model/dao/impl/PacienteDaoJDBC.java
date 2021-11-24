package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.PacienteDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class PacienteDaoJDBC implements PacienteDao {
	
	private Connection conn;
	
	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Paciente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Paciente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {			
			st = conn.prepareStatement
					("SELECT tbpaciente.*,tbvacina.Marca, tbvacina.Nome_da_Vacina "
					+ "FROM tbpaciente INNER JOIN tbvacina "
					+ "ON tbpaciente.Id_Vacina = tbvacina.Id "
					+ "WHERE tbpaciente.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Vacina vac = new Vacina();
				vac.setId(rs.getInt("Id_Vacina"));
				vac.setMarca(rs.getString("Marca"));
				vac.setNome(rs.getString("Nome_da_Vacina"));
				Paciente pac = new Paciente();
				pac.setId(rs.getInt("Id"));
				pac.setCpf(rs.getString("CPF"));
				pac.setNome(rs.getString("Nome"));
				pac.setIdade(rs.getInt("Idade"));
				pac.setFone(rs.getString("Telefone"));
				pac.setEndereco(rs.getString("Endereço"));
				pac.setRegiao(rs.getString("Regiao"));
				pac.setVacinado(rs.getString("Vacinado"));
				pac.setData(rs.getDate("Data_da_Vacinacao"));
				pac.setDose(rs.getInt("Dose"));
				pac.setVacina(vac);
				return pac;
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
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> findByVacina(Vacina vacina) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement
					("SELECT tbpaciente.*, tbvacina.Marca, tbvacina.Nome_da_Vacina "
					 + "FROM tbpaciente INNER JOIN tbvacina "
					 + "ON tbpaciente.Id_Vacina = tbvacina.Id "
					 + "WHERE Id_Vacina = ? "
					 + "ORDER BY Nome");
			
			st.setInt(1, vacina.getId());
			
			rs = st.executeQuery();
			
			List<Paciente> list = new ArrayList<>();
			Map<Integer, Vacina> map = new HashMap<>();
			
			while(rs.next()) {
				
				Vacina vac = map.get(rs.getInt("Id_Vacina"));
				
				if(vac == null) {					
				vac = new Vacina();
				vac.setId(rs.getInt("Id_Vacina"));
				vac.setMarca(rs.getString("Marca"));
				vac.setNome(rs.getString("Nome_da_Vacina"));
				map.put(rs.getInt("Id_Vacina"), vac);
				}
				Paciente pac = new Paciente();
				pac.setId(rs.getInt("Id"));
				pac.setCpf(rs.getString("CPF"));
				pac.setNome(rs.getString("Nome"));
				pac.setIdade(rs.getInt("Idade"));
				pac.setFone(rs.getString("Telefone"));
				pac.setEndereco(rs.getString("Endereço"));
				pac.setRegiao(rs.getString("Regiao"));
				pac.setVacinado(rs.getString("Vacinado"));
				pac.setData(rs.getDate("Data_da_Vacinacao"));
				pac.setDose(rs.getInt("Dose"));
				pac.setVacina(vac);
				list.add(pac);
				
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
