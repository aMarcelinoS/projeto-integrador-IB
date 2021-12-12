package model.dao;

import db.DB;
import model.dao.impl.PacienteDaoJDBC;
import model.dao.impl.VacinaDaoJBDC;

public class DaoFactory {
	public static PacienteDao createPacienteDao() {
		return new PacienteDaoJDBC(DB.getConnection());
	}
	
	public static VacinaDao createVacinaDao() {
		return new VacinaDaoJBDC(DB.getConnection());
	} 
}

//CLASSE RESPONSÁVEL POR INSTANCIAR OS DAOS