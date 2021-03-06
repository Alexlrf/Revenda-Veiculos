package controller;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.vo.ClienteVO;

public class ControladoraCliente {

	public String cadastrarClienteController(ClienteVO clienteVO) {		
		ClienteBO clienteBO = new ClienteBO();		
		return clienteBO.cadastrarClienteBO(clienteVO);
	}

	public String excluirClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();		
		return clienteBO.excluirClienteBO(clienteVO);
	}

	public String atualizarClienteController(ClienteVO clienteVO) {
		ClienteBO clienteBO = new ClienteBO();		
		return clienteBO.atualizarClienteBO(clienteVO);
	}
	
	public ArrayList<ClienteVO> consultarTodosClienteController() {		
		ClienteBO clienteBO = new ClienteBO();		
		return clienteBO.consultarTodosClientesBO();
	}

	public ClienteVO consultarUmCliente(ClienteVO clienteVO) {		
		ClienteBO clienteBO = new ClienteBO();
		return clienteBO.consultarUmClienteBO(clienteVO);
	}

	

}
