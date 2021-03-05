package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ControladoraVenda;
import model.dto.FaturamentoDTO;
import model.dto.VendasDTO;

public class MenuRelatorio {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_RELATORIO_VENDAS = 1;
	private static final int OPCAO_RELATORIO_FATURAMENTO = 2;
	private static final int OPCAO_RELATORIO_SAIR = 9;
	
	public void apresentarMenuRelatorios() {
		
		int opcao = this.apresentarOpcoesRelatorios();
		
		while(opcao != OPCAO_RELATORIO_SAIR) {
			switch (opcao) {
			case OPCAO_RELATORIO_VENDAS:{
				this.exibirRelatorioVendas();				
				break;
			}				
				
			case OPCAO_RELATORIO_FATURAMENTO :{
				this.exibirRelatorioFaturamento();				
				break;				
			}				

			default:{
				System.out.println("Opção Inválida!");				
				break;
			}
			}
			opcao = this.apresentarOpcoesRelatorios();
		}
		
		
	}

	private void exibirRelatorioFaturamento() {
		List<FaturamentoDTO> faturamentoDTO = new ArrayList<>();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		faturamentoDTO = controladoraVenda.exibirRelatorioFaturamento();
		
		System.out.println("---------- RESULTADO DA CONSULTA ----------");
		System.out.printf("\n%3s    %-9s  %9s \n", "MES", "ANO", "TOTAL");
		for (int i = 0; i < faturamentoDTO.size(); i++) {
			faturamentoDTO.get(i).imprimir();
			
		}
		
	}

	private void exibirRelatorioVendas() {
		List<VendasDTO> vendasDTO = new ArrayList<>();
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		vendasDTO = controladoraVenda.exibirRelatorioVendas();
		
		System.out.println("---------- RESULTADO DA CONSULTA ----------");
		System.out.printf("\n%-10s   %-10s   %-10s   %-10s   %-10s   %10s  \n",
				"NOME", "CPF", "TELEFONE", "PLACA", "DATA", "VALOR");
		
		for (int i = 0; i < vendasDTO.size(); i++) {
			vendasDTO.get(i).imprimir();
			
		}
	}

	private int apresentarOpcoesRelatorios() {
		
		System.out.println();
		System.out.println("******************");
		System.out.println("|| MENU RELATÓRIOS ||");
		System.out.println("******************");
		System.out.println("\n Opções");
		System.out.println(OPCAO_RELATORIO_VENDAS+" - Relatório de Vendas");
		System.out.println(OPCAO_RELATORIO_FATURAMENTO+" - Relatório de Faturamento");
		System.out.println(OPCAO_RELATORIO_SAIR+" - Voltar");
		System.out.print("\n Digite sua opção: ");
		int resultado = teclado.nextInt();
		
		return resultado;
	}
	
	

}
