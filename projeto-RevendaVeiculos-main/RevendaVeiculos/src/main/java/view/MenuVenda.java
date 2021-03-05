package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import controller.ControladoraVenda;
import model.vo.VendaVO;

public class MenuVenda {
	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int OPCAO_MENU_VENDA_CADASTRAR = 1;
	private static final int OPCAO_MENU_VENDA_CONSULTAR = 2;
	private static final int OPCAO_MENU_VENDA_ALTERAR = 3;
	private static final int OPCAO_MENU_VENDA_EXCLUIR = 4;
	private static final int OPCAO_MENU_VENDA_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTA_TODAS_VENDAS = 1;
	private static final int OPCAO_MENU_CONSULTA_UMA_VENDA = 2;
	private static final int OPCAO_MENU_CONSULTA_VENDAS_VOLTAR = 3;

	public void apresentarMenuVenda() {
		int opcao = this.apresentaOpcaoMenuVenda();
		while (opcao != OPCAO_MENU_VENDA_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_VENDA_CADASTRAR: {
				this.cadastrarVenda();
				break;				
			}
			case OPCAO_MENU_VENDA_CONSULTAR: {
				this.consultarVenda();
				break;				
			}
			case OPCAO_MENU_VENDA_ALTERAR: {
				this.alterarVenda();
				break;				
			}
			case OPCAO_MENU_VENDA_EXCLUIR: {
				this.excluirVenda();
				break;				
			}
			default: {
				System.out.println("Opção Inválida");
				break;				
			}				
			}
			opcao = this.apresentaOpcaoMenuVenda();
		}
	}


	private int apresentaOpcaoMenuVenda() {
		System.out.println();
		System.out.println("****************");
		System.out.println("|| MENU VENDA ||");
		System.out.println("****************");
		System.out.println(OPCAO_MENU_VENDA_CADASTRAR+"- Cadastrar Venda");
		System.out.println(OPCAO_MENU_VENDA_CONSULTAR+"- Consultar Venda");
		System.out.println(OPCAO_MENU_VENDA_ALTERAR+"- Alterar Venda");
		System.out.println(OPCAO_MENU_VENDA_EXCLUIR+"- Excluir Venda");
		System.out.println(OPCAO_MENU_VENDA_VOLTAR+"- Voltar");
		System.out.print("\n Digite a opção: ");
		
		
		return Integer.parseInt(teclado.nextLine());
	}
	

	private void cadastrarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.println();
		System.out.println("Digite o código do cliente: ");
		vendaVO.setIdcliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o código do veículo: ");
		vendaVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.println("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.cadastarVendaController(vendaVO);
		System.out.println(resultado);
		System.out.println();
	}
	

	private void alterarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.println("Digite o código da venda: ");
		vendaVO.setIdvenda(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o código do cliente: ");
		vendaVO.setIdcliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o código do veículo: ");
		vendaVO.setIdveiculo(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o valor da venda: ");
		vendaVO.setValorVenda(Double.parseDouble(teclado.nextLine()));
		System.out.println("Digite a data da venda: ");
		vendaVO.setDataVenda(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.alterarVendaController(vendaVO);
		System.out.println(resultado);
		System.out.println();
		
	}
	

	private void consultarVenda() {
		int opcao = this.apresentaMenuConsultaVenda();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		while (opcao != OPCAO_MENU_CONSULTA_VENDAS_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTA_TODAS_VENDAS:
				opcao = OPCAO_MENU_CONSULTA_VENDAS_VOLTAR;
				List<VendaVO> listaVendaVO = controladoraVenda.consultarTodasVendasController();
				System.out.println();
				System.out.println("---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n %3s   %-15s   %-15s   %-11s   %-13s \n",
						"ID", "CÓD. CLIENTE", "CÓD. VEÍCULO", "VALOR", "DATA VENDA");
				for (int i = 0; i < listaVendaVO.size(); i++) {
					listaVendaVO.get(i).imprimirVenda();
					
				}
				System.out.println();
				break;
				
			case OPCAO_MENU_CONSULTA_UMA_VENDA:
				opcao = OPCAO_MENU_CONSULTA_VENDAS_VOLTAR;
				VendaVO vendaVO = new VendaVO();
				System.out.print("Digite o código da venda: ");
				vendaVO.setIdvenda(Integer.parseInt(teclado.nextLine()));
				
				VendaVO venda = controladoraVenda.consultarUmaVenda(vendaVO);
				System.out.println();
				System.out.println("---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n %3s   %-15s   %-15s   %-11s   %-13s \n",
						"ID", "CÓD. CLIENTE", "CÓD. VEÍCULO", "VALOR", "DATA VENDA");
				venda.imprimirVenda();
				System.out.println();
				break;

			default:
				break;
			}
		}
		
	}

	


	private int apresentaMenuConsultaVenda() {
		
		System.out.println("\n ---------- Opções de Consulta ----------");
		System.out.println();
		System.out.println(OPCAO_MENU_CONSULTA_TODAS_VENDAS + " - Consultar todas as vendas");
		System.out.println(OPCAO_MENU_CONSULTA_UMA_VENDA + " - Consultar uma venda");
		System.out.println(OPCAO_MENU_CONSULTA_VENDAS_VOLTAR + " - Voltar");
		System.out.print("Digite sua escolha: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		System.out.println();
		
		return opcao;
	}


	private void excluirVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.println("Digite o código da venda: ");
		vendaVO.setIdvenda(Integer.parseInt(teclado.nextLine()));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		String resultado = controladoraVenda.excluirVendaController(vendaVO);
		System.out.println(resultado);
		System.out.println();
		
	}


}
