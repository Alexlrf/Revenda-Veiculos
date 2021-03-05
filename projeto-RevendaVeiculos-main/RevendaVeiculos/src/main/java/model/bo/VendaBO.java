package model.bo;

import java.util.List;
import model.dao.VendaDAO;
import model.dto.FaturamentoDTO;
import model.dto.VendasDTO;
import model.vo.VendaVO;

public class VendaBO {

	public String cadastrarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		String resultado = null;
		if (vendaDAO.cadastrarVendaDAO(vendaVO) == 1) {
			 resultado = "\n Venda Cadastrada com sucesso!";
			
		}else {
			resultado = "\n Venda não cadastrada!"; 
		}		
		return resultado;
	}

	public String excluirVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		String resultado = null;
		if (vendaDAO.consultarIdVenda(vendaVO)) {
			if (vendaDAO.excluirVendaDAO(vendaVO) == 1) {
				resultado = "\n Venda excluída com sucesso!";
			}else {
				resultado = "\n Exclusão não realizada!";
			}
			
		} else {
			resultado = "\n Venda não consta no banco de dados!";

		}
		return resultado;
	}

	public String alterarVendaBO(VendaVO vendaVO) {
		String retorno;
		VendaDAO vendaDAO = new VendaDAO();
		
		if (vendaDAO.consultarIdVenda(vendaVO)) {
			int resultado = vendaDAO.atualizarVendaDAO(vendaVO);
			if (resultado == 1) {
				retorno = "\n Venda atualizado com sucesso!";				
			} else {
				retorno = "\n Não foi possível atualizar venda!";
			}
			
		} else {
			retorno = "\n Venda não está registrado no banco!";
		}		
		return retorno;
	}

	public List<VendaVO> consultarTodasVendas() {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarTodasVendas();
	}

	public VendaVO consultarUmaVenda(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.consultarUmaVenda(vendaVO);
	}

	public List<FaturamentoDTO> exibirRelatorioFaturamentoBO() {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.exibirRelatorioFaturamentoDAO();
	}

	public List<VendasDTO> exibirRelatorioVendas() {
		VendaDAO vendaDAO = new VendaDAO();
		return vendaDAO.exibirRelatorioVendas();		
	}

}
