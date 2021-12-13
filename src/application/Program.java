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
		Paciente paciente = new Paciente();
		Vacina vac = new Vacina();
		
		
		
		System.out.println();
		System.out.println(" 1 - Cadastrar um novo paciente; ");
		System.out.println(" 2 - Alterar cadastro; ");
		System.out.println(" 3 - Pesquisar um paciente pelo Id;");
		System.out.println(" 4 - Pesquisar pacientes por vacina; ");
		System.out.println(" 5 - Pesquisar todos pacientes cadastrados;");
		System.out.println(" 6 - Deletar um paciente cadastrado. ");
		System.out.println();
		System.out.print("Informe o que deseja realizar no sistema: ");
		int num = sc.nextInt();
		System.out.println();
		
		switch(num) {
			case 1:
				System.out.println("==========| CADASTRO DE PACIENTES |===========");
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
				
				paciente = new Paciente(null, cpf, nome, idade, tel, end, reg, vacina, data, dose, vacId, vac);
				pacientedao.insert(paciente);
				System.out.println();
				System.out.println("Paciente cadastrado com sucesso!");
				break;
				
			case 2:
				System.out.println("==========| ALTERAÇÃO DE CADASTRO |==========");
				
				System.out.println();
				System.out.print("Informe o Id do paciente que deseja fazer alteração: ");
				int Idpac = sc.nextInt();
				paciente = pacientedao.findById(Idpac);
				System.out.println();
				System.out.println(paciente);
				
				System.out.println();
				System.out.println(" 1 - CPF");
				System.out.println(" 2 - Nome");
				System.out.println(" 3 - Idade");
				System.out.println(" 4 - Telefone");
				System.out.println(" 5 - Endereço");
				System.out.println(" 6 - Região");
				System.out.println(" 7 - Data da Vacinação");
				System.out.println(" 8 - Dose");
				System.out.println(" 9 - Id da vacina");
				System.out.println();
				System.out.print("Informe o que deseja alterar: ");				
				int num2 = sc.nextInt();
				System.out.println();
				
								
				switch(num2) {
					case 1:
						System.out.print("Digite o novo CPF: ");
						cpf = sc.next();
						
						paciente.setCpf(cpf);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo CPF atualizado!");
						break;
					
					case 2:
						System.out.print("Digite o novo nome: ");
						sc.nextLine();
						nome = sc.nextLine();
						
						paciente.setNome(nome);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo nome atualizado!");
						break;
					
					case 3:
						System.out.print("Digite a nova idade: ");
						idade = sc.nextInt();
						
						paciente.setIdade(idade);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo idade atualizado!");
						break;
						
					case 4:
						System.out.print("Digite o novo telefone: ");
						sc.nextLine();
						tel = sc.nextLine();
						
						paciente.setFone(tel);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo telefone atualizado!");
						break;
					
					case 5:
						System.out.print("Digite o novo endereço: ");
						sc.nextLine();
						end = sc.nextLine();
						
						paciente.setEndereco(end);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo endereço atualizado!");
						break;
						
					case 6:
						System.out.print("Digite a nova região: ");
						sc.nextLine();
						reg = sc.nextLine();
						
						paciente.setRegiao(reg);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo endereço atualizado!");
						break;
						
					case 7:
						System.out.print("Digite a nova data de vacinação: ");
						data = sdf.parse(sc.next());
						
						paciente.setData(data);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo data da vacinação atualizado!");
						break;
					
					case 8:
						System.out.print("Digite a novo número de dose: ");
						dose = sc.nextInt();
						
						paciente.setDose(dose);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo dose atualizado!");
						break;
					
					case 9:
						System.out.print("Digite a novo Id da vacina aplicada: ");
						vacId = sc.nextInt();
						
						paciente.setIdVac(vacId);
						
						pacientedao.update(paciente);
						System.out.println();
						System.out.println("Campo Id da vacina atualizado!");
						break;						
				}
				
			case 3:
				System.out.println("==========| PESQUISA DE PACIENTE |==========");
				
				System.out.println();
				System.out.println("Informe o Id do paciente que deseja pesquisar: ");
				int idPac = sc.nextInt();
				
				paciente = pacientedao.findById(idPac);
				System.out.println();
				System.out.println(paciente);
				break;
				
			case 4:
				System.out.println("==========| PESQUISA DE PACIENTE POR VACINA |==========");
				
				System.out.println();
				System.out.println(" 001 - CoronaVac");
				System.out.println(" 002 - AztraZeneca");
				System.out.println(" 003 - Pfizer");
				System.out.println(" 004 - Janssen");
				
				System.out.println();
				System.out.print("Informe um Id: ");				
				vacId = sc.nextInt();
				
				vac = new Vacina(vacId, null, null);
				
				System.out.println();
				List<Paciente> list = pacientedao.findByVacina(vac);
				for (Paciente x : list) {
					System.out.println(x + "\n");
				}
				
			case 5:
				System.out.println("==========| PACIENTES CADASTRADOS |==========");
				
				System.out.println();
				list = pacientedao.findAll();
				for(Paciente p : list) {
					System.out.println(p + "\n");
				}
				
		}
			
		
		
				
				
//				System.out.println("\n==== TEST 5: Altera dados de pacientes no BD - Update");
//				paciente = pacientedao.findById(6);
//				paciente.setNome("Carla Novaes");
//				pacientedao.update(paciente);
//				System.out.println("Atualizado com sucesso!");
				
	
		
		
		
		
		
		
//		System.out.println("==== TEST 1: busca paciente pelo Id - findById");
//		paciente = pacientedao.findById(12);
//		System.out.println(paciente);
		
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
//		
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
