package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraCliente;
import model.vo.ClienteVO;

public class MenuCliente {
	
	Scanner teclado = new Scanner(System.in);
	private static final int OPCAO_MENU_CLIENTE_CADASTRAR = 1;
	private static final int OPCAO_MENU_CLIENTE_CONSULTAR = 2;
	private static final int OPCAO_MENU_CLIENTE_ATUALIZAR = 3;
	private static final int OPCAO_MENU_CLIENTE_EXCLUIR = 4;
	private static final int OPCAO_MENU_CLIENTE_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTA_TODOS_CLIENTES =1;
	private static final int OPCAO_MENU_CONSULTA_UM_CLIENTE =2;
	private static final int OPCAO_MENU_CONSULTA_CLIENTE_VOLTAR = 3;

	public void apresentarMenuCliente() {
		int opcao = this.apresentarOpcoesMenuCliente();
		
		while (opcao != OPCAO_MENU_CLIENTE_VOLTAR ) {
			switch (opcao) {
			case OPCAO_MENU_CLIENTE_CADASTRAR : {
				this.cadastrarCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_CONSULTAR : {
				this.consultarCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_ATUALIZAR : {
				this.atualizarCliente();
				break;
			}
			case OPCAO_MENU_CLIENTE_EXCLUIR : {
				this.excluirCliente();
				break;
			}
			default :{
				System.out.println("Opção Inválida");
			}
			}
			opcao = this.apresentarOpcoesMenuCliente();
		}
	}


	private int apresentarOpcoesMenuCliente() {	
		System.out.println();
		System.out.println("******************");
		System.out.println("|| MENU CLIENTE ||");
		System.out.println("******************");
		System.out.println("\n Opções ");
		System.out.println(OPCAO_MENU_CLIENTE_CADASTRAR+"- Cadastrar Cliente");
		System.out.println(OPCAO_MENU_CLIENTE_CONSULTAR+"- Consultar Cliente");
		System.out.println(OPCAO_MENU_CLIENTE_ATUALIZAR+"- Atualizar Cliente");
		System.out.println(OPCAO_MENU_CLIENTE_EXCLUIR+"- Excluir Cliente");
		System.out.println(OPCAO_MENU_CLIENTE_VOLTAR+"- Voltar");
		System.out.println("\n Digite a opção");		
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarCliente() {
		ClienteVO clienteVO = new ClienteVO(); 
		System.out.println("Digite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("Digite o cpf do cliente: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("Digite o telefone do cliente: ");
		clienteVO.setTelefone(teclado.nextLine());
		
		ControladoraCliente controladoraCliente = new ControladoraCliente(); 
		String resultado = controladoraCliente.cadastrarClienteController(clienteVO);
		System.out.println(resultado);
		System.out.println();
		
	}
	
	private void atualizarCliente() {
		ClienteVO clienteVO = new ClienteVO(); 
		System.out.println("Digite o código do cliente: ");
		clienteVO.setIdcliente(Integer.parseInt(teclado.nextLine()));
		System.out.println("Digite o nome do cliente: ");
		clienteVO.setNome(teclado.nextLine());
		System.out.println("Digite o cpf do cliente: ");
		clienteVO.setCpf(teclado.nextLine());
		System.out.println("Digite o telefone do cliente: ");
		clienteVO.setTelefone(teclado.nextLine());
		
		ControladoraCliente controladoraCliente = new ControladoraCliente(); 
		String resultado = controladoraCliente.atualizarClienteController(clienteVO);
		System.out.println(resultado);
		System.out.println();
		
		
	}
	
	private void consultarCliente() {
		int opcao = this.apresentarOpcoesConsultaCliente();
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		while(opcao != OPCAO_MENU_CONSULTA_CLIENTE_VOLTAR) {
			switch (opcao) {
			case OPCAO_MENU_CONSULTA_TODOS_CLIENTES:
				opcao = OPCAO_MENU_CONSULTA_CLIENTE_VOLTAR;
				ArrayList<ClienteVO> listaClienteVO = controladoraCliente.consultarTodosClienteController();
				if (listaClienteVO.isEmpty()) {
					System.out.println("Não foi encontrado registro para apresentar");
				}
				System.out.println();
				System.out.println("---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n %3s   %-8s   %-6s   %-10s \n",
						"ID",  "NOME", "CPF", "TELEFONE");
				for (int i = 0; i < listaClienteVO.size(); i++) {
					listaClienteVO.get(i).imprimirCliente();					
				}								
				break;
				
			case OPCAO_MENU_CONSULTA_UM_CLIENTE: 
				opcao = OPCAO_MENU_CONSULTA_CLIENTE_VOLTAR; 
				ClienteVO clienteVO =new ClienteVO();
				System.out.println("Digite o código do cliente: ");
				clienteVO.setIdcliente(Integer.parseInt(teclado.nextLine())); 
				
				ClienteVO cliente = controladoraCliente.consultarUmCliente(clienteVO);
				if (cliente == null) {
					System.out.println("Não foi encontrado registro para apresentar");					
				}
				System.out.println();
				System.out.println("---------- RESULTADO DA CONSULTA ----------");
				System.out.printf("\n %3s   %-8s   %-6s   %-10s \n",
						"ID",  "NOME", "CPF", "TELEFONE");
				if (cliente != null) {
					cliente.imprimirCliente();
				}				
				System.out.println();
				break;

			default:
				System.out.println("Opção Inválida!");
				break;
			}
		
		}
		
		
	}



	private int apresentarOpcoesConsultaCliente() {		
		System.out.println("---------- OPÇÕES DE CONSULTA ----------");
		System.out.println(OPCAO_MENU_CONSULTA_TODOS_CLIENTES + " - Consulta todos clientes: ");
		System.out.println(OPCAO_MENU_CONSULTA_UM_CLIENTE + " - Consulta um cliente: ");
		System.out.println(OPCAO_MENU_CONSULTA_CLIENTE_VOLTAR + " - Voltar");
		System.out.println("Digite sua escolha: ");
		int opcao = Integer.parseInt(teclado.nextLine());
		return opcao;
	}


	private void excluirCliente() {
		ClienteVO clienteVO = new ClienteVO();
		System.out.println("Digite o código do cliente: ");
		clienteVO.setIdcliente(Integer.parseInt(teclado.nextLine()));
		
		ControladoraCliente controladoraCliente = new ControladoraCliente();
		String resultado = controladoraCliente.excluirClienteController(clienteVO);
		System.out.println(resultado);
		System.out.println();
		
	}


}
