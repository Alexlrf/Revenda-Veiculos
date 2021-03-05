package controller;

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

import java.util.List;

import model.bo.VendaBO;
import model.dto.FaturamentoDTO;
import model.dto.VendasDTO;
import model.vo.VendaVO;

public class ControladoraVenda {
	// DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
	public String cadastarVendaController(VendaVO vendaVO) {		
		VendaBO vendaBO = new VendaBO();
		return vendaBO.cadastrarVendaBO(vendaVO);
		
	}

	public String excluirVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.excluirVendaBO(vendaVO);
	}

	public String alterarVendaController(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.alterarVendaBO(vendaVO);
	}

	public List<VendaVO> consultarTodasVendasController() {
		VendaBO vendaBO = new VendaBO();		
		return vendaBO.consultarTodasVendas();
		/* ArrayList<VendaVO> listaVendas = new ArrayList<>();
		VendaVO venda1 = new VendaVO (1, 1, 1, 85000.00, LocalDate.parse("22/10/2019",dataFormatter));
		VendaVO venda2 = new VendaVO (2, 2, 2, 65000.00, LocalDate.parse("08/03/2019",dataFormatter));
		VendaVO venda3 = new VendaVO (3, 3, 3, 50000.00, LocalDate.parse("23/05/2019",dataFormatter));
		listaVendas.add(venda1);
		listaVendas.add(venda2);
		listaVendas.add(venda3);*/
	}

	public VendaVO consultarUmaVenda(VendaVO vendaVO) {
		VendaBO vendaBO = new VendaBO();				
		return vendaBO.consultarUmaVenda(vendaVO);
	}

	public List<FaturamentoDTO> exibirRelatorioFaturamento() {
		VendaBO vendaBO = new VendaBO();		
		return vendaBO.exibirRelatorioFaturamentoBO();
		
	}

	public List<VendasDTO> exibirRelatorioVendas() {
		VendaBO vendaBO = new VendaBO();
		return vendaBO.exibirRelatorioVendas();
	}

	

	

}
