package application;

import java.util.LinkedList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Vacina;

public class Program2 {

	public static void main(String[] args) {
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();
		
		System.out.println("==== TEST 1: busca paciente pelo Id - findById");
		Vacina vac = vacinaDao.findById(4);
		System.out.println(vac);
		
		System.out.println("\n==== TEST 2: busca todos os pacientes no BD - findAll");
		List<Vacina> vacina = new LinkedList<>();
		vacina = vacinaDao.findAll();
		System.out.println(vacina);	
		
		System.out.println("\n==== TEST 3: insere pacientes imunizados no BD - insert");
		vac = new Vacina (null, "Covax", "Covaxin");
		vacinaDao.insert(vac);
		System.out.println("Inserido com sucesso!" + "Id Nº: " + vac.getId());
			

	}

}
