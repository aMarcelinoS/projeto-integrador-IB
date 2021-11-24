package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	//Vacina obj = new Vacina(002, "Sinovac", "CoronaVac");
	//System.out.println(obj);
	
	//Paciente pac = new Paciente(001, "02489571040", "Anna",22, "(65)99344-2265", "Rua girassol, 1080", "Central","S", new Date(), 1, 002, obj);
	//System.out.println(pac);	
	
	
	PacienteDao pacientedao = DaoFactory.createPacienteDao();
	
	System.out.println("==== TEST 1: busca paciente pelo Id");
	Paciente pac = pacientedao.findById(6);
	System.out.println(pac);
	
	System.out.println("\n==== TEST 2: busca pacientes pelo Id da vacina");
	Vacina vac = new Vacina(002, null, null);
	List<Paciente> list = pacientedao.findByVacina(vac);
	for (Paciente x : list) {
		System.out.println(x);
	}
		
	}

}
