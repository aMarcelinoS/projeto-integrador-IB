package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Connection conn;
	
	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	//MÉTODO PARA INSERIR NOVOS PACIENTES
	@Override
	public void insert(Paciente obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement( 
					"INSERT INTO tbpaciente "
					+ "(CPF, Nome, Idade, Telefone, Endereço, Regiao, Vacinado, Data_da_Vacinacao, Dose, Id_Vacina) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
						
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNome());
			st.setInt(3, obj.getIdade());
			st.setString(4, obj.getFone());
			st.setString(5, obj.getEndereco());
			st.setString(6, obj.getRegiao());
			st.setString(7, obj.getVacinado());
			st.setDate(8, new java.sql.Date(obj.getData().getTime()));
			st.setInt(9, obj.getDose());
			st.setInt(10, obj.getIdVac());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
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
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	//MÉTODO PARA ALTERAR DADOS DOS PACIENTES
	@Override
	public void update(Paciente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"UPDATE tbpaciente SET CPF = ?, Nome = ?, Idade = ?, Telefone = ?, Endereço = ?, "
					+ "Regiao = ?, Vacinado = ?, Data_da_Vacinacao = ?, Dose = ?, Id_Vacina = ? "
					+ "WHERE tbpaciente.Id = ? ");
			
			st.setString(1, obj.getCpf());
			st.setString(2, obj.getNome());
			st.setInt(3, obj.getIdade());
			st.setString(4, obj.getFone());
			st.setString(5, obj.getEndereco());
			st.setString(6, obj.getRegiao());
			st.setString(7, obj.getVacinado());
			st.setDate(8, new java.sql.Date(obj.getData().getTime()));
			st.setInt(9, obj.getDose());
			st.setInt(10, obj.getIdVac());
			st.setInt(11, obj.getId());
			
			st.executeUpdate();			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}		
	}

	//MÉTODO PARA DELETAR UM PACIENTE COM SEUS DADOS PELO ID
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tbpaciente WHERE Id = ? ");
			
			st.setInt(1, id);			
			st.executeUpdate();			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}		
	}
	
	//MÉTODO PARA BUSCAR NO BANCO DE DADOS UM PACIENTE PELO O ID 
	@Override
	public Paciente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {			
			st = conn.prepareStatement(
					"SELECT tbpaciente.*,tbvacina.Marca, tbvacina.Nome_da_Vacina "
					+ "FROM tbpaciente INNER JOIN tbvacina "
					+ "ON tbpaciente.Id_Vacina = tbvacina.Id "
					+ "WHERE tbpaciente.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Vacina vac = instantiateVacina(rs);
				Paciente pac = instantiatePaciente(rs, vac);
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

	//MÉTODO PARA BUSCAR TODOS OS PACIENTES NO BANCO DE DADOS
	@Override
	public List<Paciente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT tbpaciente.*, tbvacina.Marca, tbvacina.Nome_da_Vacina "
					+ "FROM tbpaciente INNER JOIN tbvacina "
					+ "ON tbpaciente.Id_Vacina = tbvacina.Id "
					+ "ORDER BY Nome");
			
			rs = st.executeQuery();
			
			List<Paciente> list = new ArrayList<>();
			Map<Integer, Vacina> map = new HashMap<>();

			while(rs.next()) {
				Vacina vac = map.get(rs.getInt("Id_Vacina"));
				if(vac == null) {					
					vac = instantiateVacina(rs);
					map.put(rs.getInt("Id_Vacina"), vac);
				}
				Paciente pac = instantiatePaciente(rs, vac);
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
	
	//MÉTODO PARA BUSCAR NO BANCO DE DADOS PACIENTES QUE FORAM VACINADAS POR UMA DETERMINADA VACINA
	@Override
	public List<Paciente> findByVacina(Vacina vacina) {
		PreparedStatement st = null;
		ResultSet rs = null;		
		try {
			st = conn.prepareStatement(
					"SELECT tbpaciente.*, tbvacina.Marca, tbvacina.Nome_da_Vacina "
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
					vac = instantiateVacina(rs);
					map.put(rs.getInt("Id_Vacina"), vac);
				}
				Paciente pac = instantiatePaciente(rs, vac);
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
	
	//FUNÇÃO AUXILIAR PARA INSTANCIAR A CLASSE PACIENTE
	private Paciente instantiatePaciente(ResultSet rs, Vacina vac) throws SQLException {
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
	
	//FUNÇÃO AUXILIAR PARA INSTANCIAR A CLASSE VACINA
	private Vacina instantiateVacina(ResultSet rs) throws SQLException {
		Vacina vac = new Vacina();
		vac.setId(rs.getInt("Id_Vacina"));
		vac.setMarca(rs.getString("Marca"));
		vac.setNome(rs.getString("Nome_da_Vacina"));
		return vac;
	}	
}
