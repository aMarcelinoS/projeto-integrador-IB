package application;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;

public class Program {

	public static void main(String[] args) {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	//Vacina obj = new Vacina(002, "Sinovac", "CoronaVac");
	//System.out.println(obj);
	
	//Paciente pac = new Paciente(001, "02489571040", "Anna",22, "(65)99344-2265", "Rua girassol, 1080", "Central","S", new Date(), 1, 002, obj);
	//System.out.println(pac);	
	
	
	PacienteDao pacientedao = DaoFactory.createPacienteDao();
	
	Paciente pac = pacientedao.findById(6);
	System.out.println(pac);
		
	
		
	}

}
