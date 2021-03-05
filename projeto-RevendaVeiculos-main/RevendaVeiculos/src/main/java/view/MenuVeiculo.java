package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraVeiculo;
import model.vo.TipoVeiculo;
import model.vo.VeiculoVO;

public class MenuVeiculo {
	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_VEICULO_CADASTRAR = 1;
	private static final int OPCAO_MENU_VEICULO_CONSULTAR = 2;
	private static final int OPCAO_MENU_VEICULO_ALTERAR = 3;
	private static final int OPCAO_MENU_VEICULO_EXCLUIR = 4;
	private static final int OPCAO_MENU_VEICULO_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTA_TODOS_VEICULOS =1;
	private static final int OPCAO_MENU_CONSULTA_UM_VEICULO =2;
	private static final int OPCAO_MENU_CONSULTA_VEICULOS_VOLTAR =3;
	
	private static final int OPCAO_VEICULO_CARRO = 1;
	private static final int OPCAO_VEICULO_MOTO = 2;
	private static final int OPCAO_VEICULO_SUV = 3;
	private static final int OPCAO_VEICULO_SAIR = 99;
	
	

	public void apresentarMenuVeiculo() {
		int opcao = this.apresentarOpcoesMenuVeiculo();
		while (opcao != OPCAO_MENU_VEICULO_VOLTAR ) {
			switch (opcao) {
			case OPCAO_MENU_VEICULO_CADASTRAR:{
				this.cadastrarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_CONSULTAR:{
				this.consultarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_ALTERAR:{
				this.atualizarVeiculo();
				break;
			}
			case OPCAO_MENU_VEICULO_EXCLUIR:{
				this.excluirVeiculo();
				break;
			}			
			default:{
				System.out.println("Opção Inválida");
				break;
			}				
			}
			opcao = this.apresentarOpcoesMenuVeiculo();			
		}
	}


	
	private int apresentarOpcoesMenuVeiculo() {
		System.out.println();
		System.out.println("******************");
		System.out.println("|| MENU VEÍCULO ||");
		System.out.println("******************");
		System.out.println("\n Opções ");
		System.out.println(OPCAO_MENU_VEICULO_CADASTRAR+"- Cadastrar Veículo");
		System.out.println(OPCAO_MENU_VEICULO_CONSULTAR+"- Consultar Veículo");
		System.out.println(OPCAO_MENU_VEICULO_ALTERAR+"- Alterar Veículo");
		System.out.println(OPCAO_MENU_VEICULO_EXCLUIR+"- Excluir Veículo");
		System.out.println(OPCAO_MENU_VEICULO_VOLTAR+"- Voltar");
		System.out.println("\n Digite a opção ");
		
		return Integer.parseInt(teclado.nextLine());
	}
	

	private void cadastrarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.print("\n Digite o modelo do veículo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.print("Digite o tipo do veículo");
		int opcao = this.apresentarOpcoesTipoVeiculo();		
		while (opcao != OPCAO_VEICULO_SAIR ) {
			switch (opcao) {
				case OPCAO_VEICULO_CARRO: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.CARRO);
					break;
				}				
				case OPCAO_VEICULO_MOTO: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.MOTO);
					break;
				}
				case OPCAO_VEICULO_SUV: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.SUV);
					break;
				}
				default: {
					System.out.println("\n Opção Inválida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
					break;
				}	
			}			
		}
		System.out.print("\n Digite o fabricante do veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.print("\n Digite o ano do veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.print("\n Digite a cor do veículo: ");
		veiculoVO.setCor(teclado.nextLine());		
		System.out.print("\n Digite a placa do veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.cadastrarVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
	}

	private int apresentarOpcoesTipoVeiculo() {
		System.out.println("OPÇÕES ");
		System.out.println(OPCAO_VEICULO_CARRO+" - CARRO");
		System.out.println(OPCAO_VEICULO_MOTO+" - MOTO");
		System.out.println(OPCAO_VEICULO_SUV+" - SUV");
		System.out.print("\n Digite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
	
	private void atualizarVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		
		System.out.print("\n Digite o código do veículo: ");
		veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o modelo do veículo: ");
		veiculoVO.setModelo(teclado.nextLine());
		System.out.println("Digite o tipo do veículo");
		int opcao = this.apresentarOpcoesTipoVeiculo();		
		while (opcao != OPCAO_VEICULO_SAIR ) {
			switch (opcao) {
				case OPCAO_VEICULO_CARRO: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.CARRO);
					break;
				}				
				case OPCAO_VEICULO_MOTO: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.MOTO);
					break;
				}
				case OPCAO_VEICULO_SUV: {
					opcao = OPCAO_VEICULO_SAIR;
					veiculoVO.setTipo(TipoVeiculo.SUV);
					break;
				}
				default: {
					System.out.println("\n Opção Inválida!");
					opcao = this.apresentarOpcoesTipoVeiculo();
					break;
				}	
			}			
		}
		System.out.println("\n Digite o fabricante do veículo: ");
		veiculoVO.setFabricante(teclado.nextLine());
		System.out.println("\n Digite o ano do veículo: ");
		veiculoVO.setAno(Integer.parseInt(teclado.nextLine()));
		System.out.println("\n Digite a cor do veículo: ");
		veiculoVO.setCor(teclado.nextLine());		
		System.out.println("\n Digite a placa do veículo: ");
		veiculoVO.setPlaca(teclado.nextLine());
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.atualizarVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
		
	}
	
	private void consultarVeiculo() {
		int opcao = this.apresentarOpcoesMenuConsulta();
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		while(opcao != OPCAO_MENU_CONSULTA_VEICULOS_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTA_TODOS_VEICULOS:
				opcao = OPCAO_MENU_CONSULTA_VEICULOS_VOLTAR;
				ArrayList<VeiculoVO> listaVeiculoVO = controladoraVeiculo.consultarTodosVeiculosController();
				if (listaVeiculoVO.isEmpty()) {
					System.out.println("Não foi encontrada lista");
				}
				System.out.println("---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s \n",
						"ID", "MODELO", "TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
				for (int i = 0; i < listaVeiculoVO.size(); i++) {
					listaVeiculoVO.get(i).imprimir();					
				}
				//System.out.println();
				break;
				
			case OPCAO_MENU_CONSULTA_UM_VEICULO:
				opcao = OPCAO_MENU_CONSULTA_VEICULOS_VOLTAR;
				VeiculoVO veiculoVO = new VeiculoVO();
				System.out.println("\n Digite o código do Veículo: ");
				veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
				
				VeiculoVO veiculo = controladoraVeiculo.consultarVeiculoController(veiculoVO);
				if (veiculo.getPlaca() == null) {
					System.out.println("Não foi encontrado veículo");
				}else {
					System.out.println("---------- RESULTADO DA CONSULTA ----------");
					System.out.printf("\n%3s   %-10s   %-10s   %-10s   %-5s   %-10s   %-10s \n",
							"ID", "MODELO", "TIPO", "FABRICANTE", "ANO", "COR", "PLACA");
				veiculo.imprimir();
				}
				System.out.println();
				
				break;

			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}


	private int apresentarOpcoesMenuConsulta() {
		System.out.println("---------- OPÇÕES DE CONSULTA ----------");
		System.out.println(OPCAO_MENU_CONSULTA_TODOS_VEICULOS + "- Consulta todos Veículos");
		System.out.println(OPCAO_MENU_CONSULTA_UM_VEICULO + "- Consulta um Veículo");
		System.out.println(OPCAO_MENU_CONSULTA_VEICULOS_VOLTAR + "- Voltar");
		System.out.println("Digite sua escolha");
		int opcao = Integer.parseInt(teclado.nextLine());
		
		return opcao;
	}


	private void excluirVeiculo() {
		VeiculoVO veiculoVO = new VeiculoVO();
		System.out.println("\n Digite o código do veículo: ");
		veiculoVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVeiculo controladoraVeiculo = new ControladoraVeiculo();
		String resultado = controladoraVeiculo.excluirVeiculoController(veiculoVO);
		System.out.println(resultado);
		System.out.println();
	}

}
