package br.com.zup.estrelas.maven;

import java.util.List;
import java.util.Scanner;

import br.com.zup.estrelas.maven.dao.CarroDao;
import br.com.zup.estrelas.maven.pojo.Carro;

public class ProgramaPrincipal {
	private static final String MENU_PRINCIPAL = ("========== SISTEMA CONTROLE DE CARROS (SCC) ==========\n"
			+ "[1] - Cadastrar carro \n[2] - Excluir carro \n[3] - Buscar todos os carros \n[4] - Buscar carro por placa "
			+ "\n[5] - Buscar carro por fabricante \n[0] - Sair");

	public static void cadastrarCarro(Scanner teclado) {
		teclado.nextLine();

		System.out.print("Digite o nome: ");
		String nome = teclado.nextLine();

		System.out.print("Digite a placa: ");
		String placa = teclado.nextLine();

		System.out.print("Digite a cor: ");
		String cor = teclado.nextLine();

		System.out.print("Digite o fabricante: ");
		String fabricante = teclado.nextLine();

		System.out.print("Digite o ano de fabricação: ");
		int anoFabricacao = teclado.nextInt();

		Carro carro = new Carro(placa, nome, cor, fabricante, anoFabricacao);

		CarroDao carroDao = new CarroDao();

		carroDao.inserirCarroBD(carro);
		System.out.println("Carro cadastrado com sucesso!");
	}

	public static void excluirCarro(Scanner teclado) {
		teclado.nextLine();

		System.out.print("Digite o numero da placa: ");
		String placa = teclado.nextLine();

		CarroDao carroDao = new CarroDao();

		if (carroDao.excluirCarroBD(placa)) {
			System.out.println("Carro excluido com sucesso");
		}
	}

	public static void buscarCarros() {
		CarroDao carroDao = new CarroDao();

		List<Carro> listaCarros = carroDao.buscarCarrosBD();

		for (Carro carro : listaCarros) {
			System.out.printf("Nome: %s | Placa: %s |\n", carro.getNome(), carro.getPlaca());
		}

	}

	public static void buscarCarroPorPlaca(Scanner teclado) {
		teclado.nextLine();

		System.out.print("Digite o numero da placa: ");
		String placa = teclado.nextLine();

		CarroDao carroDao = new CarroDao();

		List<Carro> listaCarros = carroDao.buscarCarroPorPlacaBD(placa);

		for (Carro carro : listaCarros) {
			System.out.printf("Nome: %s | Placa: %s |\n", carro.getNome(), carro.getPlaca());
		}

	}

	public static void buscarCarroPorFabricante(Scanner teclado) {
		teclado.nextLine();

		System.out.print("Digite o nome do fabricante: ");
		String fabricante = teclado.nextLine();

		CarroDao carroDao = new CarroDao();

		List<Carro> listaCarros = carroDao.buscarCarroPorFabricanteBD(fabricante);

		for (Carro carro : listaCarros) {
			System.out.printf("Nome: %s | Placa: %s |\n", carro.getNome(), carro.getPlaca());
		}

	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		int opcaoMenu = 0;

		do {
			System.out.println(MENU_PRINCIPAL);

			System.out.print("Escolha uma opção: ");
			opcaoMenu = teclado.nextInt();

			switch (opcaoMenu) {
			case 1:
				cadastrarCarro(teclado);
				break;

			case 2:
				excluirCarro(teclado);
				break;

			case 3:
				buscarCarros();
				break;

			case 4:
				buscarCarroPorPlaca(teclado);
				break;
				
			case 5:
				buscarCarroPorFabricante(teclado);
				break;

			case 0:
				System.out.println("Volte sempre :)");
				break;
			default:
				System.out.println("Opção invalida");
				break;
			}

		} while (opcaoMenu != 0);

		teclado.close();
	}

}
