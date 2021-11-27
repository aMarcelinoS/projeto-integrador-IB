package application;

import java.util.LinkedList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Vacina;

public class Program2 {

	public static void main(String[] args) {
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();
		
		System.out.println("==== TEST 1: busca vacinas pelo Id - findById");
		Vacina vac = vacinaDao.findById(4);
		System.out.println(vac);
		
		System.out.println("\n==== TEST 2: busca vacinas cadastradas no BD - findAll");
		List<Vacina> vacina = new LinkedList<>();
		vacina = vacinaDao.findAll();
		System.out.println(vacina);	
		
		System.out.println("\n==== TEST 3: insere novas vacinas no BD - insert");
		vac = new Vacina (null, "Covax", "Covaxin");
		//vacinaDao.insert(vac);
		System.out.println("Inserido com sucesso!" + "Id Nº: " + vac.getId());			
		
		System.out.println("\n==== TEST 4: altera dados da vacina no BD - update");
		vac = vacinaDao.findById(5);
		vac.setMarca("Covax/India");
		vacinaDao.update(vac);
		System.out.println("Atualizado com sucesso!");
		
	}

}
