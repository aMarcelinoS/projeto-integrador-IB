package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;
import model.entities.Vacina;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		
		PacienteDao pacientedao = DaoFactory.createPacienteDao();
		 Vacina vac = new Vacina();
		
		
		
		System.out.println();
		System.out.println("1 - Cadastrar um novo paciente; ");
		System.out.println("2 - Alterar paciente já cadastrado; ");
		System.out.println("3 - Pesquisar um paciente pelo Id;");
		System.out.println("4 - Pesquisar pacientes por vacina; ");
		System.out.println("5 - Pesquisar todos pacientes cadastrados;");
		System.out.println("6 - Deletar um paciente cadastrado. ");
		System.out.println();
		System.out.print("Informe o que deseja realizar no sistema: ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				System.out.println("========== CADASTRO DE PACIENTES ===========");
				System.out.println();
				System.out.println("Digite as informações do cliente: ");
				System.out.print("CPF: ");
				sc.nextLine();
				String cpf = sc.nextLine();
				System.out.print("Nome do paciente: ");
				String nome = sc.nextLine();
				System.out.print("Idade: ");
				int idade = sc.nextInt();
				System.out.print("Telefone com (DDD): ");
				sc.nextLine();
				String tel = sc.nextLine();
				System.out.print("Endereço Residencial: ");
				String end = sc.nextLine();
				System.out.print("Região: ");
				String reg = sc.nextLine();
				System.out.print("Paciente vacinado? (S/N): ");
				String vacina = sc.next();
				System.out.print("Data da Vacinação: ");
				Date data = sdf.parse(sc.next()); 
				System.out.print("Qual a dose ");
				int dose = sc.nextInt();
				System.out.print("Qual vacina o paciente tomou? ");
				int vacId = sc.nextInt();
				
				Paciente paciente = new Paciente(null, cpf, nome, idade, tel, end, reg, vacina, data, dose, vacId, vac);
				pacientedao.insert(paciente);
				System.out.println("Paciente cadastrado com sucesso.");				
		}
		
		
		
		
		
		
//		System.out.println("==== TEST 1: busca paciente pelo Id - findById");
//		Paciente pac = pacientedao.findById(4);
//		System.out.println(pac);
		
//		System.out.println("\n==== TEST 2: busca pacientes pelo Id da vacina - findByVacina");
//		Vacina vac = new Vacina(002, null, null);
//		List<Paciente> list = pacientedao.findByVacina(vac);
//		for (Paciente x : list) {
//			System.out.println(x);
//		}
//		
//		System.out.println("\n==== TEST 3: busca todos os pacientes no BD - findAll");
//		
//		list = pacientedao.findAll();
//		for (Paciente x : list) {
//			System.out.println(x);
//		}
//		
//		System.out.println("\n==== TEST 4: insere pacientes no BD - Insert");
//		Paciente paciente = new Paciente(null, "005.410.408-35", "Bob Silva", 32, "(67) 99801-1000", "Rua Alegre, Nº 1253, Capital", "Noroeste", "S", new Date(), 2, 004, vac);
//		pacientedao.insert(paciente);
//		System.out.println("Inserido com sucesso! Novo Id = " + paciente.getId());
//		
//		System.out.println("\n==== TEST 5: Altera dados de pacientes no BD - Update");
//		pac = pacientedao.findById(8);
//		pac.setIdVac(003);
//		pacientedao.update(pac);
//		System.out.println("Atualizado com sucesso!");
//		
//		System.out.println("\n==== TEST 6: Deleta pacientes no BD pelo Id - deleteById");
//		System.out.print("Entre com Id do paciente a ser excluído: ");
//		int id = sc.nextInt();
//		pacientedao.deleteById(id);
//		System.out.println("Deletado com sucesso!");
//		
		
		sc.close();
	}

}
