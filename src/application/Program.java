package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Paciente;
import entities.Vacina;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	Vacina obj = new Vacina(002, "Sinovac", "CoronaVac");
		System.out.println(obj);
		
	Paciente pac = new Paciente("000.000.000-00", "Anna", 33, "(62)98147-6589", "Rua dos malucos", "Centro", "S", new Date(), 1, "Sinovac", obj);
	System.out.println(pac);
		
	}

}
