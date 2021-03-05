package model.bo;

import java.util.ArrayList;

import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO {

	public String cadastrarClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if (clienteDAO.verificarCliente(clienteVO.getCpf())) {
			retorno = "\n Cliente já cadastrado!";			
		} else {
			int resultado = clienteDAO.cadastrarClienteDAO(clienteVO);
			if (resultado == 1) {				
				retorno = "\n Cliente cadastrado com sucesso!";				
			} else {
				retorno = "\n Não foi possível cadastrar o cliente!";
			}
		}
		return retorno;
	}

	public String excluirClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();		
		if (clienteDAO.verificarClientePorId(clienteVO.getIdcliente())) {
			int resultado = clienteDAO.excluirClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\n Cliente excluído com sucesso!";
				
			}else {
				retorno = "\n Não foi possível excluir cliente!";
			}
			
		}else {
			retorno = "\n Cliente não encontrado no banco!";	 
		}
		return retorno;
	}

	public String atualizarClienteBO(ClienteVO clienteVO) {
		String retorno;
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if (clienteDAO.verificarClientePorId(clienteVO.getIdcliente())) {
			int resultado = clienteDAO.atualizarClienteDAO(clienteVO);
			if (resultado == 1) {
				retorno = "\n Cliente atualizado com sucesso!";				
			} else {
				retorno = "\n Não foi possível atualizar cliente!";
			}
			
		} else {
			retorno = "\n Cliente não está registrado no banco!";
		}		
		return retorno;
	}

	public ArrayList<ClienteVO> consultarTodosClientesBO() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarTodosClientesDAO();
	}

	public ClienteVO consultarUmClienteBO(ClienteVO clienteVO) {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.consultarUmCliente(clienteVO);
	}

}
