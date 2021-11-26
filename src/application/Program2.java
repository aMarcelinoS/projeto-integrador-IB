package application;

import model.dao.DaoFactory;
import model.dao.VacinaDao;
import model.entities.Vacina;

public class Program2 {

	public static void main(String[] args) {
		
		VacinaDao vacinaDao = DaoFactory.createVacinaDao();
		
		Vacina vac = vacinaDao.findById(4);
		System.out.println(vac);
			
			

	}

}
