package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		PacienteDao pacientedao = DaoFactory.createPacienteDao();
		
		System.out.println("==== TEST 1: busca paciente pelo Id - findById");
		Paciente pac = pacientedao.findById(6);
		System.out.println(pac);
		
		System.out.println("\n==== TEST 2: busca pacientes pelo Id da vacina - findByVacina");
		Vacina vac = new Vacina(002, null, null);
		List<Paciente> list = pacientedao.findByVacina(vac);
		for (Paciente x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n==== TEST 3: busca todos os pacientes no BD - findAll");
		
		list = pacientedao.findAll();
		for (Paciente x : list) {
			System.out.println(x);
		}
		
	}

}
