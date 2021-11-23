package model.dao;

import model.dao.impl.PacienteDaoJDBC;

public class DaoFactory {
	public static PacienteDao createPacienteDao() {
		return new PacienteDaoJDBC();
	}
}
