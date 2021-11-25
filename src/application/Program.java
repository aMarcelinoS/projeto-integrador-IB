package application;

import java.util.Date;
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
		Vacina vac = new Vacina(004, null, null);
		List<Paciente> list = pacientedao.findByVacina(vac);
		for (Paciente x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n==== TEST 3: busca todos os pacientes no BD - findAll");
		
		list = pacientedao.findAll();
		for (Paciente x : list) {
			System.out.println(x);
		}
		
		/*System.out.println("\n==== TEST 4: insere pacientes no BD - Insert");
		Paciente paciente = new Paciente(null, "025.310.408-29", "Marcelo Soares", 32, "(67) 99801-2548", "Rua Alegre, Nº 123, Capital", "Noroeste", "S", new Date(), 2, 004, vac);
		pacientedao.insert(paciente);
		System.out.println("Inserido com sucesso! Novo Id = " + paciente.getId());*/
		
		System.out.println("\n==== TEST 5: Altera dados de pacientes no BD - Update");
		pac = pacientedao.findById(8);
		pac.setIdVac(003);
		pacientedao.update(pac);
		System.out.println("Atualizado com sucesso!");
		
		
	}

}
